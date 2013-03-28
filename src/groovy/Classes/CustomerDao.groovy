package Classes

import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import groovy.sql.Sql


 class CustomerDao {
	
	def dataSource =  AH.application.mainContext.dataSource
	
	def addCustomer() {
		def db = new Sql(dataSource)
		return(db.rows("select * from customer"))
	}
	
}