package user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import login.domain.Login;
import main.controller.MainController;
import user.domain.User;

public class UserDao {

	// 회원 가입
	public boolean userSignUp(User newUser) {

		boolean success = false;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		try {

			String sql = "select * from shop_master.USERLIST where userId = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newUser.getUserId());
			rs = pstmt.executeQuery();

			if(rs.next()){

				MainController.AlertView("이미 아이디가 존재합니다");

			} else {

				sql = "insert into shop_master.USERLIST values(shop_master.adminlist_seq.nextval,?,?,?)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, newUser.getUserNumber());
				pstmt2.setString(2, newUser.getUserId());
				pstmt2.setString(3, newUser.getUserPassword());
				pstmt2.setString(4, newUser.getUserName());
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


	// 로그인한 회원 조회
	public User loginUserInfo(Login loginUser) {

		User loginUserInfo = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from shop_master.USERLIST where userId = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, loginUser.getLoginUserId());
			rs = pstmt.executeQuery();

			if(rs.next()){

				loginUserInfo.setUserNumber(rs.getInt(1));
				loginUserInfo.setUserId(rs.getString(2));
				loginUserInfo.setUserPassword(rs.getString(3));
				loginUserInfo.setUserName(rs.getString(4));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}	

		return loginUserInfo;
	}

	
	// 관리자가 유저를 강제삭제
	public boolean userDelete(int selectedUserNumber){
		
		boolean success = false;
		PreparedStatement pstmt = null;

		try {

			String sql = "delete shop_master.USERLIST where userNumber = ?";	
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedUserNumber);
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}

		return success;
		
	}


	// 유저 리스트 리턴
	public ArrayList<User> userList() {
		
		ArrayList<User> users = new ArrayList<User>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from shop_master.USERLIST";
			stmt = MainController.getDbController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			
				User user = new User();
				user.setUserNumber(rs.getInt(1));
				user.setUserId(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserName(rs.getString(4));
				users.add(user);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
	
		}
		
		return users;
	}

}
