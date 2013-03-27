package Classes

import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import groovy.sql.Sql
import movierental.RentedMovie


 class RentedMovieDao {
	
	def dataSource =  AH.application.mainContext.dataSource
	
	def getRentedMovies(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("""select * from ((select * from movie) as a join (select * from rented_movie where 
							customer_id='${id}') as b on a.id=b.movie_id)""")
		return result
	}
	
	def addRentedMovies(RentedMovie rm) {
		def db = new Sql(dataSource)
		db.execute("""insert into rented_movie(customer_id,movie_id,due_date) 
					values('${rm.getCustomerId()}','${rm.getMovieId()}','${rm.getDueDate()}')""")
	}
	
	def getDueDate(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("select due_date from rented_movie where movie_id='${id}'")
		return result
	}
	
	def deleteRentedMovies(String movieId) {
		def db = new Sql(dataSource)
		db.execute("delete from rented_movie where movie_id='${movieId}'")
	}
	
}