package movierental

class Movie {

	String title;
	String medium;
	String genre;
	String director;
	String actorOrActress;
	String status;
	double rate;
	double overdueRate;
	
    static constraints = {
		title(blank:false)
		medium(blank:false)
		genre(blank:false)
		director(blank:false)
		actorOrActress(blank:false)
		status(blank:false)
    }
    
    public void setTitle(String title) {
    	this.title = title
    }
    
    public void setMedium(String medium) {
    	this.medium = medium
    }
    
    public void setGenre(String genre) {
    	this.genre = genre
    }
    
    public void setDirector(String director) {
    	this.director = director
    }
    
    public void setActorOrActress(String actorOrActress) {
    	this.actorOrActress = actorOrActress
    }
    
    public void setStatus(String status) {
    	this.status = status
    }
    
    public void setRate(double rate) {
    	this.rate = rate
    }
    
    public void setOverdueRate(double overdueRate) {
    	this.overdueRate = overdueRate
    }
    
    public String getTitle() {
    	return title
    }
    
    public String getMedium() {
    	return medium
    }
    
    public String getGenre() {
    	return genre
    }
    
    public String getDirector() {
    	return director
    }
    
    public String getActorOrActress() {
    	return actorOrActress
    }
    
    public String getStatus() {
    	return status
    }
    
    public double getRate() {
    	return rate
    }
    
    public double getOverdueRate() {
    	return overdueRate
    }
}
