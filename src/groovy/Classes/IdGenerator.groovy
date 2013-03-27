package Classes

class IdGenerator {

	def generateCustomerId() {
		Date now = new Date()
		def date = now.getYear() + 1900
		Random random = new Random()
		String idCode = (String) random.nextInt(9000) + 1000
		
		String idNumber = date+"-"+idCode
		return(idNumber)
	}
	
	def generateId() {
		Date now = new Date()
		Random random = new Random()
		String idCode = (String) random.nextInt(9000) + 1000
		return(idCode)
	}
}