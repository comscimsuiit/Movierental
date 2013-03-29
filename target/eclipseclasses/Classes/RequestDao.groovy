package Classes

import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import groovy.sql.Sql
import movierental.Request


 class RequestDao {
	
	def dataSource =  AH.application.mainContext.dataSource
	
	def addRequest(Request request, String idNumber) {
		def db = new Sql(dataSource)
		db.execute("""insert into request(id,address,contact_number,first_name,last_name,email) 
					values
					('${idNumber}','${request.getAddress()}','${request.getContactNumber()}',
					'${request.getFirstName()}','${request.getLastName()}','${request.getEmail()}')""")
		
	}
	
<<<<<<< HEAD
	def getExistingIds() {
		def db = new Sql(dataSource)
		def result = db.rows("Select id from request")
		return result
	}
	
	def getAllRequests() {
		def db = new Sql(dataSource)
		def result = db.rows("select * from request")
		return result
	}
	
	def getRequest(String id) {
		def db = new Sql(dataSource)
		def result = db.rows("select * from request where id='${id}'")
		return result
	}
	
	def deleteRequest(String id) {
		def db = new Sql(dataSource)
		db.execute("delete from request where id='${id}'")
	}
	
=======
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
}