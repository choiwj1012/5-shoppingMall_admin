package main.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Controller {

	private Connection conn;

	public DB_Controller(){

		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결에 실패했습니다.");
			e.printStackTrace();
		}

	}
	
	
	public Connection getConnection() {
		
		return conn;
		
	}

	
	public void requestExitProgram() {

		if(conn != null) {try { conn.close(); } catch(SQLException e) { e.printStackTrace();}}
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);

	}

}
