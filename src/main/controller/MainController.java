package main.controller;

import admin.controller.AdminController;
import main.controller.LoginController;
import main.view.AlertView;
import main.view.MainMenuView;
import main.controller.ProductController;
import main.controller.UserController;

public class MainController {

	
	// Connect Controllers
	private static DB_Controller dbController;
	private static AdminController adminController;
	private static UserController userController;
	private static LoginController loginController;
	private static ProductController productController;
	
	
	// constructor
	public MainController() {
	
		dbController = new DB_Controller();
		adminController = new AdminController();
		userController = new UserController();
		loginController = new LoginController();
		productController = new ProductController();
		
	}

	
	// getter and setter
	public static DB_Controller getDbController() {
		return dbController;
	}
	
	
	public static AdminController getAdminController() {
		return adminController;
	}


	public static UserController getUserController() {
		return userController;
	}

	
	public static LoginController getLoginController() {
		return loginController;
	}

	public static ProductController getProductController() {
		return productController;
	}

	
	// method
	// 출력문 공통 메서드
	public static void AlertView(String msg){
		
		AlertView alertView = new AlertView();
		alertView.alert(msg);
		
	}
	
	
	// 메인메뉴보기
	public static void mainMenuView(){
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.mainMenuView();
		
	}
	
}
