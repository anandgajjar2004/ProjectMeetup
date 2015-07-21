package com.lonelyplanet.export.details;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lonelyplanet.pojo.Alien;
 
public class PDF implements Format {
    
    public static void main(String args[])
    {
        Alien a = new Alien();
        a.setBloodColor("d");
        a.setCodeName("d");
        a.setHomePlanet("s");
        a.setNoOfAntennas(3);
        a.setNoOfLegs(3);
        new PDF().generate(a);
    }
    
    @Override
    public void generate(Alien alien)  {
    {
        try 
        {
        Document document = new Document(PageSize.A4, 10,10,10,10);
        PdfWriter.getInstance(document, new FileOutputStream("sample.pdf"));            
        document.open();
        
         
        Image image = Image.getInstance("src/com/lonelyplanet/export/details/header.jpg");            
        image.scaleToFit(1000f, 150f);
        
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
//        table.setSpacingBefore(5f);
//        table.setSpacingAfter(5f);
        
        PdfPCell cell = new PdfPCell(image);        
        cell.setColspan(2);
        table.addCell(cell);
        document.add(table);
        
        document.add(new Paragraph("\n"));
        
        table = new PdfPTable(2);
        table.setWidthPercentage(100);
//        table.setSpacingBefore(5f);
//        table.setSpacingAfter(5f);
        
        cell = new PdfPCell(new Phrase("Code Name: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(alien.getCodeName()));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Blood Color: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(alien.getBloodColor()));        
        table.addCell(cell);
        
        
        cell = new PdfPCell(new Phrase("No. of Antennas: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(alien.getNoOfAntennas()));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("No. of Legs: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(alien.getNoOfLegs()));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Home Planet: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(alien.getHomePlanet()));        
        table.addCell(cell);
        
        document.add(table);
        
        
        
       
//        document.add(new Paragraph("Name: "+alien.getName()));
//        document.add(new Paragraph("Planet: "+alien.getPlanetName()));
        document.close();
        } catch (Exception ex) {
        }
    }
}
}
