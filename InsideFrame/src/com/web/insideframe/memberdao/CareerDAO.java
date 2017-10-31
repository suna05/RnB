package com.web.insideframe.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.memberdto.CareerDTO;
import com.web.insideframe.memberdto.*;

public class CareerDAO {
	DBConnection connection;
	PreparedStatement pstmt;
	ResultSet rs;
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
}
