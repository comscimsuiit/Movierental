package movierental

import org.springframework.dao.DataIntegrityViolationException
import groovy.sql.Sql


class ClerkController {

	def searchableService
	def dataSource
	def sessionFactory

    def index() { 
		render(view:"clerkMainPage")
	}
	
	def addCustomerInit() {
		render(view:"addCustomer")
	}
	
	def addCustomer() {
		def db = new Sql(dataSource)
		
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
		
		def customerExistingIds = db.rows("select id from customer")
		def requestExistingIds = db.rows("select id from request")
		def customerExistingFirstname = db.rows("select first_name from customer")
		def customerExistingLastname = db.rows("select last_name from customer")
		
		if(customerExistingFirstname.first_name.contains(firstName) && customerExistingLastname.last_name.contains(lastName)) {
			render(view:'customerExists')
		}else {
		while(customerExistingIds.id.contains(idNumber) && requestExistingIds.id.contains(idNumber)) {
			idCode = (String) random.nextInt(9000) + 1000
			idNumber = date+"-"+idCode
		}
		
		db.execute("""insert into request(id,address,contact_number,first_name,last_name,email) 
					values('${idNumber}','${address}','${contactNumber}','${firstName}','${lastName}','${email}')""")
		
		index()
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
			render(view:"checkCustomer")
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
	
	def selectMovie() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		def id = params.id
		def counter = db.rows("select count (*) from cart where customer_id='${id}'")
		def result
		def result2 = db.rows("""select * from ((select * from cart where customer_id='${id}') as c join (select * from movie) as m on c.movie_id=m.id)""")
		
		
			String query = """select * from (select * from (select * from ((((select id from movie) except (select movie_id from rented_movie))
								except (select movie_id from cart)) as a join (select * from movie) as b on a.id=b.id) as a where status='good')
								as a where director ilike '%${parameter}%' or genre ilike '%${parameter}%' or title ilike '%${parameter}%' or medium ilike '%${parameter}%' or actor_or_actress	ilike '%${parameter}%') as a order by a.title asc"""
			result = db.rows(query)
			render(view:"selectMovie",model:[id:id,movies:result,parameter:parameter,carts:result2,counter:counter.get(0).count])
	
		//render(view:"selectMovie")
	}
	
	def addToCart() {

		def db = new Sql(dataSource)
		def id = params.id
		def parameter = params.parameter
		def movieId = params.movieId
		
		db.execute("insert into cart(customer_id,movie_id) values('${id}','${movieId}')")
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:id])
		
		
	}
	
	def deleteFromCart() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		def movieId = params.movieId
		def id = params.id
		
		db.execute("delete from cart where customer_id='${id}' and movie_id='${movieId}'")
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:id])
	}
	
	def saveTransaction() {
	def db = new Sql(dataSource)
		def id = params.id	
		Date now = new Date()
		Date due = now.plus(7)
		def dueFormat = due.format('MM/dd/yyyy')
		
		def info = db.rows("select * from customer where id='${id}'")
		def rentedMovies = db.rows("""select * from ((select * from movie) as a join (select movie_id from rented_movie where customer_id='${id}') as b on
							a.id=b.movie_id)""")
		def getCart = db.rows("select * from ((select * from cart where customer_id='${id}') as a join (select * from movie) as b on a.movie_id=b.id)")
		
		
		def dateFormat = now.format('MM/dd/yyyy')
		
		getCart.each{
			db.execute("insert into rented_movie(customer_id,movie_id,due_date) values('${id}','${it.movie_id}','${due}')")
		}
		
		getCart.each{
			db.execute("insert into transaction(customer_id,date,fee,movie_id,type) values('${id}','${now.format('MM/dd/yyyy')}','${it.rate}','${it.movie_id}','check out')")
		}
		
		rentedMovies = db.rows("""select * from ((select * from movie) as a join (select movie_id from rented_movie where customer_id='${id}') as b on
							a.id=b.movie_id)""")
		
		db.execute("delete from cart")
		render(view:'saveTransaction',model:[currentDate:dateFormat,info:info.get(0),movies:rentedMovies,dueFormat:dueFormat])
		//render(view:"saveTransaction")
	
	}
	
	def searchForCustomerRecord() {
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
		render(view:"searchCustomer",model:[infos:result,parameter:parameter])
	}
	
	def searchForCustomerRecord2() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		def result
		
		if(!parameter) {
			//result = db.rows("select id,first_name,last_name from customer order by first_name asc")
			render(view:"searchCustomer")
		}
		
		else {
			String query = """select id, first_name, last_name from customer where first_name ilike '%${parameter}%' or last_name ilike '%${parameter}%' order
									by first_name asc"""
			result = db.rows(query)
			}
		render(view:"searchCustomer2",model:[infos:result,parameter:parameter])
	}
	
	def viewCustomerRecord() {
		def db = new Sql(dataSource)
		def id = params.id
		def result = db.rows("""select * from ((select * from rented_movie where customer_id='${id}') as a join (select * from movie) as b on
									a.movie_id=b.id)""")
									
		Date now = new Date()
	  render(view:"viewCustomerRecord",model:[id:id,movies:result,now:now])
	}
	
	def clearLiability() {
		def db = new Sql(dataSource)
		def id = params.id
		def now = new Date()
		List<String> movieID = [params.movieID].flatten()
		
		def totalDue = params.totalDue
		def overdueRate
		def dueDate
		double daysPassed
		double fee
		
		try{
		movieID.each{
			overdueRate = db.rows("select overdue_rate from movie where id='${it}'")
			dueDate = db.rows("select due_date from rented_movie where movie_id='${it}'")
			daysPassed = now.minus(dueDate.due_date.get(0))
			if(daysPassed > 0) {
			 fee = daysPassed * overdueRate.overdue_rate.get(0)
			 }
			else {
			 fee = 0
			}
			db.execute("""insert into transaction(customer_id,date,fee,movie_id,type) values('${id}','${now.format('MM/dd/yyyy')}','${fee}','${it}','check in')""")
			db.execute("delete from rented_movie where movie_id='${it}'")
		}
		}
		catch(Exception e) {
			index()
		}
		
		index()
	}
}
