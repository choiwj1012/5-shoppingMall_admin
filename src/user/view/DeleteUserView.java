package user.view;

import java.util.Scanner;

public class DeleteUserView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public DeleteUserView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// 회원탈퇴 확인요청
	public boolean deleteUserView() {
		
		boolean isAgree = false; 
		
		System.out.println("정말 회원 탈퇴를 하시겠습니까? y or n");
		char yesOrNo = keyboard.next().charAt(0);
		
		if(yesOrNo == 'y'){
			isAgree = true;
		}
		
		return isAgree;
		
	}

	public int forceDeleteUserView() {
		
		System.out.println("삭제를 원하시는 회원의 번호를 입력하십시오");
		int selectedUserNumber = keyboard.nextInt();
		return selectedUserNumber;
		
	}
	
}
