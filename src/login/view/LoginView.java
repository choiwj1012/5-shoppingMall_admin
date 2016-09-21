package login.view;

import java.util.Scanner;

import login.domain.Login;
import main.controller.MainController;

public class LoginView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public LoginView() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	
	// 로그인
	public void loginView(){
		
		System.out.println("아이디 : ");
		String loginId = keyboard.next();
		
		System.out.println("패스워드 : ");
		String loginPassword = keyboard.next();
		
		Login loginUser = new Login(loginId, loginPassword);
		MainController.getLoginController().requestLogin(loginUser);
		
	}
	
}
