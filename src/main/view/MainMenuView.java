package main.view;

import java.util.Scanner;

import main.controller.MainController;

public class MainMenuView {

	// variable
	private Scanner keyboard;

	// constructor
	public MainMenuView() {

		this.keyboard = new Scanner(System.in);

	}

	// method
	public void mainMenuView(){
		
		MainController.getProductController().requestProductlist();
		
		while(true){
			
			System.out.println("=========================================================");
			System.out.println("[관리자 모드] 원하시는 메뉴를 선택하여 주십시오");
			System.out.println("1. 관리자 로그인 || 0. 쇼핑몰 나가기");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				MainController.getLoginController().requestLoginUserInfoView(); // 관리자 로그인

			} else if(selectedMenu == 0){

				System.out.println("이용해 주셔서 감사합니다");
				MainController.getDbController().requestExitProgram();

			} else {

				System.out.println("메뉴를 잘못 선택하셨습니다");

			}
		}

	} 

}

