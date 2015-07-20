package com.lonelyplanet.export.details;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lonelyplanet.pojo.Alien;
 
public class PDF implements Format {
    
    public static void main(String args[])
    {
        new PDF().generate(null);
    }
    
    @Override
    public void generate(Alien alien)  {
    {
        try 
        {
        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        PdfWriter.getInstance(document, new FileOutputStream("sample.pdf"));            
        document.open();
        
         
        Image image = Image.getInstance("src/com/lonelyplanet/export/details/header.jpg");            
        image.scaleToFit(1100f, 150f);
        
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(90);
        table.setSpacingBefore(5f);
        table.setSpacingAfter(5f);
        PdfPCell cell;
        cell = new PdfPCell(image);
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        document.add(table);
        
        
        
       
//        document.add(new Paragraph("Name: "+alien.getName()));
//        document.add(new Paragraph("Planet: "+alien.getPlanetName()));
        document.close();
        } catch (Exception ex) {
        }
    }
}
}
