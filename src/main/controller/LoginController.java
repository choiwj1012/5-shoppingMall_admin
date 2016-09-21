package main.controller;

import login.dao.LoginDao;
import login.domain.Login;
import login.view.LoginView;
import main.controller.MainController;

public class LoginController {

	// variable
	private LoginDao loginDao;
	
	
	// constructor
	public LoginController() {

		this.loginDao = new LoginDao();
		
	}
	
	
	// 로그인 정보 요청
	public void requestLoginUserInfoView(){
		
		LoginView loginView = new LoginView();
		loginView.loginView();
		
	}
	

	
	// 로그인 정보를 유저 데이터와 확인 후 로그인 처리
	public void requestLogin(Login loginUser) {
		
		int userOrAdmin = loginDao.login(loginUser);
		
		if(userOrAdmin == 1){
			
			MainController.AlertView("관리자님 안녕하세요");
			MainController.getAdminController().requestAdminMainMenu();
			
		} else if(userOrAdmin == 0){
			
			MainController.AlertView("등록안된 관리자 입니다");
			
		}
		
	}
	
	
	// 로그 아웃 요청
	public void requestLogout(){
		
		boolean success = loginDao.logout();
		
		if(success){
				
			MainController.AlertView("로그아웃 되었습니다");
			MainController.mainMenuView();
			
		} else {
			
			MainController.AlertView("로그아웃 실패");
			
		}
		
	}

}

