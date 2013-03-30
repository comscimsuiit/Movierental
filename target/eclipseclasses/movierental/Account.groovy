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
}
