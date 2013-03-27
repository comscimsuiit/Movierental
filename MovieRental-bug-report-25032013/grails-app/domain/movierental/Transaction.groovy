package movierental

class Transaction {

	String customerId
	String type
	String movieId
	Date date
	double fee

    static constraints = {
		customerId(blank:false)
		type(blank:false)
		movieId(blank:false)
		date(blank:false)
		fee(blank:false)
    }
}
