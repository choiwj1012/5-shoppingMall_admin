package admin.view;

import java.util.Scanner;

import main.controller.MainController;

public class AdminMainMenu {

	// variable
	private Scanner keyboard;

	// constructor
	public AdminMainMenu() {

		this.keyboard = new Scanner(System.in);

	}

	public void adminMainMenu(){

		while(true){
			System.out.println("관리자 모드입니다");
			System.out.println("원하시는 메뉴를 선택해 주십시오");
			System.out.println("1. 관리자 계정관리 || 2. 상품관리 || 3. 유저관리 || 4. 주문관리 || 5. 관리자 로그아웃");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				MainController.getAdminController().requestAdminAccountManagement();

			} else if(selectedMenu == 2) {

				MainController.getAdminController().requestProductManagement();

			} else if(selectedMenu == 3) {

				MainController.getAdminController().requestUserManagement();

			} else if(selectedMenu == 4) {

				MainController.getAdminController().requestPaymentManagement();

			} else if(selectedMenu == 5){
				
				MainController.mainMenuView();
				
			} else {

				System.out.println("잘못 입력하셨습니다");

			}
		}
	}

}
