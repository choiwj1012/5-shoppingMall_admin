package product.view;

import java.util.Scanner;

import main.controller.MainController;

public class DeleteProductNumber {

	// variable
	private Scanner keyboard;
	
	// constructor
	public DeleteProductNumber() {
	
		this.keyboard = new Scanner(System.in);
		
	}
	
	public void deleteProductNumber() {
		
		System.out.println("삭제할 상품번호를 입력하십시오");
		int selectedProductNumber = keyboard.nextInt();
		MainController.getProductController().requestDeleteProduct(selectedProductNumber);
		
	}

}
