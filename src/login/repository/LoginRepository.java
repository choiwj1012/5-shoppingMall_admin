package login.repository;

import login.domain.Login;

public class LoginRepository {
	
	// variable
	private static Login login;

	// constructor
	public LoginRepository(){

		login = null;

	}

	// getter and setter
	public static Login getLogin() {
		return login;
	}

	public static void setLogin(Login login) {
		LoginRepository.login = login;
	}
	
}
