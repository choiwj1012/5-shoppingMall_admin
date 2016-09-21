package user.domain;

public class User {

	// variable
	private int userNumber;
	private String userId;
	private String userPassword;
	private String userName;
	
	
	// constructor
	public User() {
	
		
	}
	
	public User(String userId, String userPassword, String userName){
		
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		
	}

	// getter and setter
	public int getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
