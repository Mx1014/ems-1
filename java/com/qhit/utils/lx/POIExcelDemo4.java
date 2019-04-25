package com.qhit.utils.lx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class POIExcelDemo4 {

	public static void main(String[] args) throws Exception {
		String title = "商品代码表";
		String[] name = {"devid","devname","typeid","devdate","devuser","compid","typeid","typename"};
		//获取数据
		Connection connection = CommonUtil.getConnection();
		Statement statement = connection.createStatement();
		String sql = "SELECT * \n" +
				"FROM base_device bd1 JOIN base_devtype bd2\n" +
				"ON bd1.typeid=bd2.typeid;";
		ResultSet rs = statement.executeQuery(sql);
		
		CommonUtil.exportExcel(title,name,rs);
		
	}
}
