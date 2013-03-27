package movierental

import org.springframework.dao.DataIntegrityViolationException
import Classes.*



class ClerkController {	
	
    def index() { 
    	render(view:"clerkMainPage")
	}
	
	def addCustomerInit() {
		render(view:"addCustomer")
	}
	
	def addCustomer() {
		Request request = new Request()
		IdGenerator ig = new IdGenerator()
		
		request.setFirstName(params.firstName)
		request.setLastName(params.lastName)
		request.setAddress(params.address)
		request.setContactNumber(params.contactNumber)
		request.setEmail(params.email)
		
		String idNumber = ig.generateCustomerId()
		
		RequestDao rd = new RequestDao()
		
		def customerExistingIds = new CustomerDao().getCustomerIds()
		def requestExistingIds = rd.getExistingIds()
		
		while(customerExistingIds.id.contains(idNumber) && requestExistingIds.id.contains(idNumber)) {
			idCode = ig.generateId()
			idNumber = date+"-"+idCode
		}
		
		rd.addRequest(request,idNumber)
		
		index()
					
	}
	
	
	def searchForCustomer() {
		def parameter = params.parameter
		
		CustomerDao cd = new CustomerDao()
		def result = cd.getCustomer(parameter)
	
		render(view:"checkCustomer",model:[infos:result,parameter:parameter])

	}
	
	
	
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
		
	}
	
	def deleteFromCart() {
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
		
	}
	
	def searchForCustomerRecord() {
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
		def overdueRate
		def dueDate
		double daysPassed
		double fee
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
		
		index()
	}
}
