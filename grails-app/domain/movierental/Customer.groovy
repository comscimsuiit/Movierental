package movierental

class Customer {

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
}
