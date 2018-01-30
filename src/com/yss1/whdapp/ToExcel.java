package com.yss1.whdapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;



public class ToExcel {
MainWnd mw;
HSSFWorkbook workbook;
public ToExcel(MainWnd m)
{
	mw=m;
}

public void export()
{
	 workbook = new HSSFWorkbook();
     HSSFSheet sheet = workbook.createSheet("лист "+mw.qr.getAquery().get(0).SNILS);
     
     HSSFCellStyle style = workbook.createCellStyle();
     HSSFFont font = workbook.createFont();
     font.setBold(true);
     
     style.setFont(font);
     style.setAlignment(HorizontalAlignment.CENTER);
     style.setVerticalAlignment(VerticalAlignment.CENTER);
     style.setBorderBottom(BorderStyle.THIN);
     style.setBorderLeft(BorderStyle.THIN);
     style.setBorderRight(BorderStyle.THIN);
     style.setBorderTop(BorderStyle.THIN);
     style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
     style.setShrinkToFit(false);
     style.setWrapText(true);
     
     
     HSSFCellStyle style2 = workbook.createCellStyle();
     HSSFFont font2 = workbook.createFont();
     //style2.setAlignment(HorizontalAlignment.RIGHT);
     style2.setAlignment(HorizontalAlignment.CENTER);
     style2.setFont(font2);
     style2.setVerticalAlignment(VerticalAlignment.CENTER);
     style2.setBorderBottom(BorderStyle.THIN);
     style2.setBorderLeft(BorderStyle.THIN);
     style2.setBorderRight(BorderStyle.THIN);
     style2.setBorderTop(BorderStyle.THIN);
     style2.setWrapText(true);
     
     HSSFCellStyle style3 = workbook.createCellStyle();
     HSSFFont font3 = workbook.createFont();
     style3.setAlignment(HorizontalAlignment.LEFT);
     style3.setFont(font3);
     font3.setBold(true);
     style3.setVerticalAlignment(VerticalAlignment.CENTER);
     
     
     
     
     Row row = sheet.createRow(0);
     Cell c;
     c=row.createCell(0);
     c.setCellValue("Запрос на формирование выписки");
     c.setCellStyle(style3);
     
     row = sheet.createRow(1);
     c=row.createCell(0);
     c.setCellValue("");
     
     
     
     row = sheet.createRow(2);
     row.setHeightInPoints(40);
     c=row.createCell(0);
     c.setCellValue("ФИО");
     c.setCellStyle(style);
     
     c=row.createCell(1);
     c.setCellValue("Страховой номер");
     c.setCellStyle(style);
     
     c=row.createCell(2);
     c.setCellValue("Текущее пенсионное действие (необходимо отменить)");
     c.setCellStyle(style);
     
     c=row.createCell(3);
     c.setCellStyle(style);
     c=row.createCell(4);
     c.setCellStyle(style);
     
     row = sheet.createRow(3);
     c=row.createCell(0);
     c.setCellStyle(style);
     c=row.createCell(1);
     c.setCellStyle(style);
     c=row.createCell(2);
     c.setCellValue("Вид действия");
     c.setCellStyle(style);
     
     c=row.createCell(3);
     c.setCellValue("Вид пенсии");
     c.setCellStyle(style);
     
     c=row.createCell(4);
     c.setCellValue("Дата");
     c.setCellStyle(style);
   

     sheet.addMergedRegionUnsafe(new CellRangeAddress(2, 3, 0, 0));
     sheet.addMergedRegionUnsafe(new CellRangeAddress(2, 3, 1, 1));
     sheet.addMergedRegionUnsafe(new CellRangeAddress(2, 2, 2, 4));
     
     sheet.setColumnWidth(0,8000);
     sheet.setColumnWidth(1,6000);
     sheet.setColumnWidth(2,4000);
     sheet.setColumnWidth(3,4000);
     sheet.setColumnWidth(4,5000);
     
     int rowNum = 4;
     for (SqlData dataModel : mw.qr.getAquery()) {
         row=sheet.createRow(rowNum);
         c=row.createCell(0);
         c.setCellStyle(style2);
         if (rowNum==4)
         {
        	 c.setCellValue(dataModel.FIO);
         }
         
    	 c=row.createCell(1);        
    	 c.setCellStyle(style2);
    	 if (rowNum==4)
         {
    		 
        	 c.setCellValue(dataModel.SNILS);
         }

    	 
         c=row.createCell(2);
         c.setCellValue(dataModel.dtyp);
         c.setCellStyle(style2);
         
         c=row.createCell(3);
         c.setCellValue(dataModel.dpns);
         c.setCellStyle(style2);
         
         c=row.createCell(4);
         c.setCellValue(dataModel.getSna_date());
         c.setCellStyle(style2);
         
         rowNum++;
     }

     if (rowNum>5)
     {
    	 sheet.addMergedRegionUnsafe(new CellRangeAddress(4, rowNum-1, 0, 0));
    	 sheet.addMergedRegionUnsafe(new CellRangeAddress(4, rowNum-1, 1, 1));
     }
 
     
     
     row = sheet.createRow(rowNum);
     c=row.createCell(0);
     c.setCellValue("");
     
     row = sheet.createRow(rowNum+1);
     c=row.createCell(0);
     c.setCellValue("Исполнитель:");
     c.setCellStyle(style3);
     
     row = sheet.createRow(rowNum+2);
     c=row.createCell(0);
     c.setCellValue("");
     
     row = sheet.createRow(rowNum+3);
     c=row.createCell(0);
     c.setCellValue("Дата:");
     c.setCellStyle(style3);
     
     
     try (FileOutputStream out = new FileOutputStream(new File("box\\"+mw.qr.getAquery().get(0).SNILS+".xls"))) {
         workbook.write(out);
     } catch (IOException e) {
         e.printStackTrace();
     }
     
}

private static void createSheetHeader(HSSFSheet sheet, int rowNum, SqlData dataModel) {
    Row row = sheet.createRow(rowNum);

    row.createCell(0).setCellValue(dataModel.getSNILS());
    row.createCell(1).setCellValue(dataModel.getNumb());
    row.createCell(2).setCellValue(dataModel.getSna_date());
    row.createCell(3).setCellValue(dataModel.getDtyp());
    row.createCell(4).setCellValue(dataModel.getDpns());
    
}




}
