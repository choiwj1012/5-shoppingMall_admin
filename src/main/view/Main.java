package main.view;

import main.controller.MainController;

public class Main {

	public static void main(String[] args) {
		
		new MainController();
		
		// 상품리스트 
		MainController.getProductController().requestProductlist();
		
		// 메인메뉴
		MainController.mainMenuView();
		
		
	}
	
}
