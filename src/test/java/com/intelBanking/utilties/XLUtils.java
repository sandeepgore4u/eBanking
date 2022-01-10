package com.intelBanking.utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		
		fis=new FileInputStream(xlfile);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		book.close();
		fis.close();
		return rowcount;
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException {
		fis=new FileInputStream(xlfile);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		book.close();
		fis.close();
		return cellcount;
		
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		
		fis=new FileInputStream(xlfile);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		String  data=cell.getStringCellValue();
		book.close();
		fis.close();
		return "";
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int cellnum,int colnum,String data) throws IOException {
		
		fis=new FileInputStream(xlfile);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfile);
		book.write(fos);
		fos.close();
		book.close();
		fis.close();
	}
}
