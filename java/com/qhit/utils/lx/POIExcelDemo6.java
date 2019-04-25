package com.qhit.utils.lx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

public class POIExcelDemo6 {

	/*
	 * 操作单元格 设置标题，边框，行高，宽度，
	 */
	public static void main(String[] args) throws Exception {
		HSSFWorkbook book = new HSSFWorkbook(); //创建excel
		HSSFSheet sheet = book.createSheet(); //创建sheet页
		//设置宽度
		sheet.setColumnWidth(0, 20*256);
		sheet.setColumnWidth(1, 20*256);
		sheet.setColumnWidth(2, 20*256);
		sheet.setColumnWidth(3, 20*256);
		// 标题样式
		HSSFCellStyle titleStyle = book.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //垂直居中
		HSSFFont titlefont = book.createFont();
		titlefont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗
		titlefont.setFontHeightInPoints((short)15);
		titleStyle.setFont(titlefont);
		// 内容样式
		HSSFCellStyle contentStyle = book.createCellStyle();
		contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //垂直居中
		contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);	//设置边框
		contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		HSSFFont contentFont = book.createFont();
		contentFont.setFontHeightInPoints((short)12);
		//标题
		HSSFRow titlerow = sheet.createRow(0);
		titlerow.setHeightInPoints(30); //行高
		HSSFCell titlecell = titlerow.createCell(0);
		titlecell.setCellValue("商品代码表");
		CellRangeAddress address = new CellRangeAddress(0, 0, 0, 3); //合并单元格
		sheet.addMergedRegion(address);
		titlecell.setCellStyle(titleStyle); //使用标题样式
		
		//第一行 字段名
		HSSFRow metarow = sheet.createRow(1);
		metarow.setHeightInPoints(20); //行高
		
		HSSFCell cell0 = metarow.createCell(0);
		cell0.setCellValue("序号");
		cell0.setCellStyle(contentStyle);
		
		HSSFCell cell1 = metarow.createCell(1);
		cell1.setCellValue("序号");
		cell1.setCellStyle(contentStyle);
		HSSFCell cell2 = metarow.createCell(2);
		cell2.setCellValue("序号");
		cell2.setCellStyle(contentStyle);
		HSSFCell cell3 = metarow.createCell(3);
		cell3.setCellValue("序号");
		cell3.setCellStyle(contentStyle);
		
		String path = "e:\\demo.xls";
		FileOutputStream out = new FileOutputStream(path);
		book.write(out); // 保存excel
		out.close();
	}
}
