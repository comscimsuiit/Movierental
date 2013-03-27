<html>
<head>
	<meta name="layout" content="admin" />
	<title>Add Customer</title>
</head>
<body>
	
	<div>
		<g:form controller="main" action="addCustomer">
			First Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="firstName">
			<br/>
			Last Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lastName">
			<br/>
			Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address">
			<br/>
			Contact Number: <input type="text" name="contactNumber">
			<br/>
			Email Address:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email">
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary btn-large" value="Submit">
		</g:form>
	</div>
	
	<div>
		<g:form controller="main" action="index">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
</body>
</html>