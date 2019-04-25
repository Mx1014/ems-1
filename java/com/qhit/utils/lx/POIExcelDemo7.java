package com.qhit.utils.lx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIExcelDemo7 {

	public static void main(String[] args) throws Exception {
		HSSFWorkbook book = new HSSFWorkbook(); //创建excel文件
		HSSFSheet sheet = book.createSheet();
		
		String path = "e:\\demo.xls";
		FileOutputStream out = new FileOutputStream(path);
		book.write(out); //保存excel
		out.close();
	}
}
