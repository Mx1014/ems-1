package com.qhit.utils.lx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIExcelDemo2 {

	public static void main(String[] args) throws IOException {
		
		HSSFWorkbook workBook = new HSSFWorkbook(); //创建excel文件
		HSSFSheet sheet =  workBook.createSheet("7月17日"); //创建excel工作表
		HSSFRow row0 = sheet.createRow(0);  //第一行
		HSSFCell cell0 = row0.createCell(0);//单元格
		cell0.setCellValue("EA-2");
		HSSFCell cell1 = row0.createCell(1);
		cell1.setCellValue("中性笔");
		HSSFCell cell2 = row0.createCell(2);
		cell2.setCellValue("1.0mm");
		
		FileOutputStream out = new FileOutputStream("e:\\demo.xls"); //输出流
		workBook.write(out);  //输出
		out.close(); //关流
				
		
	}
}
