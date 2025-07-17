package com.lojaSapatos.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lojaSapatos.enums.ShoeColor;
import com.lojaSapatos.model.Shoe;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;

@Service
public class PdfService {

    private final ShoeService shoeService;

    public PdfService(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    public void createPDF(String fileName, String content) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();

            createHeader(doc);
            addLineSeparator(doc);
            createBodyPDF(doc, "Este é um relatório completo contendo todos os registros presentes na base de dados da NETSHOE©. " +
                    "O objetivo deste documento é apresentar, de forma clara e organizada, os dados dos produtos atualmente cadastrados " +
                    "no sistema, incluindo informações como nome, marca, tamanho, cor e demais atributos relevantes. " +
                    "Esses dados são essenciais para o controle de estoque, análise de vendas e suporte à tomada de decisões estratégicas " +
                    "por parte da equipe de gestão.");

            // Conteúdo principal
            Paragraph paragraph = new Paragraph(content);
            doc.add(paragraph);

            addLineSeparator(doc);

            // Busca a lista de sapatos e cria a tabela
            List<Shoe> shoes = shoeService.listAll();
            createTablesPDF(doc, shoes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }

    private void createHeader(Document doc) throws DocumentException {
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
        Paragraph header = new Paragraph("Relatório NETSHOE", headerFont);
        header.setAlignment(Element.ALIGN_CENTER);
        header.setSpacingAfter(15f);
        doc.add(header);
    }

    //Cria o conteúdo principal da página
    private void createBodyPDF(Document doc, String desc) throws DocumentException {
        Font bodyFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);

        Paragraph bodyContent = new Paragraph(desc, bodyFont);
        bodyContent.setAlignment(Element.ALIGN_JUSTIFIED);

        bodyContent.setSpacingBefore(10f);
        bodyContent.setSpacingAfter(10f);

        doc.add(bodyContent);
    }

    // Cria a tabela de conteúdo
    private void createTablesPDF(Document doc, List<Shoe> shoes) throws DocumentException {
        // Título da seção
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
        Paragraph title = new Paragraph("LISTA DE REGISTROS", titleFont);
        title.setSpacingBefore(10f);
        title.setSpacingAfter(10f);
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);

        // Colunas da tabela
        PdfPTable table = new PdfPTable(4); // Nome, Marca, Tamanho
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);

        // Cabeçalhos da tabela
        addTableHeader(table, "ID" ,"NAME" , "BRAND", "SIZE");

        shoes.forEach(shoe -> {
            table.addCell(String.valueOf(shoe.getId()));
            table.addCell(shoe.getName());
            table.addCell(shoe.getBrand());
            table.addCell(String.valueOf(shoe.getSize()));
        });

        doc.add(table);
    }

    private void addTableHeader(PdfPTable table, String... headers) {
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
        BaseColor bgColor = BaseColor.DARK_GRAY;

        for (String headerTitle : headers) {
            PdfPCell header = new PdfPCell(new Phrase(headerTitle, headerFont));
            header.setBackgroundColor(bgColor);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setPadding(5f);
            table.addCell(header);
        }
    }

    // Cria a(s) divisória do documento
    private void addLineSeparator(Document doc) throws DocumentException {
        Paragraph lineSeparator = new Paragraph("---------------------------------------------------------------------");
        lineSeparator.setAlignment(Element.ALIGN_CENTER);
        doc.add(lineSeparator);
    }
}
