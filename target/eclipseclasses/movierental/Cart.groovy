package movierental

class Cart {

	String customerId;
	String movieId;

    static constraints = {
		customerId(blank:false)
		movieId(blank:false)
    }
}
