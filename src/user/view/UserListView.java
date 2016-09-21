package user.view;

import java.util.ArrayList;

import user.domain.User;

public class UserListView {

	// 유저리스트 출력
	public void userListView(ArrayList<User> users) {

		System.out.println("유저번호\t유저아이디\t비밀번호\t유저이름");
		for(int i=0; i<users.size(); i++){
			
			System.out.print(users.get(i).getUserNumber() + "\t");
			System.out.print(users.get(i).getUserId() + "\t");
			System.out.print(users.get(i).getUserPassword() + "\t");
			System.out.println(users.get(i).getUserName());
			
		}
		
	}

}
