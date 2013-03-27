package Classes

import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import groovy.sql.Sql
import movierental.Cart


 class CartDao {
	
	def dataSource =  AH.application.mainContext.dataSource
	
	def getCartCount(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("select count (*) from cart where customer_id='${id}'")
		return result
	}
	
	def getCartItems(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("""select * from ((select * from cart where customer_id='${id}')
							 as c join (select * from movie) as m on c.movie_id=m.id)""")
		return result
	}
	
	def addCart(Cart cart) {
		def db = new Sql(dataSource)
		db.execute("insert into cart(customer_id,movie_id) values('${cart.getCustomerId()}','${cart.getMovieId()}')")
	}
	
	def deleteFromCart(Cart cart) {
		def db = new Sql(dataSource)
		db.execute("delete from cart where customer_id='${cart.getCustomerId()}' and movie_id='${cart.getMovieId()}'")
	}
	
	def deleteCart() {
		def db = new Sql(dataSource)
		db.execute("delete from cart")
	}

}