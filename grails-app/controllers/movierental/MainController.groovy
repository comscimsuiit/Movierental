package movierental

import org.springframework.dao.DataIntegrityViolationException
import groovy.sql.Sql

class MainController {

	def searchableService
	def dataSource
	def sessionFactory

    def index() { 
		
		def db = new Sql(dataSource);
		def request = db.rows("Select * from request")
		
		render(view:"adminMainPage",model:[requests:request])
	}
	
	def requestAction() {
		def db = new Sql(dataSource)
		def response = params.response
		def id = params.id
		def infos = db.rows("select * from request where id='${id}'")
		def info = infos.get(0)
		
		switch(response) {
			case "Approve":
				db.execute("""insert into customer(id,address,contact_number,first_name,last_name,email) values 
							('${info.id}','${info.address}','${info.contact_number}','${info.first_name}','${info.last_name}','${info.email}')""");
				db.execute("delete from request where id='${id}'");
				index();
				break
			case "Reject":
				db.execute("delete from request where id='${id}'");
				index();
				break
			default:
				render("ERROR");
				break;
		}

	}
	
	def addClerkInit() {
		render(view:"addClerk")
	}
	
	def addClerk() {
		def db = new Sql(dataSource)
		def fullName = params.fullName
		def userName = params.userName
		def password1 = params.password1
		def password2 = params.password2
		
		switch(password1) {
			case password2:
				db.execute("""insert into account(full_name,user_name,password,role) values('${fullName}','${userName}','${password1}','clerk')""");
				index();
				break
			default:
				index();
				break
		}
	}
	
	def addCustomerInit() {
		render(view:"addCustomer")
	}
	
	def addCustomer() {
		def firstName = params.firstName
		def lastName = params.lastName
		def address = params.address
		def contactNumber = params.contactNumber
		def email = params.email
		
		Date now = new Date()
		def date = g.formatDate(format:"yyyy", date:new Date())
		[date:date]
		
		
		Random random = new Random()
		String idCode = (String) random.nextInt(9000) + 1000
		
		String idNumber = date+"-"+idCode
		
		def db = new Sql(dataSource)
		def customerExistingIds = db.rows("select id from customer")
		def requestExistingIds = db.rows("select id from request")
		
		while(customerExistingIds.id.contains(idNumber) && requestExistingIds.id.contains(idNumber)) {
			idCode = (String) random.nextInt(9000) + 1000
			idNumber = date+"-"+idCode
		}
		
		db.execute("""insert into customer(id,address,contact_number,first_name,last_name,email) 
					values('${idNumber}','${address}','${contactNumber}','${firstName}','${lastName}','${email}')""")
			
		index()
				
	}
	
	def manageInventory() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		def movies
		
		if(!parameter) {
			movies = db.rows("Select * from movie order by title asc")
		}
		else {
			String query = """select * from movie where director ilike '%${parameter}%' or genre ilike '%${parameter}%' or title ilike '%${parameter}%'
							or medium ilike '%${parameter}%' or actor_or_actress ilike '%${parameter}%' order by title asc"""
			movies = db.rows(query)
		}
		
		render(view:"manageInventory",model:[movies:movies,parameter:parameter])
		
	
	} 
	
	def addInventory() {
		def db = new Sql(dataSource)
		def title = params.title
		def genre = params.genre
		def director = params.director
		def actorOrActress = params.actorOrActress
		def medium = params.medium
		def rate = params.rate
		def overdueRate = params.overdueRate
		
		Random random = new Random()
		String idCode = (String) random.nextInt(9000) + 1000
		def movieExistingIds = db.rows("select id from movie")
		
		while(movieExistingIds.id.contains(idCode)) {
			idCode = (String) random.nextInt(9000) + 1000
		}
		
		db.execute("""insert into movie(id,director,genre,title,medium,actor_or_actress,status,rate,overdue_rate)
		values('${idCode}','${director}','${genre}','${title}','${medium}','${actorOrActress}','good','${rate}','${overdueRate}')""")
		
		manageInventory()
		
	}
	
	def editInventoryInit() {
		def db = new Sql(dataSource)
		def id = params.id
		def parameter = params.parameter
		
		def query = db.rows("Select * from movie where id='${id}'")
		def result = query.get(0)
		render(view:"editInventory",model:[infos:result,parameter:parameter])
		
	}
	
	def editInventory() {
		def db = new Sql(dataSource)
		def title = params.title
		def genre = params.genre
		def director = params.director
		def actorOrActress = params.actorOrActress
		def medium = params.medium
		def rate = params.rate
		def overdueRate = params.overdueRate
		def parameter = params.parameter
		def id = params.id
		
		db.execute("""update movie set title='${title}', genre='${genre}', director='${director}', actor_or_actress='${actorOrActress}', medium='${medium}',
						rate='${rate}',overdue_rate='${overdueRate}' where id='${params.id}'""")
		
		manageInventory()
		
	}
	
	def markAsDamaged() {
		def db = new Sql(dataSource)
		def id = params.id
		def parameter = params.parameter
		def marker = params.marker
		
		switch(marker) {
			case "Mark as damaged" :
				db.execute("update movie set status = 'damaged' where id='${id}'");
				break
			case "Mark as good" :
				db.execute("update movie set status = 'good' where id='${id}'");
				break;
			default:
				render("error!")
				break;
		}
		
		redirect(controller:"main", action:"manageInventory", params:[parameter:parameter])
		
	}
	
	
	
}
