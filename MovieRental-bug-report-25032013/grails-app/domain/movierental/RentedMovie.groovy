package movierental

class RentedMovie {

	String customerId;
	String movieId;
	Date dueDate;
	
    static constraints = {
		customerId(blank:false)
		movieId(blank:false)
		dueDate()
    }
}
