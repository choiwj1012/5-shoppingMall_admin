package admin.view;

import java.util.Scanner;

import admin.domain.Admin;
import main.controller.MainController;

public class AdminSignUpView {
	
	// variable
	private Scanner keyboard;

	// constructor
	public AdminSignUpView() {

		this.keyboard = new Scanner(System.in);

	}
	
	// 관리자 등록
	public void adminSignUpView() {

		System.out.println("관리자 등록 모드입니다");

		System.out.println("등록할 아이디 : ");
		String adminId = keyboard.next();

		System.out.println("등록할 비밀번호 : ");
		String adminPassword = keyboard.next();

		System.out.println("등록할 이름 : ");
		String adminName = keyboard.next();

		System.out.println("권한부여 (1:점장, 2:직원) : ");
		int authority = keyboard.nextInt();

		Admin newAdmin = new Admin(adminId, adminPassword, adminName, authority);
		MainController.getAdminController().requestAdminSignUp(newAdmin);

	}
	
}
