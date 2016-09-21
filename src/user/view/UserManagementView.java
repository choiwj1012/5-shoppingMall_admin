package user.view;

import java.util.Scanner;

import main.controller.MainController;

public class UserManagementView {

	// variable
	private Scanner keyboard;

	// constructor
	public UserManagementView() {

		this.keyboard = new Scanner(System.in);

	}

	public void userManagementView() {

		while(true){
			
			System.out.println("원하시는 관리 메뉴를 선택하세요");
			System.out.println("1. 유저리스트보기 || 2. 유저삭제하기 || 3. 나가기");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				MainController.getUserController().requestUserList();

			} else if(selectedMenu == 2) {

				MainController.getUserController().requestForceDeleteUser();

			} else if(selectedMenu == 3) {

				break;

			} else {

				System.out.println("잘못 입력하셨습니다");

			}
			
		}
	}

}
