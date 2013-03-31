package movierental

import org.springframework.dao.DataIntegrityViolationException
<<<<<<< HEAD
import Classes.*

<<<<<<< HEAD


class ClerkController {	
=======
=======
>>>>>>> origin/master
import groovy.sql.Sql


class ClerkController {

	def searchableService
	def dataSource
	def sessionFactory
<<<<<<< HEAD
	
	
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
	
=======

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
		
<<<<<<< HEAD
=======
		def db = new Sql(dataSource)
		
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
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
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		
		while(customerExistingIds.id.contains(idNumber) && requestExistingIds.id.contains(idNumber)) {
			idCode = (String) random.nextInt(9000) + 1000
			idNumber = date+"-"+idCode
		}
		
<<<<<<< HEAD
<<<<<<< HEAD
		rd.addRequest(request,idNumber)
		
		index()
					
=======
		new RequestDao().addRequest(request,idNumber)
		//db.execute("""insert into request(id,address,contact_number,first_name,last_name,email) 
		//			values('${idNumber}','${request.getAddress()}','${request.getContactNumber()}','${request.getFirstName()}'
		//			,'${request.getLastName()}','${request.getEmail()}')""")
		
		index()
					
	
		
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
		db.execute("""insert into request(id,address,contact_number,first_name,last_name,email) 
					values('${idNumber}','${address}','${contactNumber}','${firstName}','${lastName}','${email}')""")
		
		index()
					
>>>>>>> origin/master
	}
	
	
	def searchForCustomer() {
<<<<<<< HEAD
		def parameter = params.parameter
		
		CustomerDao cd = new CustomerDao()
		def result = cd.getCustomer(parameter)
	
=======
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
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		render(view:"checkCustomer",model:[infos:result,parameter:parameter])

	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	
	
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
		
		def parameter = params.parameter
		
		CartDao cd = new CartDao()
		cd.addCart(cart)
		
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:cart.getCustomerId()])		
=======
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
		def result
		def result2 = db.rows("""select * from ((select * from cart where customer_id='${id}') as c join (select * from movie) as m on c.movie_id=m.id)""")
		
		if(!parameter) {
			result = db.rows("""select * from ((((select id from movie) except (select movie_id from rented_movie)) except (select movie_id from cart where
						customer_id='${id}')) as a join (select * from movie) as b on a.id=b.id) as a where status='good' order by title asc""")
			render(view:"selectMovie",model:[id:id,movies:result,carts:result2])
		}
		
		else{
			String query = """select * from (select * from (select * from ((((select id from movie) except (select movie_id from rented_movie))
								except (select movie_id from cart)) as a join (select * from movie) as b on a.id=b.id) as a where status='good')
								as a where director ilike '%${parameter}%' or genre ilike '%${parameter}%' or title ilike '%${parameter}%' or medium ilike '%${parameter}%' or actor_or_actress	ilike '%${parameter}%') as a order by a.title asc"""
			result = db.rows(query)
			render(view:"selectMovie",model:[id:id,movies:result,parameter:parameter,carts:result2])
		}
		//render(view:"selectMovie")
	}
	
	def addToCart() {
		def db = new Sql(dataSource)
		def id = params.id
		def parameter = params.parameter
		def movieId = params.movieId
<<<<<<< HEAD
		
		
		db.execute("insert into cart(customer_id,movie_id) values('${id}','${movieId}')")
		redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:id])
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
		for(int i=0; i < 4; i++) {
			db.execute("insert into cart(customer_id,movie_id) values('${id}','${movieId}')")
			redirect(controller:"clerk", action:"selectMovie", params:[parameter:parameter,id:id])
		}
>>>>>>> origin/master
		
	}
	
	def deleteFromCart() {
<<<<<<< HEAD
		def parameter = params.parameter
		
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
		
		rentedMovies = rentedMovieDao.getRentedMovies(id)
		cartDao.deleteCart()
		render(view:'saveTransaction',model:[currentDate:dateFormat,info:info.get(0),movies:rentedMovies,dueFormat:dueFormat])
=======
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
<<<<<<< HEAD
		render(view:"saveTransaction",model:[currentDate:dateFormat,info:info.get(0),movies:rentedMovies,dueFormat:dueFormat])
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		
=======
		render(view:'saveTransaction',model:[currentDate:dateFormat,info:info.get(0),movies:rentedMovies,dueFormat:dueFormat])
		//render(view:"saveTransaction")
	
>>>>>>> origin/master
	}
	
	def searchForCustomerRecord() {
<<<<<<< HEAD
		def parameter = params.parameter
		
		CustomerDao customerDao = new CustomerDao()
		def result = customerDao.getCustomer(parameter)
			
		render(view:"searchCustomer",model:[infos:result,parameter:parameter])
	}
	
	
	
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
=======
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
<<<<<<< HEAD
		List<String> movieIDs = [params.movieID].flatten()
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
		List<String> movieID = [params.movieID].flatten()
		
		def totalDue = params.totalDue
>>>>>>> origin/master
		def overdueRate
		def dueDate
		double daysPassed
		double fee
<<<<<<< HEAD
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
	
		movieIDs.each{
=======
		
		try{
		movieID.each{
>>>>>>> origin/master
			overdueRate = db.rows("select overdue_rate from movie where id='${it}'")
			dueDate = db.rows("select due_date from rented_movie where movie_id='${it}'")
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
			daysPassed = now.minus(dueDate.due_date.get(0))
			if(daysPassed > 0) {
			 fee = daysPassed * overdueRate.overdue_rate.get(0)
			 }
			else {
			 fee = 0
			}
<<<<<<< HEAD
			
			transaction.setFee(fee)
			transaction.setMovieId(it)
			transactionDao.addTransaction(transaction)
			rentedMovieDao.deleteRentedMovies(it)
		}
		}
		catch(Exception e) {
			index()
		}
		
=======
			db.execute("""insert into transaction(customer_id,date,fee,movie_id,type) values('${id}','${now.format('MM/dd/yyyy')}','${fee}','${it}','check in')""")
			db.execute("delete from rented_movie where movie_id='${it}'")
		}
		}
		catch(Exception e) {
			index()
		}
		
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		index()
	}
}
