package admin.view;

import java.util.Scanner;

import main.controller.MainController;

public class AdminDeleteView {

	// variable
	private Scanner keyboard;

	// constructor
	public AdminDeleteView() {

		this.keyboard = new Scanner(System.in);

	}


	// 삭제할 관리자 계정 선택
	public void selectedAdmin(){

		MainController.getAdminController().reqestAdminListView();
		System.out.println("삭제할 계정번호를 입력하여 주십시오");
		int selectedAdminNumber = keyboard.nextInt();
		MainController.getAdminController().requestAdminDelete(selectedAdminNumber);

	}


}
