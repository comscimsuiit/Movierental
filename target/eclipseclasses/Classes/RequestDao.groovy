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
	
}