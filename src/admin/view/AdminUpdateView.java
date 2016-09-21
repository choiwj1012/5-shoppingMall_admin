package admin.view;

import java.util.Scanner;

import admin.domain.Admin;
import main.controller.MainController;

public class AdminUpdateView {

	// variable
	private Scanner keyboard;

	// constructor
	public AdminUpdateView() {

		this.keyboard = new Scanner(System.in);

	}

	
	// 관리자 선택
	public void selectedAdmin(){

		MainController.getAdminController().reqestAdminListView();
		System.out.println("원하시는 계정번호를 입력하여 주십시오");
		int selectedAdminNumber = keyboard.nextInt();
		MainController.getAdminController().requestSelectedAdminInfo(selectedAdminNumber);

	}

	
	// 관리자 계정 수정
	public void adminUpdateView(Admin selectedAdmin) {

		String adminPassword = null;
		int authority = 0;
		System.out.println(selectedAdmin.getAdminName() + "님의 계정을 수정합니다");
		
		while(true){
			
			System.out.println("수정을 원하시는 항목을 선택하여 주십시오");
			System.out.println("1. 비밀번호변경 || 2. 권한변경 || 3. 수정종료");
			int selectedNumber = keyboard.nextInt();

			if(selectedNumber == 1){

				System.out.println("원하시는 비밀번호를 입력하여 주십시오 > ");
				adminPassword = keyboard.next();

			} else if(selectedNumber == 2){
				
				System.out.println("원하시는 권한번호를 입력하여 주십시오 (1 : 점장, 2 : 직원) > ");
				authority = keyboard.nextInt();

			} else if(selectedNumber == 3){
				
				break;
				
			} else {

				System.out.println("잘못 입력하셨습니다");

			}
			
		}
		
		Admin updatedAdmin = new Admin(selectedAdmin.getAdminNumber(), adminPassword, authority);
		MainController.getAdminController().requestAdminUpdate(updatedAdmin);
	}

}
