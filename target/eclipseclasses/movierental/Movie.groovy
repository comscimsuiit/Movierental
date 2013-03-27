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
}
