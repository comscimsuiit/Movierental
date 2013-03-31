package movierental

import org.springframework.dao.DataIntegrityViolationException
<<<<<<< HEAD
import Classes.*



class ClerkController {	
	
=======
import groovy.sql.Sql


class ClerkController {

	def searchableService
	def dataSource
	def sessionFactory

>>>>>>> origin/master
    def index() { 
		render(view:"clerkMainPage")
	}
	
	def addCustomerInit() {
		render(view:"addCustomer")
	}
	
	def addCustomer() {
<<<<<<< HEAD
		Request request = new Request()
		IdGenerator ig = new IdGenerator()
		
		request.setFirstName(params.firstName)
		request.setLastName(params.lastName)
		request.setAddress(params.address)
		request.setContactNumber(params.contactNumber)
		request.setEmail(params.email)
=======
		def db = new Sql(dataSource)
		
		def firstName = params.firstName
		def lastName = params.lastName
		def address = params.address
		def contactNumber = params.contactNumber
		def email = params.email
		
		Date now = new Date()
		def date = g.formatDate(format:"yyyy", date:new Date())
		[date:date]
>>>>>>> origin/master
		
		Random random = new Random()
		String idCode = (String) random.nextInt(9000) + 1000
		
		String idNumber = date+"-"+idCode
		
<<<<<<< HEAD
		RequestDao rd = new RequestDao()
		
		def customerExistingIds = new CustomerDao().getCustomerIds()
		def requestExistingIds = rd.getExistingIds()
=======
		def customerExistingIds = db.rows("select id from customer")
		def requestExistingIds = db.rows("select id from request")
		def customerExistingFirstname = db.rows("select first_name from customer")
		def customerExistingLastname = db.rows("select last_name from customer")
>>>>>>> origin/master
		
		if(customerExistingFirstname.first_name.contains(firstName) && customerExistingLastname.last_name.contains(lastName)) {
			render(view:'customerExists')
		}else {
		while(customerExistingIds.id.contains(idNumber) && requestExistingIds.id.contains(idNumber)) {
			idCode = (String) random.nextInt(9000) + 1000
			idNumber = date+"-"+idCode
		}
		
<<<<<<< HEAD
		rd.addRequest(request,idNumber)
		
		index()
					
=======
		db.execute("""insert into request(id,address,contact_number,first_name,last_name,email) 
					values('${idNumber}','${address}','${contactNumber}','${firstName}','${lastName}','${email}')""")
		
		index()
			}	
>>>>>>> origin/master
	}
	
	
	def searchForCustomer() {
		def parameter = params.parameter
		
		CustomerDao cd = new CustomerDao()
		def result = cd.getCustomer(parameter)
	
		render(view:"checkCustomer",model:[infos:result,parameter:parameter])

	}
	
<<<<<<< HEAD
	
=======
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
>>>>>>> origin/master
	
	def viewCustomer() {
		def id = params.id
		
		CustomerDao cd = new CustomerDao()
		def result = cd.getCustomerWithId(id)
		
		def liabilities = cd.getCustomerLiabilities(id)
		render(view:"viewCustomer",model:[info:result.get(0),liabilities:liabilities])
	}
	
	def selectMovie() {	
		CartDao cd = new CartDao()
		def id = params.id
<<<<<<< HEAD
		def parameter = params.parameter
		
		def counter = cd.getCartCount(id)
		def result2 = cd.getCartItems(id)
		
		MovieDao md = new MovieDao()
		def result = md.getAvailableMovies(parameter)
		
		render(view:"selectMovie",model:[id:id,movies:result,parameter:parameter,carts:result2,counter:counter.get(0).count])
	
	}
	
	def addToCart() {
		Cart cart = new Cart()
		cart.setCustomerId(params.id)
		cart.setMovieId(params.movieId)
		
=======
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
>>>>>>> origin/master
		def parameter = params.parameter
		
<<<<<<< HEAD
		CartDao cd = new CartDao()
		cd.addCart(cart)
		
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:cart.getCustomerId()])		
=======
		db.execute("insert into cart(customer_id,movie_id) values('${id}','${movieId}')")
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:id])
>>>>>>> origin/master
		
		
	}
	
	def deleteFromCart() {
		def parameter = params.parameter
		
<<<<<<< HEAD
		Cart cart = new Cart()
		cart.setMovieId(params.movieId)
		cart.setCustomerId(params.id)
		
		CartDao cd = new CartDao()
		cd.deleteFromCart(cart)
		
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:cart.getCustomerId()])
	}
	
	def saveTransaction() {
		def id = params.id
		RentedMovie rentedMovie = new RentedMovie()
		rentedMovie.setCustomerId(id)
		
=======
		db.execute("delete from cart where customer_id='${id}' and movie_id='${movieId}'")
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:id])
	}
	
	def saveTransaction() {
	def db = new Sql(dataSource)
		def id = params.id	
>>>>>>> origin/master
		Date now = new Date()
		Date due = now.plus(7)
		
		def dueFormat = due.format('MM/dd/yyyy')
		CustomerDao customerDao = new CustomerDao()
		def info = customerDao.getCustomerWithId(id)
		
		RentedMovieDao rentedMovieDao = new RentedMovieDao()
		def rentedMovies = rentedMovieDao.getRentedMovies(id)
		
		CartDao cartDao = new CartDao()
		def getCart = cartDao.getCartItems(id)
		
		def dateFormat = now.format('MM/dd/yyyy')
		rentedMovie.setDueDate(due)
		
		getCart.each{
			rentedMovie.setMovieId(it.movie_id)
			rentedMovieDao.addRentedMovies(rentedMovie)
		}
	
		Transaction transaction = new Transaction()
		transaction.setCustomerId(id)
		transaction.setDate(now)
		transaction.setType("check out")
	
		TransactionDao transactionDao = new TransactionDao()
	
		getCart.each{
			transaction.setFee(it.rate)
			transaction.setMovieId(it.movie_id)
			transactionDao.addTransaction(transaction)
		}
		
<<<<<<< HEAD
		rentedMovies = rentedMovieDao.getRentedMovies(id)
		cartDao.deleteCart()
		render(view:'saveTransaction',model:[currentDate:dateFormat,info:info.get(0),movies:rentedMovies,dueFormat:dueFormat])
		
=======
		rentedMovies = db.rows("""select * from ((select * from movie) as a join (select movie_id from rented_movie where customer_id='${id}') as b on
							a.id=b.movie_id)""")
		
		db.execute("delete from cart")
		render(view:'saveTransaction',model:[currentDate:dateFormat,info:info.get(0),movies:rentedMovies,dueFormat:dueFormat])
		//render(view:"saveTransaction")
	
>>>>>>> origin/master
	}
	
	def searchForCustomerRecord() {
		def parameter = params.parameter
		
<<<<<<< HEAD
		CustomerDao customerDao = new CustomerDao()
		def result = customerDao.getCustomer(parameter)
			
		render(view:"searchCustomer",model:[infos:result,parameter:parameter])
	}
	
	
=======
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
>>>>>>> origin/master
	
	def viewCustomerRecord() {
		def id = params.id
		RentedMovieDao rmd = new RentedMovieDao()
		def result = rmd.getRentedMovies(id)
								
		Date now = new Date()
	    render(view:"viewCustomerRecord",model:[id:id,movies:result,now:now])
	}
	
	def clearLiability() {
		def id = params.id
		def now = new Date()
		List<String> movieID = [params.movieID].flatten()
		
		def totalDue = params.totalDue
		def overdueRate
		def dueDate
		double daysPassed
		double fee
<<<<<<< HEAD
		MovieDao movieDao = new MovieDao()
		RentedMovieDao rentedMovieDao = new RentedMovieDao()
		TransactionDao transactionDao = new TransactionDao()
		Transaction transaction = new Transaction()
		transaction.setCustomerId(id)
		transaction.setDate(now)
		transaction.setType("check in")
		
		try{
		movieID.each{
			overdueRate = movieDao.getOverdueRate(it)
			dueDate = rentedMovieDao.getDueDate(it)
=======
		
		try{
		movieID.each{
			overdueRate = db.rows("select overdue_rate from movie where id='${it}'")
			dueDate = db.rows("select due_date from rented_movie where movie_id='${it}'")
>>>>>>> origin/master
			daysPassed = now.minus(dueDate.due_date.get(0))
			if(daysPassed > 0) {
			 fee = daysPassed * overdueRate.overdue_rate.get(0)
			 }
			else {
			 fee = 0
			}
			
			transaction.setFee(fee)
			transaction.setMovieId(it)
			transactionDao.addTransaction(transaction)
			rentedMovieDao.deleteRentedMovies(it)
		}
		}
		catch(Exception e) {
			index()
		}
<<<<<<< HEAD
=======
		}
		catch(Exception e) {
			index()
		}
>>>>>>> origin/master
		
		index()
	}
}
