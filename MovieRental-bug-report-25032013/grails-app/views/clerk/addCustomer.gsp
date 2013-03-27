<html>
<head>
	<title>Add Customer</title>
</head>
<body>
	
	<div>
		<g:form controller="clerk" action="addCustomer">
			First name: <input type="text" name="firstName">
			<br/>
			Last name: <input type="text" name="lastName">
			<br/>
			Address: <input type="text" name="address">
			<br/>
			Contact number: <input type="text" name="contactNumber">
			<br/>
			Email Address: <input type="text" name="email">
			<br/>
			<input type="submit" value="Add Customer">
		</g:form>
	</div>

</body>
</html>