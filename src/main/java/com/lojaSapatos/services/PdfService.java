package com.lojaSapatos.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class PdfService {

    public void createPDF(String fileName, String content) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();

            // Header simples (centralizado)
            Paragraph header = new Paragraph("Relatório de Tênis");
            header.setAlignment(Element.ALIGN_CENTER);
            header.setSpacingAfter(15f); // Espaço após o cabeçalho
            doc.add(header);

            // Conteúdo principal
            Paragraph paragraph = new Paragraph(content);
            doc.add(paragraph);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }

}
