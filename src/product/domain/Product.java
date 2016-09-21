package product.domain;

public class Product {

	// variable
	private int productNumber;
	private String productName;
	private int productPrice;
	private String productComment;
	private String productVendor;
	
	// constructor
	public Product() {
	
	}
	
	public Product(String productName, int productPrice, String productComment, String productVendor){
	
		this.productName = productName;
		this.productPrice = productPrice;
		this.productComment = productComment;
		this.productVendor = productVendor;
		
	}
	
	// getter and setter
	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
		
}
