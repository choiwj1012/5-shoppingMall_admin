package admin.controller;

import java.util.ArrayList;

import admin.dao.AdminDao;
import admin.domain.Admin;
import admin.view.AdminAccountManagement;
import admin.view.AdminDeleteView;
import admin.view.AdminListView;
import admin.view.AdminMainMenu;
import admin.view.AdminSignUpView;
import admin.view.AdminUpdateView;
import main.controller.MainController;
import product.view.ProductManagementView;
import user.view.UserManagementView;

public class AdminController {

	// variable
	private AdminDao adminDao;


	// constructor
	public AdminController(){

		this.adminDao = new AdminDao();
	}


	// method
	// 관리자 메인메뉴 출력
	public void requestAdminMainMenu(){

		AdminMainMenu adminMainMenu = new AdminMainMenu();
		adminMainMenu.adminMainMenu();

	}


	// 관리자 계정관리 메뉴 출력
	public void requestAdminAccountManagement(){

		AdminAccountManagement adminAccountManagement = new AdminAccountManagement();
		adminAccountManagement.adminAccountManagementView();

	}


	// 관리자 계정등록 메뉴 출력
	public void requestAdminSignUpView() {

		AdminSignUpView adminSignUpView = new AdminSignUpView();
		adminSignUpView.adminSignUpView();

	}


	// 관리자 계정등록
	public void requestAdminSignUp(Admin newAdmin){

		boolean success = adminDao.adminSignUp(newAdmin);

		if(success){
			MainController.AlertView("관리자 등록 성공");
		} else {
			MainController.AlertView("관리자 등록 실패");
		}

	}


	// 관리자 계정리스트 출력 
	public void reqestAdminListView() {

		ArrayList<Admin> admins = adminDao.adminList();

		AdminListView adminListView = new AdminListView();
		adminListView.adminListView(admins);

	}


	// 관리자 수정모드 출력
	public void requestAdminUpdateView() {

		// 선택할 관리자 계정번호 가져오기
		AdminUpdateView adminUpdateView = new AdminUpdateView();
		adminUpdateView.selectedAdmin();

	}


	// 수정된 관리자 정보 보냄
	public void requestAdminUpdate(Admin updatedAdmin){

		boolean success = adminDao.adminUpdate(updatedAdmin);

		if(success){
			MainController.AlertView("관리자 계정 업데이트 성공");
		} else {
			MainController.AlertView("관리자 계정 업데이트 실패");
		}

	}


	// 선택한 계정 데이터 가져오기 요청
	public void requestSelectedAdminInfo(int selectedAdminNumber) {

		Admin selectedAdmin = adminDao.adminInfo(selectedAdminNumber);
		AdminUpdateView adminUpdateView = new AdminUpdateView();
		adminUpdateView.adminUpdateView(selectedAdmin);

	}


	// 관리자 삭제모드 출력
	public void requestAdminDeleteView() {

		// 선택할 관리자 계정번호 가져오기
		AdminDeleteView adminDeleteView = new AdminDeleteView();
		adminDeleteView.selectedAdmin();

	}

	
	// 관리자 삭제 요청
	public void requestAdminDelete(int selectedAdminNumber){
		
		boolean success = adminDao.adminDelete(selectedAdminNumber);
		
		if(success){
			
			MainController.AlertView("관리자 계정 삭제 성공");
			
		} else {
			
			MainController.AlertView("관리자 계정 삭제 실패");
			
		}
		
	}
	
	
	// 관리자 상품관리 메뉴 출력
	public void requestProductManagement() {

		ProductManagementView productManagementView = new ProductManagementView();
		productManagementView.productManagementView();

	}


	// 관리자 유저관리 메뉴 출력
	public void requestUserManagement() {

		UserManagementView userManagementView = new UserManagementView();
		userManagementView.userManagementView();

	}


	// 관리자 결제관리 메뉴 출력
	public void requestPaymentManagement() {



	}

}
