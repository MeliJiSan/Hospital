/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaHospital;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GeneradorPDF {

    public static boolean generarRecetaPDF(Paciente paciente, Receta receta,
                                            List<DetalleReceta> medicamentos, String rutaSalida) {
        try (PDDocument doc = new PDDocument()) {
            PDPage pagina = new PDPage();
            doc.addPage(pagina);

            PDType1Font fuenteTitulo = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
            PDType1Font fuenteTexto = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

            try (PDPageContentStream contenido = new PDPageContentStream(doc, pagina)) {
                float y = 750;
                float margenIzq = 50;

                contenido.beginText();
                contenido.setFont(fuenteTitulo, 16);
                contenido.newLineAtOffset(margenIzq, y);
                contenido.showText("Receta Medica");
                contenido.endText();
                y -= 30;

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                contenido.beginText();
                contenido.setFont(fuenteTexto, 11);
                contenido.newLineAtOffset(margenIzq, y);
                contenido.showText("Paciente: " + paciente.getNombre() + " " + paciente.getApPat() + " " + paciente.getApMat());
                contenido.endText();
                y -= 18;

                contenido.beginText();
                contenido.setFont(fuenteTexto, 11);
                contenido.newLineAtOffset(margenIzq, y);
                contenido.showText("Fecha de emision: " + formato.format(receta.getFechaEmision()));
                contenido.endText();
                y -= 25;

                contenido.beginText();
                contenido.setFont(fuenteTitulo, 12);
                contenido.newLineAtOffset(margenIzq, y);
                contenido.showText("Indicaciones generales:");
                contenido.endText();
                y -= 16;

                contenido.beginText();
                contenido.setFont(fuenteTexto, 10);
                contenido.newLineAtOffset(margenIzq, y);
                contenido.showText(receta.getIndicacionesGenerales() != null ? receta.getIndicacionesGenerales() : "-");
                contenido.endText();
                y -= 30;

                contenido.beginText();
                contenido.setFont(fuenteTitulo, 12);
                contenido.newLineAtOffset(margenIzq, y);
                contenido.showText("Medicamentos:");
                contenido.endText();
                y -= 20;

                for (DetalleReceta d : medicamentos) {
                    contenido.beginText();
                    contenido.setFont(fuenteTexto, 10);
                    contenido.newLineAtOffset(margenIzq, y);
                    String linea = "- " + d.getMedicamentoNombre()
                            + " | Dosis: " + d.getDosis()
                            + " | Frecuencia: " + d.getFrecuencia()
                            + " | Via: " + d.getViaAdministracion()
                            + " | Duracion: " + d.getDuracion();
                    contenido.showText(linea);
                    contenido.endText();
                    y -= 16;
                }
            }

            doc.save(rutaSalida);
            return true;
        } catch (IOException e) {
            System.out.println("Error al generar PDF: " + e.getMessage());
            return false;
        }
    }
}