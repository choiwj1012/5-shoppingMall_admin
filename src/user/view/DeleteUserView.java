package user.view;

import java.util.Scanner;

public class DeleteUserView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public DeleteUserView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	

	// 관리자가 선택한 회원 삭제
	public int forceDeleteUserView() {
		
		System.out.println("삭제를 원하시는 회원의 번호를 입력하십시오");
		int selectedUserNumber = keyboard.nextInt();
		return selectedUserNumber;
		
	}
	
}
