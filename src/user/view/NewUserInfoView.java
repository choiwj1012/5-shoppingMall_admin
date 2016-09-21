package user.view;

import java.util.Scanner;

import main.controller.MainController;
import user.domain.User;

public class NewUserInfoView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public NewUserInfoView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	public void newUserInfoView() {
		
		System.out.println("[관리자 등록모드 입니다.]");
		
		System.out.println("가입하실 관리자 아이디를 입력하세요 : ");
		String userId = keyboard.next();
		
		System.out.println("로그인할 관리자 패스워드를 입력하세요 : ");
		String userPassword = keyboard.next();
		
		System.out.println("관리자 이름을 입력하세요 : ");
		String userName = keyboard.next();
		
		User newUser = new User(userId, userPassword, userName);
		MainController.getUserController().requestSignUp(newUser);
		
	}

}
