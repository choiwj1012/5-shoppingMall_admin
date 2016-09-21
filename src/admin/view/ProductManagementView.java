package admin.view;

import java.util.Scanner;

import main.controller.MainController;

public class ProductManagementView {

	// variable
	private Scanner keyboard;

	// constructor
	public ProductManagementView() {

		this.keyboard = new Scanner(System.in);

	}

	public void productManagementView() {

		while(true){
			System.out.println("상품관리모드입니다");
			System.out.println("1. 상품리스트 || 2. 상품등록 || 3. 상품수정 || 4. 상품삭제 || 5. 나가기");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){
				
				MainController.getProductController().requestProductlist();
				
			} else if(selectedMenu == 2){

				MainController.getProductController().requestInsertProductInfo();
				
			} else if(selectedMenu == 3){

				MainController.getProductController().requestUpdateProductInfo();
				
			} else if(selectedMenu == 4){
				
				MainController.getProductController().requestDeleteProductNumber();
				
			} else if(selectedMenu == 5){
				
				break;
				
			} else {
				
				System.out.println("잘못 입력하셨습니다");
				
			}
		}
	}

}
