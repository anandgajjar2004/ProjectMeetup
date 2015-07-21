package com.lonelyplanet.export.details;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lonelyplanet.pojo.Alien;
import com.lonelyplanet.exception.CustomException;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 *
 * @author Anand Gajjar
 */
public class PDF implements Format {
    
    /**
    *Implementation for PDF File using Itext library.
    */    
    @Override
    public void generate(Alien alien) throws CustomException  {
    {
        try 
        {
        //Create A4 size page with margin.  
        Document document = new Document(PageSize.A4, 10,10,10,10);
        PdfWriter.getInstance(document, new FileOutputStream("Permit_Form.pdf"));            
        document.open();
        
        //Header Details.
        Paragraph preface = new Paragraph("Permit Form. Welcome to Incredible Earth"); 
        preface.setAlignment(Element.ALIGN_CENTER);
        document.add(preface);
        
        DateFormat ddMMMyy = new SimpleDateFormat("dd/MMM/yyyy");
        preface = new Paragraph(ddMMMyy.format(new Date())); 
        preface.setAlignment(Element.ALIGN_CENTER);
        document.add(preface);
        
        document.add(new Paragraph("\n"));
        
        //Create 1 column table to disaply image. 
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
        
        //Create 2 columns table to Display Alien's details. 
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
        
        cell = new PdfPCell(new Phrase("No. of Nose: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(Integer.toString(alien.getNoOfNose())));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("No. of Eyes: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(Integer.toString(alien.getNoOfEyes())));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("No. of Days: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(Integer.toString(alien.getNoOfDays())));        
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Home Planet: "));        
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(alien.getHomePlanet()));        
        table.addCell(cell);
        document.add(table);
        
        document.close();
        } catch (Exception ex) {            
            throw new CustomException("There is some issue with PDF generate process. please contact to admin.");
        }
    }
}
}
