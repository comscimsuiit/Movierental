package Classes


import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import groovy.sql.Sql
import movierental.Customer


 class CustomerDao {
	
	def dataSource =  AH.application.mainContext.dataSource
	
	def getCustomerIds() {
		def db = new Sql(dataSource)
		def result = db.rows("Select id from customer")
		return result
	}
	
	def getCustomer(String parameter) {
		def db = new Sql(dataSource)
		String query = """select id, first_name, last_name from customer where first_name ilike '%${parameter}%' or last_name ilike '%${parameter}%' order
									by first_name asc"""
									
		def result = db.rows(query)
		return result
		
	}
	
	def getCustomerWithId(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("Select * from customer where id='${id}'")
		return result	
	}
	
	def getCustomerLiabilities(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("""select * from ((select * from rented_movie where customer_id='${id}') as a join (select * from movie) as b on
							a.movie_id=b.id)""")
		return result
	}
	
	def addCustomer(Customer customer, String id) {
		def db = new Sql(dataSource)
		db.execute("""insert into customer(id,address,contact_number,first_name,last_name,email) values 
							('${id}','${customer.getAddress()}','${customer.getContactNumber()}','${customer.getFirstName()}',
							'${customer.getLastName()}','${customer.getEmail()}')""")
	}
	
	def viewCustomer(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("select * from customer where id='${id}'")
		def liabilities = db.rows("""select * from ((select * from rented_movie where customer_id='${id}') as a join (select * from movie) as b on
							//a.movie_id=b.id)""")
		return liabilities
	}
	
	def getFirstName() {
		def db = new Sql(dataSource)
		def result = db.rows("select first_name from customer")
		return result
	}
	
	def getLastName() {
		def db = new Sql(dataSource)
		def result = db.rows("select last_name from customer")
		return result
	}
	
}