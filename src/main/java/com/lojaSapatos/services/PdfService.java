package com.lojaSapatos.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class PdfService {

    // Construtor padrão (caso queira instanciar manualmente sem Spring)
    public PdfService() {}

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

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }

    private void createHeader(Document doc) throws DocumentException {
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
        Paragraph header = new Paragraph("Relatório NETSHOE",headerFont);
        header.setAlignment(Element.ALIGN_CENTER);
        header.setSpacingAfter(15f);
        doc.add(header);
    }

    private void createBodyPDF(Document doc,String desc) throws DocumentException {
        Font bodyFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);

        Paragraph bodyContent = new Paragraph(desc,bodyFont);
        bodyContent.setAlignment(Element.ALIGN_JUSTIFIED);

        bodyContent.setSpacingBefore(10f);
        bodyContent.setSpacingAfter(10f);

        doc.add(bodyContent);
    }

    //Cria a(s) divisória do documento
    private void addLineSeparator(Document doc) throws DocumentException {
        Paragraph lineSeparator  = new Paragraph("---------------------------------------------------------------------");
        lineSeparator.setAlignment(Element.ALIGN_CENTER);
        doc.add(lineSeparator);
    }

}
