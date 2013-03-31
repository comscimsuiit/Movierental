package movierental



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
<<<<<<< HEAD
//@TestFor(RentedMovieController)
=======
@TestFor(RentedMovieController)
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
class RentedMovieControllerTests {

    void testSomething() {
       fail "Implement me"
    }
<<<<<<< HEAD
    
    void customerIdTest() {
    	RentedMovie rentedMovie = new RentedMovie()
    	movie.setCustomerId("2009-7603")
    	assertEquals("2009-7603", movie.getCustomerId())
    }
    
    void movieIdTest() {
    	RentedMovie rentedMovie = new RentedMovie()
    	movie.setMovieId("7603")
    	assertEquals("7603", movie.getMovieId())
    }
    
    void dueDateTest() {
    	Date now;
    	RentedMovie rentedMovie = new RentedMovie()
    	movie.setDueDateId(now)
    	assertEquals(now, movie.getDueDate())
    }
=======
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
}
