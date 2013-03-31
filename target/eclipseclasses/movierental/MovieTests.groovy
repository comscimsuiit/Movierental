package movierental



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Movie)
class MovieTests {
<<<<<<< HEAD
	
    void testSomething() {
    	//fail "Implement me"
    }
    
    void titleTest() {
    	Movie movie = new Movie()
       	movie.setTitle("Carlo")
       	assertEquals("Carlo", movie.getTitle())
    }
    
    void mediumTest() {
    	Movie movie = new Movie()
    	movie.setMedium("DVD")
    	assertEquals("DVD", movie.getMedium())
    }
    
    void genreTest() {
    	Movie movie = new Movie()
    	movie.setGenre("Action")
    	assertEquals("Action", movie.getGenre())
    }
    
    void directorTest() {
    	Movie movie = new Movie()
    	movie.setDirector("David Fincher")
    	assertEquals("David Fincher", movie.getDirector())
    }
    
    void actorOrActressTest() {
    	Movie movie = new Movie()
    	movie.setActorOrActress("Brad Pitt")
    	assertEquals("Brad Pitt", movie.getActorOrActress())
    }
    
    void statusTest() {
    	Movie movie = new Movie()
    	movie.setStatus("good")
    	assertEquals("good", movie.getStatus())
    }
    
    void rateTest() {
    	Movie movie = new Movie()
    	movie.setRate("15.00")
    	assertEquals("15.00", movie.getRate())
    }
    
    void overDueRateTest() {
     	Movie movie = new Movie()
    	movie.setOverDueRate("30.000")
    	assertEquals("30.00", movie.getOverDueRate())
=======

    void testSomething() {
<<<<<<< HEAD
       //fail "Implement me"
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
       fail "Implement me"
>>>>>>> origin/master
    }
}
