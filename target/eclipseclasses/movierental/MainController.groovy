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
		
		switch(firstName) {
			case " ":
				db.execute(""" select * from customer """)
				index();
				break
			case firstName:
				db.execute("""insert into customer(id,address,contact_number,first_name,last_name,email) values('${idNumber}','${address}','${contactNumber}','${firstName}','${lastName}','${email}')""")
				index();
				break
			default:
				index();
				break
		}
		
		//db.execute("""insert into customer(id,address,contact_number,first_name,last_name,email) 
					//values('${idNumber}','${address}','${contactNumber}','${firstName}','${lastName}','${email}')""")
			
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
	
	def manageInventory2() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		def movies
		
		if(!parameter) {
			//movies = db.rows("Select * from movie order by title asc")
			render(view:"manageInventory")
		}
		else {
			String query = """select * from movie where director ilike '%${parameter}%' or genre ilike '%${parameter}%' or title ilike '%${parameter}%'
							or medium ilike '%${parameter}%' or actor_or_actress ilike '%${parameter}%' order by title asc"""
			movies = db.rows(query)
		}
		
		render(view:"manageInventory2",model:[movies:movies,parameter:parameter])
		
	
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
	
	def showTransactions() {
		def db = new Sql(dataSource)
	    def parameter = params.parameter
		Date now = new Date()
		
		//def date = g.formatDate(format:"yyyy", date:new Date())
		//[date:date]
		
		switch(parameter) {
			case null:
				def resultByDay = db.rows("""select * from((select * from ((select * from transaction) as a join (select * from customer) as b on a.customer_id=b.id)) as a join (select * from movie) as b on a.movie_id=b.id) where date='${now.format('MM/dd/yyyy')}'""");
				render(view:"showTransactions",model:[transactions:resultByDay,parameter:parameter]);
				break;
			case "daily":
				def resultByDay = db.rows("""select * from((select * from ((select * from transaction) as a join (select * from customer) as b on a.customer_id=b.id)) as a join (select * from movie) as b on a.movie_id=b.id) where date='${now.format('MM/dd/yyyy')}'""");
				render(view:"showTransactions",model:[transactions:resultByDay,parameter:parameter]);
				break;
			case "weekly":
				def result = db.rows("select cast(date_trunc('week', current_date) as date) + i from generate_series(0,6) i");
				def startOfWeek = result.get(0).get("?column?")
				def resultByWeek = db.rows("""select * from((select * from ((select * from transaction) as a join (select * from customer) as b on
									a.customer_id=b.id)) as a join (select * from movie) as b on a.movie_id=b.id)
									where date='${startOfWeek}' or date='${startOfWeek.plus(1)}' or date='${startOfWeek.plus(2)}'
									or date='${startOfWeek.plus(3)}' or date='${startOfWeek.plus(4)}' or date='${startOfWeek.plus(5)}'
									or date='${startOfWeek.plus(6)}'""");
				render(view:"showTransactions",model:[transactions:resultByWeek,parameter:parameter]);
				break;
			case "yearly":
				def resultByYear = db.rows("""select * from((select * from ((select * from transaction) as a join (select * from customer) as b on a.customer_id=b.id)) as a join (select * from movie) as b on a.movie_id=b.id)""")
				render(view:"showTransactions",model:[transactions:resultByYear,parameter:parameter]);
				break;
			case "monthly":
				def result = db.rows("select cast(date_trunc('month', current_date) as date) + i from generate_series(0,30) i")
				def startOfMonth = result.get(0).get("?column?")
				def resultByMonth = db.rows("""select * from((select * from ((select * from transaction) as a join (select * from customer) as b on
									a.customer_id=b.id)) as a join (select * from movie) as b on a.movie_id=b.id)
									where date='${startOfMonth}' or date='${startOfMonth.plus(1)}' or date='${startOfMonth.plus(2)}'
									or date='${startOfMonth.plus(3)}' or date='${startOfMonth.plus(4)}' or date='${startOfMonth.plus(5)}'
									or date='${startOfMonth.plus(6)}' or date='${startOfMonth.plus(7)}' or date='${startOfMonth.plus(8)}' or date='${startOfMonth.plus(9)}' or date='${startOfMonth.plus(10)}' or
									date='${startOfMonth.plus(11)}' or date='${startOfMonth.plus(12)}' or date='${startOfMonth.plus(13)}' or date='${startOfMonth.plus(14)}' or date='${startOfMonth.plus(15)}' or
									date='${startOfMonth.plus(16)}' or date='${startOfMonth.plus(17)}' or date='${startOfMonth.plus(18)}' or date='${startOfMonth.plus(19)}' or date='${startOfMonth.plus(20)}' or 
									date='${startOfMonth.plus(21)}'or date='${startOfMonth.plus(22)}' or date='${startOfMonth.plus(23)}' or date='${startOfMonth.plus(24)}' or date='${startOfMonth.plus(25)}' or 
									date='${startOfMonth.plus(26)}' or date='${startOfMonth.plus(27)}' or date='${startOfMonth.plus(28)}' or date='${startOfMonth.plus(29)}' or date='${startOfMonth.plus(30)}' """);
				render(view:"showTransactions",model:[transactions:resultByMonth,parameter:parameter]);
				break;
			default:
				showTransactions()
				break;
		}
	}
	
	def searchForCustomer() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		def result
		
		if(!parameter) {
			result = db.rows("select id,first_name,last_name from customer order by first_name asc")
			}
		
		else {
			String query = """select id, first_name, last_name from customer where first_name ilike '%${parameter}%' or last_name ilike '%${parameter}%' order
									by first_name asc"""
			result = db.rows(query)
			}
		render(view:"checkCustomer",model:[infos:result,parameter:parameter])
	}
	
	def searchForCustomer2() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		def result
		
		if(!parameter) {
			//result = db.rows("select id,first_name,last_name from customer order by first_name asc")
			render(view:"checkCustomer2")
		}
		
		else {
			String query = """select id, first_name, last_name from customer where first_name ilike '%${parameter}%' or last_name ilike '%${parameter}%' order
									by first_name asc"""
			result = db.rows(query)
			}
		render(view:"checkCustomer2",model:[infos:result,parameter:parameter])
	}
	
	def viewCustomer() {
		def db = new Sql(dataSource)
		def id = params.id
		def result = db.rows("select * from customer where id='${id}'")
		def liabilities = db.rows("""select * from ((select * from rented_movie where customer_id='${id}') as a join (select * from movie) as b on
							a.movie_id=b.id)""")
		render(view:"viewCustomer",model:[info:result.get(0),liabilities:liabilities])
	}
}
