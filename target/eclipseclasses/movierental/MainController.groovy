package movierental

import org.springframework.dao.DataIntegrityViolationException
import groovy.sql.Sql
import Classes.*


class MainController {

	def searchableService
	def dataSource
	def sessionFactory

    def index() { 
		RequestDao rd = new RequestDao()
		def request = rd.getAllRequests()
		
		render(view:"adminMainPage",model:[requests:request])
	}
	
	def requestAction() {
		def response = params.response
		def id = params.id
		
		RequestDao requestDao = new RequestDao()
		def infos = requestDao.getRequest(id)
		def info = infos.get(0)
		
		Customer customer = new Customer()
		customer.setAddress(info.address)
		customer.setContactNumber(info.contact_number)
		customer.setFirstName(info.first_name)
		customer.setLastName(info.last_name)
		customer.setEmail(info.email)
		
		CustomerDao customerDao = new CustomerDao()
		RequestDao rd = new RequestDao()
		
		switch(response) {
			case "Approve":
				customerDao.addCustomer(customer,info.id)
				rd.deleteRequest(id)
				index();
				break
			case "Reject":
				rd.deleteRequest(id)
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
		def fullName = params.fullName
		def userName = params.userName
		def password1 = params.password1
		def password2 = params.password2
		
		AccountDao accountDao = new AccountDao()
		
		def clerkExistingUsername = accountDao.getUserName()
		def clerkExistingPassword = accountDao.getPassword()
		def clerkExistingFullname = accountDao.getFullName()
		
		if(clerkExistingUsername.user_name.contains(userName)) {
			render(view:'usernameAndPasswordExists')
		}else if(clerkExistingFullname.full_name.contains(fullName)) {
			render(view:'clerkExists')
		}else {
		
		Account account = new Account()
		account.setFullName(fullName)
		account.setUserName(userName)
		account.setPassword(password1)
		account.setRole("clerk")
		
		switch(password1) {
			case password2:
				accountDao.addAccount(account)
				index();
				break
			default:
				index();
				break
		}
		}
	}
	
	def addCustomerInit() {
		render(view:"addCustomer")
	}
	
	def addCustomer() {
		Customer customer = new Customer()
		CustomerDao cd = new CustomerDao()
		customer.setFirstName(params.firstName)
		customer.setLastName(params.lastName)
		customer.setAddress(params.address)
		customer.setContactNumber(params.contactNumber)
		customer.setEmail(params.email)
		
		IdGenerator ig = new IdGenerator()
		String idNumber = ig.generateCustomerId()
				
		RequestDao rd = new RequestDao()
		
		def customerExistingIds = cd.getCustomerIds()
		def requestExistingIds = rd.getExistingIds()
		def customerExistingFirstname = cd.getFirstName()
		def customerExistingLastname = cd.getLastName()
		
		if(customerExistingFirstname.first_name.contains(customer.getFirstName()) && customerExistingLastname.last_name.contains(customer.getLastName())) {
			render(view:"customerExists")
		}else {
		while(customerExistingIds.id.contains(idNumber) && requestExistingIds.id.contains(idNumber)) {
			idCode = ig.generateId()
			idNumber = date+"-"+idCode
		}
		
		
		cd.addCustomer(customer,idNumber)			
		index()
		}
	}
	
	def manageInventory() {
		def parameter = params.parameter
		
		MovieDao movieDao = new MovieDao()
		def movies = movieDao.getAllMovies(parameter)
		
		render(view:"manageInventory",model:[movies:movies,parameter:parameter])
	
	}
	
	def addInventory() {
		def db = new Sql(dataSource)
		double rate = Double.parseDouble(params.rate)
		double overdueRate = Double.parseDouble(params.overdueRate)
		MovieDao movieDao = new MovieDao()
		Movie movie = new Movie()
		movie.setTitle(params.title)
		movie.setMedium(params.medium)
		movie.setGenre(params.genre)
		movie.setDirector(params.director)
		movie.setActorOrActress(params.actorOrActress)
		movie.setStatus("good")
		movie.setRate(rate)
		movie.setOverdueRate(overdueRate)
		
		IdGenerator ig = new IdGenerator()
		String idCode = ig.generateId()
		
		//String idCode = (String) random.nextInt(9000) + 1000
		def movieExistingIds = movieDao.getIds()
		
		while(movieExistingIds.id.contains(idCode)) {
			idCode = ig.generateId()
		}
		
		movieDao.addMovie(movie,idCode)
		
		manageInventory()
		
	}
	
	def editInventoryInit() {
		def id = params.id
		def parameter = params.parameter
		
		MovieDao md = new MovieDao()
		def query = md.getMoviesWithId(id)
		def result = query.get(0)
		render(view:"editInventory",model:[infos:result,parameter:parameter])
		
	}
	
	def editInventory() {
		double rate = Double.parseDouble(params.rate)
		double overdueRate = Double.parseDouble(params.overdueRate)
		
		Movie movie = new Movie()
		
		movie.setTitle(params.title)
		movie.setMedium(params.medium)
		movie.setGenre(params.genre)
		movie.setDirector(params.director)
		movie.setActorOrActress(params.actorOrActress)
		movie.setStatus("good")
		movie.setRate(rate)
		movie.setOverdueRate(overdueRate)
		
		def parameter = params.parameter
		def id = params.id
		
		MovieDao movieDao = new MovieDao()
		movieDao.updateMovie(movie,id)
		
		manageInventory()
		
	}
	
	def markAsDamaged() {
		def id = params.id
		def parameter = params.parameter
		def marker = params.marker
		
		MovieDao md = new MovieDao()
		
		switch(marker) {
			case "Mark as damaged" :
				md.markDamaged(id)
				break
			case "Mark as good" :
				md.markGood(id)
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
		
		TransactionDao td = new TransactionDao()
		
		switch(parameter) {
			case null:
				def resultByDay = td.showDaily(now)
				render(view:"showTransactions",model:[transactions:resultByDay,parameter:parameter]);
				break;
			case "daily":
				def resultByDay = td.showDaily(now)
				render(view:"showTransactions",model:[transactions:resultByDay,parameter:parameter]);
				break;
			case "weekly":
				def resultByWeek = td.showWeekly()
				render(view:"showTransactions",model:[transactions:resultByWeek,parameter:parameter]);
				break;
			case "yearly":
				def resultByYear = td.showYearly()
				render(view:"showTransactions",model:[transactions:resultByYear,parameter:parameter]);
				break;
			default:
				showTransactions()
				break;
		}
	}
	
	def searchForCustomer() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
		CustomerDao cd = new CustomerDao()
		def result = cd.getCustomer(parameter)
				
		render(view:"checkCustomer",model:[infos:result,parameter:parameter])
	}
	
	
	
	def viewCustomer() {
		def db = new Sql(dataSource)
		def id = params.id
	
		CustomerDao cd = new CustomerDao()
		def result = cd.getCustomerWithId(id)
		def liabilities = cd.getCustomerLiabilities(id)
		
		render(view:"viewCustomer",model:[info:result.get(0),liabilities:liabilities])
	}
}
