package product.view;

import java.util.ArrayList;

import product.domain.Product;

public class ProductListView {

	public void productList(ArrayList<Product> products) {
	
		System.out.println("상품번호\t상품이름\t\t상품가격\t상품설명\t\t제조사");
		for(int i=0; i<products.size(); i++){
			System.out.print(products.get(i).getProductNumber() + "\t");
			System.out.print(products.get(i).getProductName() + "\t");
			System.out.print(products.get(i).getProductPrice() + "\t");
			System.out.print(products.get(i).getProductComment() + "\t");
			System.out.println(products.get(i).getProductVendor());
		}
		
	}	
	
}
