<html>
<head>
	<title>Add Customer</title>
</head>
<body>
	
	<div>
		<g:form controller="main" action="addCustomer">
			First Name: <input type="text" name="firstName">
			<br/>
			Last Name: <input type="text" name="lastName">
			<br/>
			Address: <input type="text" name="address">
			<br/>
			Contact Number: <input type="text" name="contactNumber">
			<br/>
			Email Address: <input type="text" name="email">
			<br/>
			<input type="submit" value="Submit">
		</g:form>
	</div>
	
</body>
</html>