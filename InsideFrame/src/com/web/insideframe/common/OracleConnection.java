package com.web.insideframe.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection implements DBConnection {

	@Override
	public Connection getConnetion() {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","insideframe","insideframe");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("OracleConnection fail");
		}
		return conn;
	}

}
