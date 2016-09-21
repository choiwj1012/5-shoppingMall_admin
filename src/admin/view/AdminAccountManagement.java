package admin.view;

import java.util.Scanner;

import main.controller.MainController;

public class AdminAccountManagement {

	// variable
	private Scanner keyboard;

	// constructor
	public AdminAccountManagement() {

		this.keyboard = new Scanner(System.in);

	}

	// method
	// 관리자 계정관리 메뉴
	public void adminAccountManagementView(){

		while(true){
			
			System.out.println("관리자 계정관리 모드입니다");
			System.out.println("원하시는 모드를 선택하여 주십시오");
			System.out.println("1. 관리자 등록 || 2. 관리자 목록 확인 || 3. 관리자 수정 || 4. 관리자 삭제 || 5. 관리자 메뉴로 돌아가기");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				MainController.getAdminController().requestAdminSignUpView(); // 관리자 등록

			} else if(selectedMenu == 2){

				MainController.getAdminController().reqestAdminListView(); // 관리자 목록

			} else if(selectedMenu == 3){

				MainController.getAdminController().requestAdminUpdateView(); // 관리자 수정

			} else if(selectedMenu == 4){

				MainController.getAdminController().requestAdminDeleteView(); // 관리자 삭제
				
			} else if(selectedMenu == 5){

				MainController.getAdminController().requestAdminMainMenu(); // 관리자 메인메뉴
				
			} else {

				System.out.println("잘못 입력하셨습니다");

			}
			
		}
	}

}