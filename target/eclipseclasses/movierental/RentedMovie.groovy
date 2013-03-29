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
<<<<<<< HEAD
    
    public void setCustomerId(String customerId) {
    	this.customerId = customerId
    }
    
    public void setMovieId(String movieId) {
    	this.movieId = movieId
    }
    
    public void setDueDate(Date dueDate) {
    	this.dueDate = dueDate
    }
    
    public String getCustomerId() {
    	return customerId
    }
    
    public String getMovieId() {
    	return movieId
    }
    
    public Date getDueDate() {
    	return dueDate
    }
=======
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
}
