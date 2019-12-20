package com.ischoolbar.programmer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_student_manager_web";
    private String dbUser = "root";
    private String dbPassword = "123456";
    private String jdbcName = "com.mysql.jdbc.Driver";
    private Connection connection = null;
    //????????????
    public Connection getConnection(){
    	try {
			Class.forName(jdbcName);
			connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			System.out.println("----------------登陆成功------------------");
		} catch (Exception e) {
			System.out.println("----------------登陆失败-----------------");
			e.printStackTrace();
		}
    	return connection;
    }
    //??????????
    public void closeCon(){
    	if(connection != null)
			try {
				connection.close();
				System.out.println("----------------关闭成功----------------");
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
	public static void main(String[] args) {
		//????????????
		DbUtil dbUtil = new DbUtil();
		dbUtil.getConnection();
		dbUtil.closeCon();

	}

}
