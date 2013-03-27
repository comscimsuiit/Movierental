package movierental

import org.springframework.dao.DataIntegrityViolationException
import groovy.sql.Sql

class UserController {

	def searchableService
	def dataSource
	def sessionFactory
	
	def index = {
		render(view:"index")
	}
	
	def login = {
		def hash_username = 'admin'
		def hash_password = 'admin'
		def paramusername = params.user_name
    	def parampassword = params.password
		
		def db = new Sql(dataSource)
    	def accountUsername = db.rows("select user_name from account")
		def accountPassword = db.rows("select password from account")
    	
    	if(paramusername == hash_username && parampassword == hash_password){
    		//flash.message = "Login succeed. Login as admin."
    		session.user = "admin"
    		redirect(controller:"main", action:"index")
    	}else if(accountUsername.user_name.contains(paramusername) && accountPassword.password.contains(parampassword)){
    		//flash.message = "Login succeed. Login as clerk."
    		session.user = "clerk"
    		redirect(controller:"clerk", action:"index")
    	}else{
    		flash.message = "login failed"
    		//render("login failed")
    	}
   	}
   
	def logout = {
    	session.user = null
    	redirect(action:'index')
    }
}
