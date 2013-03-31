package movierental

import org.springframework.dao.DataIntegrityViolationException
import groovy.sql.Sql
<<<<<<< HEAD
import Classes.*

=======
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac

class MainController {

	def searchableService
	def dataSource
	def sessionFactory

    def index() { 
<<<<<<< HEAD
		RequestDao rd = new RequestDao()
		def request = rd.getAllRequests()
=======
		
		def db = new Sql(dataSource);
		def request = db.rows("Select * from request")
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		
		render(view:"adminMainPage",model:[requests:request])
	}
	
	def requestAction() {
<<<<<<< HEAD
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
=======
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
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
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
<<<<<<< HEAD
=======
		def db = new Sql(dataSource)
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		def fullName = params.fullName
		def userName = params.userName
		def password1 = params.password1
		def password2 = params.password2
		
<<<<<<< HEAD
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
=======
		switch(password1) {
			case password2:
				db.execute("""insert into account(full_name,user_name,password,role) values('${fullName}','${userName}','${password1}','clerk')""");
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
				index();
				break
			default:
				index();
				break
		}
<<<<<<< HEAD
<<<<<<< HEAD
		}
=======
		
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
>>>>>>> origin/master
	}
	
	def addCustomerInit() {
		render(view:"addCustomer")
	}
	
	def addCustomer() {
<<<<<<< HEAD
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
=======
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
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		
		manageInventory()
		
	}
	
	def editInventoryInit() {
<<<<<<< HEAD
		def id = params.id
		def parameter = params.parameter
		
		MovieDao md = new MovieDao()
		def query = md.getMoviesWithId(id)
=======
		def db = new Sql(dataSource)
		def id = params.id
		def parameter = params.parameter
		
		def query = db.rows("Select * from movie where id='${id}'")
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		def result = query.get(0)
		render(view:"editInventory",model:[infos:result,parameter:parameter])
		
	}
	
	def editInventory() {
<<<<<<< HEAD
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
=======
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
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		
		manageInventory()
		
	}
	
	def markAsDamaged() {
<<<<<<< HEAD
=======
		def db = new Sql(dataSource)
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		def id = params.id
		def parameter = params.parameter
		def marker = params.marker
		
<<<<<<< HEAD
		MovieDao md = new MovieDao()
		
		switch(marker) {
			case "Mark as damaged" :
				md.markDamaged(id)
				break
			case "Mark as good" :
				md.markGood(id)
=======
		switch(marker) {
			case "Mark as damaged" :
				db.execute("update movie set status = 'damaged' where id='${id}'");
				break
			case "Mark as good" :
				db.execute("update movie set status = 'good' where id='${id}'");
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
				break;
			default:
				render("error!")
				break;
<<<<<<< HEAD
				
=======
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
		}
		
		redirect(controller:"main", action:"manageInventory", params:[parameter:parameter])
		
	}
	
	def showTransactions() {
		def db = new Sql(dataSource)
	    def parameter = params.parameter
		Date now = new Date()
		
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
		//def date = g.formatDate(format:"yyyy", date:new Date())
		//[date:date]
		
>>>>>>> origin/master
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
<<<<<<< HEAD
				def resultByYear = db.rows("""select * from((select * from ((select * from transaction) as a join (select * from customer) as b on 
											a.customer_id=b.id)) as a join (select * from movie) as b on a.movie_id=b.id)""")
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
				def resultByYear = db.rows("""select * from((select * from ((select * from transaction) as a join (select * from customer) as b on a.customer_id=b.id)) as a join (select * from movie) as b on a.movie_id=b.id)""")
>>>>>>> origin/master
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/master
	}
	
	def searchForCustomer() {
		def db = new Sql(dataSource)
		def parameter = params.parameter
<<<<<<< HEAD
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
=======
=======
		def result
>>>>>>> origin/master
		
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
	
<<<<<<< HEAD
	
>>>>>>> 1a6d97f912a0ed6ec36fea4c2115715844aa52ac
=======
	def viewCustomer() {
		def db = new Sql(dataSource)
		def id = params.id
		def result = db.rows("select * from customer where id='${id}'")
		def liabilities = db.rows("""select * from ((select * from rented_movie where customer_id='${id}') as a join (select * from movie) as b on
							a.movie_id=b.id)""")
		render(view:"viewCustomer",model:[info:result.get(0),liabilities:liabilities])
	}
>>>>>>> origin/master
}
