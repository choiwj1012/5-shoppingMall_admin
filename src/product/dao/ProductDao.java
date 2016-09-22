package product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.controller.MainController;
import product.domain.Product;

public class ProductDao {

	// 상품 리스트 가져오기
	public ArrayList<Product> productList() {

		ArrayList<Product> products = new ArrayList<Product>();

		Statement stmt = null;
		ResultSet rs = null;

		try{
			stmt = MainController.getDbController().getConnection().createStatement();
			String sql = "select * from PRODUCTLIST";
			rs = stmt.executeQuery(sql);

			while(rs.next()){

				Product product = new Product();
				product.setProductNumber(rs.getInt("productNumber"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductComment(rs.getString("productComment"));
				product.setProductVendor(rs.getString("productVendor"));
				products.add(product);

			}

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {

			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
	
		}

		return products;
	}


	// 상품 등록
	public boolean insertProduct(Product newProduct) {

		// 만약 상품이름이 동일하다면 등록되지 않는다.
		// 상품번호는 1씩 증가한다

		boolean success = false;

		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		try {

			String sql = "select * from PRODUCTLIST where productName = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newProduct.getProductName());
			rs = pstmt.executeQuery();

			if(rs.next()){

				return success;

			} else {


				sql = "insert into PRODUCTLIST values(productlist_seq.nextval,?,?,?,?)";
				pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, newProduct.getProductNumber());
				pstmt2.setString(2, newProduct.getProductName());
				pstmt2.setInt(3, newProduct.getProductPrice());
				pstmt2.setString(4, newProduct.getProductComment());
				pstmt2.setString(5, newProduct.getProductVendor());
				pstmt2.executeUpdate();
				success = true;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs2 != null){try {rs2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt != null){try {stmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			
		}

		return success;
	}


	// 상품 수정
	public boolean updateProduct(int selectedNum, Product updateProduct) {

		boolean success = false;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Product product = new Product();

		try {

			String sql = "select * from PRODUCTLIST where productNumber = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedNum);
			rs = pstmt.executeQuery();

			if(rs.next()){

				product.setProductNumber(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
				product.setProductComment(rs.getString(4));
				product.setProductVendor(rs.getString(5));

				if(rs.wasNull()){
					return success;
				}
				
			}

			sql = "update PRODUCTLIST set productName = ?, productPrice = ?, productComment = ?, productVendor = ? where productNumber = ?";
			pstmt2 = MainController.getDbController().getConnection().prepareStatement(sql);

			if(updateProduct.getProductName() != null){
				pstmt2.setString(1, updateProduct.getProductName());	
			} else {
				pstmt2.setString(1, product.getProductName());
			}

			if(updateProduct.getProductPrice() != 0){
				pstmt2.setInt(2, updateProduct.getProductPrice());
			} else {
				pstmt2.setInt(2, product.getProductPrice());
			}

			if(updateProduct.getProductComment() != null){
				pstmt2.setString(3, updateProduct.getProductComment());
			} else {
				pstmt2.setString(3, product.getProductComment());
			}
			
			if(updateProduct.getProductVendor() != null){
				pstmt2.setString(4, updateProduct.getProductVendor());
			} else {
				pstmt2.setString(4, product.getProductVendor());
			}

			pstmt2.setInt(5, selectedNum);
			pstmt2.executeUpdate();
			success = true;
			
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			
			if(pstmt2 != null){try{pstmt2.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}
		
		return success;

	}


	// 상품 삭제
	public boolean deleteProduct(int deleteProductNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "delete PRODUCTLIST where productNumber = ?";
			pstmt = MainController.getDbController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, deleteProductNumber);
			pstmt.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null){try{pstmt.close();} catch (SQLException e){e.printStackTrace();}}
	
		}
	
		return success;

	}

}
