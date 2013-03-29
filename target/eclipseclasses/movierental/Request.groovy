package movierental

class Request {

	String firstName;
	String lastName;
	String address;
	String contactNumber;
	String email;

    static constraints = {
		firstName(blank:false)
		lastName(blank:false)
		address(blank:false)
		contactNumber(blank:false)
		email()
    }
<<<<<<< HEAD
}
=======
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public void setContactNumber(String contactNumber) {
    	this.contactNumber = contactNumber;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public String getContactNumber() {
    	return contactNumber;
    }
    
    public String getEmail() {
    	return email;
    }
    
    
}

>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
