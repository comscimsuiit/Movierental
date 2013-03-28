<html>
<head>
	<title>Clerk Home</title>
</head>
<body>
	
	<div>
		<g:form controller="clerk" action="addCustomerInit">
			<input type="submit" value="Add Customer">
		</g:form>
	</div>

	<div>
		<g:form controller="clerk" action="searchForCustomer">
			<input type="submit" value="Check Out Movie">
		</g:form>
	</div>
	
	<div>
		<g:form controller="clerk" action="searchForCustomerRecord">
			<input type="submit" value="Check In Movie">
		</g:form>
	</div>
	
</body>
</html>