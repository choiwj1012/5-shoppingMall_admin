package main.controller;

import java.util.ArrayList;

import user.dao.UserDao;
import user.domain.User;
import user.view.DeleteUserView;
import user.view.NewUserInfoView;
import user.view.UserListView;

public class UserController {

	// variable
	private UserDao userDao;

	
	// constructor
	public UserController() {

		this.userDao = new UserDao();

	}
	
	
	// 회원 가입 정보 요청
	public void requestNewUserInfo() {

		NewUserInfoView newUserInfoView = new NewUserInfoView();
		newUserInfoView.newUserInfoView();

	}


	// 받은 회원 정보 데이터베이스 저장 요청
	public void requestSignUp(User newUser){

		boolean success = userDao.userSignUp(newUser);

		if(success){
			MainController.AlertView("관리자 등록에 성공하였습니다");
		} else {
			MainController.AlertView("관리자 등록에 실패하였습니다");
		}

	}




	
	// 변경 정보로 베이터베이스 변경
	public void requestUserUpdate(User updatedUser){
		
		userDao.userUpdate(updatedUser);
		
	}

	
	// 관리자가 강제로 회원 삭제
	public void requestForceDeleteUser() {

		DeleteUserView deleteUserView = new DeleteUserView();
		int selectedUserNumber = deleteUserView.forceDeleteUserView();
		
		boolean success = userDao.userDelete(selectedUserNumber);
		
		if(success){
			MainController.AlertView("회원이 삭제되었습니다");
		} else {
			MainController.AlertView("회원이 삭제되지 않았습니다");
		}
		
	}

	
	// 회원 리스트 출력
	public void requestUserList() {
		
		ArrayList<User> users = null;
		users = userDao.userList();
		UserListView userListView = new UserListView();
		userListView.userListView(users);
		
	}
	
}
