package movierental

class Account {

	String userName;
	String password;
	String role;
	String fullName;

    static constraints = {
	
		fullName(blank:false)
		userName(blank:false)
		password(blank:false)
		role(blank:false)
    }
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
