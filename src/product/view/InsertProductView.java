package product.view;

import java.util.Scanner;

import main.controller.MainController;
import product.domain.Product;

public class InsertProductView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public InsertProductView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	public void insertProductView() {
		
		System.out.println("상품등록 모드입니다");
		System.out.println("등록할 상품 정보를 입력해 주십시오");
		
		System.out.println("상품 이름 : ");
		String productName = keyboard.next();
		
		System.out.println("상품 가격 : ");
		int productPrice = keyboard.nextInt();
		
		System.out.println("상품 설명 : ");
		String productComment = keyboard.next();
		
		System.out.println("제조사 : ");
		String productVendor = keyboard.next();
		
		Product newProduct = new Product(productName, productPrice, productComment, productVendor);
		MainController.getProductController().requestInsertProduct(newProduct);
		
	}

}
