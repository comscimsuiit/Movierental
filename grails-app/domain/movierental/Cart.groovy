package movierental

class Cart {

	String customerId;
	String movieId;

    static constraints = {
		customerId(blank:false)
		movieId(blank:false)
    }
    
    public void setCustomerId(String customerId) {
    	this.customerId = customerId
    }
    
    public void setMovieId(String movieId) {
    	this.movieId = movieId
    }
    
    public String getCustomerId() {
    	return customerId
    }
    
    public String getMovieId() {
    	return movieId
    }
}
