package com.lonelyplanet.export.details;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lonelyplanet.pojo.Alien;
import java.io.File;
 
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
        
        File file = new File("src/com/lonelyplanet/export/details/header.jpg");
	String filepath = file.getAbsolutePath();						    	  		    	 	
                 
        Image image = Image.getInstance(filepath);            
        image.scaleToFit(1000f, 150f);        
       
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        
        PdfPCell cell = new PdfPCell();        
        cell.setColspan(2);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.addElement(image);
        table.addCell(cell);
        document.add(table);
        
        document.add(new Paragraph("\n"));
        
        table = new PdfPTable(2);
        table.setWidthPercentage(100);
        
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
        cell = new PdfPCell(new Phrase(Integer.toString(alien.getNoOfAntennas())));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("No. of Legs: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(Integer.toString(alien.getNoOfLegs())));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Home Planet: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(alien.getHomePlanet()));        
        table.addCell(cell);
        document.add(table);
        
        document.close();
        } catch (Exception ex) {
        }
    }
}
}
