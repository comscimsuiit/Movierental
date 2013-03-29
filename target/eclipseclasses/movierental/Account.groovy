package movierental

class Account {
<<<<<<< HEAD
=======

>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
	String userName;
	String password;
	String role;
	String fullName;

    static constraints = {
	
		fullName(blank:false)
<<<<<<< HEAD
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
=======
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
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
}
