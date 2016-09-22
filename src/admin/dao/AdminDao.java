package admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.domain.Admin;
import main.controller.MainController;

public class AdminDao {

	// 새로운 관리자 정보 데이터베이스에 저장
	public boolean adminSignUp(Admin newAdmin) {

		boolean success = false;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try {
			// 중복체크
			String sql = "select * from ahop_master.ADMINLIST where adminId = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newAdmin.getAdminId());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				MainController.AlertView("이미 아이디가 있습니다");
			} else {
				
				sql = "insert into ADMINLIST values(adminlist_seq.nextval,?,?,?,?)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);		
				pstmt2.setString(1, newAdmin.getAdminId());
				pstmt2.setString(2, newAdmin.getAdminPassword());
				pstmt2.setString(3, newAdmin.getAdminName());
				pstmt2.setInt(4, newAdmin.getAuthority());
				pstmt2.executeUpdate();
				success = true;
					
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(pstmt2 != null){try{pstmt2.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs2 != null){try{rs2.close();} catch (SQLException e){e.printStackTrace();}}
			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}

		return success;

	}


	// 관리자 리스트 정보 불러오기
	public ArrayList<Admin> adminList() {

		ArrayList<Admin> admins = new ArrayList<Admin>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from ADMINLIST";	
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				Admin admin = new Admin();
				
				admin.setAdminNumber(rs.getInt(1));
				admin.setAdminId(rs.getString(2));
				admin.setAdminPassword(rs.getString(3));
				admin.setAdminName(rs.getString(4));
				admin.setAuthority(rs.getInt(5));
					
				admins.add(admin);
				
			}	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
	
		}

		return admins;

	}


	// 선택한 관리자 정보 불러오기
	public Admin adminInfo(int selectedAdminNumber) {

		Admin selectedAdmin = new Admin();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			
			String sql = "select * from ADMINLIST where adminNumber = ?";	
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedAdminNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				selectedAdmin.setAdminNumber(rs.getInt(1));
				selectedAdmin.setAdminId(rs.getString(2));
				selectedAdmin.setAdminPassword(rs.getString(3));
				selectedAdmin.setAdminName(rs.getString(4));
				selectedAdmin.setAuthority(rs.getInt(5));
				
				if(rs.wasNull()){
					MainController.AlertView("등록된 회원이 없습니다");
				}
				
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}

		return selectedAdmin;

	}


	// 수정된 관리자 정보 데이터베이스에 저장
	public boolean adminUpdate(Admin updatedAdmin) {

		boolean success = false;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			
			Admin admin = new Admin();
			String sql = "select * from ADMINLIST where adminNumber = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, updatedAdmin.getAdminNumber());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				admin.setAdminNumber(rs.getInt(1));
				admin.setAdminId(rs.getString(2));
				admin.setAdminPassword(rs.getString(3));
				admin.setAdminName(rs.getString(4));
				admin.setAuthority(rs.getInt(5));
				
			}
			
			sql = "update ADMINLIST set adminPassword = ?, authority = ? where adminNumber = ?";
			pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
			
			if(updatedAdmin.getAdminPassword() != null){
				pstmt2.setString(1, updatedAdmin.getAdminPassword());	
			} else {
				pstmt2.setString(1, admin.getAdminPassword());
			}
			
			if(updatedAdmin.getAuthority() != 0){
				pstmt2.setInt(2, updatedAdmin.getAuthority());	
			} else {
				pstmt2.setInt(2, admin.getAuthority());
			}
			
			pstmt2.setInt(3, updatedAdmin.getAdminNumber());
			
			pstmt2.executeUpdate();
			
			success = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(pstmt2 != null){try{pstmt2.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}

		return success;

	}

	
	// 선택된 관리자 정보 데이터베이스 삭제
	public boolean adminDelete(int selectedAdminNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		
		
		try {
			
			String sql = "delete ADMINLIST where adminNumber = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedAdminNumber);
			pstmt.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}
		
		return success;

	}


}
