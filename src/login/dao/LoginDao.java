package login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.domain.Login;
import login.repository.LoginRepository;
import main.controller.MainController;

public class LoginDao {

	// variable
	public LoginDao() {
		
		new LoginRepository();
		
	}
	
	
	// 로그인
	public int login(Login loginUser) {

		int userOrAdmin = 0;
		String sql = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			
			// 회원인지 확인
			sql = "select * from USERLIST where userId = ? and userPassword = ?";	
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, loginUser.getLoginUserId());
			pstmt.setString(2, loginUser.getLoginUserPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				// 2이면 일반 회원
				userOrAdmin = 2;
				loginUser.setUserNumber(rs.getInt(1));
			}
			
			rs.close();
			pstmt.close();
			
			// 관리자인지 확인
			sql = "select * from ADMINLIST where adminId = ? and adminPassword = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, loginUser.getLoginUserId());
			pstmt.setString(2, loginUser.getLoginUserPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				// 1이면 관리자
				userOrAdmin = 1;
			}
			
			rs.close();
			pstmt.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {

			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}
			
		if(userOrAdmin == 0){
			return userOrAdmin;
		}
			
		// 확인 후 로그인
		LoginRepository.setLogin(loginUser);
	
		return userOrAdmin;
		
	}

	
	// 로그아웃
	public boolean logout() {
		
		boolean success = false;

		LoginRepository.setLogin(null);
		success = true;
	
		return success;
		
	}


	// 로그인한 유저 정보 리턴
	public Login loginUser() {
		
		Login loginUser = LoginRepository.getLogin();
		
		return loginUser;
		
	}

}
