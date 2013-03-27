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
    public void setFirstName(String firstName {
    	this.firstName = firstName
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName
    }
    
    public void setaddress(String address) {
    	this.address = address
    }
    
    public String setContactNumber(String contactNumber) {
    	this.contactNumber = contactNumber
    }
    
    public String setEmail(String email) {
    	this.email = email
    }
    
    public String getFirstName() {
    	return firstName
    }

    public String getLastName() {
    	return lastName
    }

    public String getAddress() {
    	return address
    }

    public String getContactNumber() {
    	return contactNumber
    }

    public String getEmail(){
        return email
    }
}

