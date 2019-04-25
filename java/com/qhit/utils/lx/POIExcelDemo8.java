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

public class POIExcelDemo8 {

	public static void main(String[] args) throws Exception {
		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheet = book.createSheet();
		sheet.setColumnWidth(0, 20*256); //设置宽度
		sheet.setColumnWidth(1, 20*256);
		sheet.setColumnWidth(2, 20*256);
		sheet.setColumnWidth(3, 20*256);
		
		//标题样式
		HSSFCellStyle titleStyle = book.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //垂直居中
		
		CellRangeAddress address = new CellRangeAddress(0, 0, 0, 3); //合并单元格
		sheet.addMergedRegion(address);
		HSSFFont font = book.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗
		font.setFontHeightInPoints((short)15);
		titleStyle.setFont(font);
		
		
		
		HSSFRow titlerow = sheet.createRow(0);
		titlerow.setHeightInPoints(30); //设置高度
		HSSFCell titlecell = titlerow.createCell(0);
		titlecell.setCellValue("商品代码表");
		titlecell.setCellStyle(titleStyle);
		
		String path = "e:\\demo.xls";
		FileOutputStream out = new FileOutputStream(path);
		book.write(out); //保存excel
		out.close(); //关流
	}
}
