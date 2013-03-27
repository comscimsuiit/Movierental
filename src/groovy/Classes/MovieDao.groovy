package Classes

import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import groovy.sql.Sql
import movierental.Movie


 class MovieDao {
	
	def dataSource =  AH.application.mainContext.dataSource
	
	def getAvailableMovies(String parameter) {
		def db = new Sql(dataSource)
		String query = """select * from (select * from (select * from ((((select id from movie) except 
						(select movie_id from rented_movie)) except (select movie_id from cart)) as a join
						 (select * from movie) as b on a.id=b.id) as a where status='good') as a where 
						 director ilike '%${parameter}%' or genre ilike '%${parameter}%' or title ilike
						 '%${parameter}%' or medium ilike '%${parameter}%' or actor_or_actress	ilike '%${parameter}%')
					     as a order by a.title asc"""
								 
		def result = db.rows(query)
		return result
		
	}
	
	def getOverdueRate(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("select overdue_rate from movie where id='${id}'")
		return result
	}
	
	def getAllMovies(String parameter) {
		def db = new Sql(dataSource)
		String query = """select * from movie where director ilike '%${parameter}%' or genre ilike '%${parameter}%' or title ilike '%${parameter}%'
							or medium ilike '%${parameter}%' or actor_or_actress ilike '%${parameter}%' order by title asc"""
		def result = db.rows(query)
		return result
	}
	
	def getIds() {
		def db = new Sql(dataSource)
		def result = db.rows("select id from movie")
		return result
	}
	
	def addMovie(Movie movie,String id) {
		def db = new Sql(dataSource)
		db.execute("""insert into movie(id,director,genre,title,medium,actor_or_actress,status,rate,overdue_rate)
					values('${id}','${movie.getDirector()}','${movie.getGenre()}','${movie.getTitle()}','${movie.getMedium()}',
					'${movie.getActorOrActress()}','${movie.getStatus()}','${movie.getRate()}','${movie.getOverdueRate()}')""")
	}
	
	def getMoviesWithId(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("Select * from movie where id='${id}'")
		return result
	}
	
	def updateMovie(Movie movie,String id) {
		def db = new Sql(dataSource)
		db.execute("""update movie set title='${movie.getTitle()}', genre='${movie.getGenre()}', director='${movie.getDirector()}',
						 actor_or_actress='${movie.getActorOrActress()}', medium='${movie.getMedium()}',
						rate='${movie.getRate()}',overdue_rate='${movie.getOverdueRate()}' where id='${id}'""")
	}
	
	def markDamaged(String id) {
		def db = new Sql(dataSource)
		db.execute("update movie set status = 'damaged' where id='${id}'")
	}
	
	def markGood(String id) {
		def db = new Sql(dataSource)
		db.execute("update movie set status = 'good' where id='${id}'")
	}
	
	
}