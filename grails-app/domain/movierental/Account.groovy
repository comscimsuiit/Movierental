package movierental

class Account {
	String userName;
	String password;
	String role;
	String fullName;

    static constraints = {
	
		fullName(blank:false)
		userName(blank:false, unique:true)
		password(blank:false)
		role(blank:false)
    }
    
    public void setUserName(String userName) {
    	this.userName = userName
    }
    
    public void setPassword(String password) {
    	this.password = password
    }
    
    public void setRole(String role) {
    	this.role = role
    }
    
    public void setFullName(String fullName) {
    	this.fullName = fullName
    }
    
    public String getUserName() {
    	return userName
    }
    
    public String getPassword() {
    	return password
    }
    
    public String getRole() {
    	return role
    }
    
    public String getFullName() {
    	return fullName
    }
}
