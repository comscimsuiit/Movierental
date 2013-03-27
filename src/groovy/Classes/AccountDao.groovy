package Classes

import org.codehaus.groovy.grails.commons.ApplicationHolder as AH
import groovy.sql.Sql
import movierental.Account


 class AccountDao {
	
	def dataSource =  AH.application.mainContext.dataSource
	
	def getUserName() {
		def db = new Sql(dataSource)
		def result = db.rows("select user_name from account")
		return result
	}
	
	def getPassword() {
		def db = new Sql(dataSource)
		def result = db.rows("select password from account")
		return result
	}
	
	def getFullName() {
		def db = new Sql(dataSource)
		def result = db.rows("select full_name from account")
		return result
	}
	
	def addAccount(Account account) {
		def db = new Sql(dataSource)
		db.execute("""insert into account(full_name,user_name,password,role) values('${account.getFullName()}',
						'${account.getUserName()}','${account.getPassword()}','${account.getRole()}')""")
	}
	
	
}