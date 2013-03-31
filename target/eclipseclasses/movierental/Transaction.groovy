package movierental

/**
 * Transaction
 * A domain class describes the data object and it's mapping to the database
 */
class Transaction {

	String customerId
	String type
	String movieId
	Date date
	double fee

<<<<<<< HEAD
<<<<<<< HEAD

=======
	/* Default (injected) attributes of GORM */
//	Long	id
//	Long	version
	
	/* Automatic timestamping of GORM */
//	Date	dateCreated
//	Date	lastUpdated
	
//	static belongsTo	= []	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//	static hasOne		= []	// tells GORM to associate another domain object as an owner in a 1-1 mapping
//	static hasMany		= []	// tells GORM to associate other domain objects for a 1-n or n-m mapping
//	static mappedBy		= []	// specifies which property should be used in a mapping 
>>>>>>> origin/master
	
    static mapping = {
    }
    
	static constraints = {
<<<<<<< HEAD
=======
    static constraints = {
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
>>>>>>> origin/master
		customerId(blank:false)
		type(blank:false)
		movieId(blank:false)
		date(blank:false)
		fee(blank:false)
    }
<<<<<<< HEAD
<<<<<<< HEAD
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId
	}
	
	public void setType(String type) {
		this.type = type
	}
	
	public void setMovieId(String movieId) {
		this.movieId = movieId
	}
	
	public void setDate(Date date) {
		this.date = date
	}
	
	public void setFee(double fee) {
		this.fee = fee
	}
	
	public String getCustomerId() {
		return customerId
	}
	
	public String getType() {
		return type
	}
	
	public String getMovieId() {
		return movieId
	}
	
	public String getDate() {
		return date
	}
	
	public double getFee() {
		return fee
	}
	
=======
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
	
	/*
	 * Methods of the Domain Class
	 */
//	@Override	// Override toString for a nicer / more descriptive UI 
//	public String toString() {
//		return "${name}";
//	}
>>>>>>> origin/master
}
