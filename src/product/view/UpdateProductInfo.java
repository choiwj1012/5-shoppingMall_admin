package product.view;

import java.util.Scanner;

import main.controller.MainController;
import product.domain.Product;

public class UpdateProductInfo {

	// variable
	private Scanner keyboard;

	// constructor
	public UpdateProductInfo() {

		this.keyboard = new Scanner(System.in);

	}

	// 상품 수정 정보 입력
	public void updateProductInfo() {

		String productName = null;
		int productPrice = 0;
		String productComment = null;
		String productVendor = null;
		
		System.out.println("상품수정 모드입니다");
		System.out.println("수정을 원하시는 상품번호를 선택하십시오");
		int selectedProductNumber = keyboard.nextInt();

		while(true){
			
			System.out.println("변경을 원하시는 메뉴를 선택하십시오");
			System.out.println("1. 상품이름 || 2. 상품가격 || 3. 상품내용 || 4. 제조사 || 5. 수정모드 나가기");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				System.out.println("수정할 상품 이름 : ");
				productName = keyboard.next();
				
			} else if(selectedMenu == 2){

				System.out.println("수정할 상품 가격 : ");
				productPrice = keyboard.nextInt();
				
			} else if(selectedMenu == 3){

				System.out.println("수정할 상품 내용 : ");
				productComment = keyboard.next();
				
			} else if(selectedMenu == 4){

				System.out.println("수정할 제조사 : ");
				productVendor = keyboard.next();
				
			} else if(selectedMenu == 5){

				break;

			} else {

				System.out.println("잘못 입력하셨습니다");
				
			}
			
		}
		
		Product updateProduct = new Product(productName, productPrice, productComment, productVendor);
		MainController.getProductController().requestUpdateProduct(selectedProductNumber, updateProduct);
		
	}

}
