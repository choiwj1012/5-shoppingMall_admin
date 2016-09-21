package login.domain;

public class Login {

	// variable
	private int userNumber;
	private String loginUserId;
	private String loginUserPassword;
	
	// constructor
	public Login() {
		
	}
	
	public Login(String loginUserId, String loginUserPassword){
		
		this.loginUserId = loginUserId;
		this.loginUserPassword = loginUserPassword;
		
	}
	
	
	// getter and setter
	
	public String getLoginUserId() {
		return loginUserId;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginUserPassword() {
		return loginUserPassword;
	}

	public void setLoginUserPassword(String loginUserPassword) {
		this.loginUserPassword = loginUserPassword;
	}
	
}
