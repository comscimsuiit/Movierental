<html>
<head>
	<meta name="layout" content="admin" />
	<title>View Customer's Ledger</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	
	<h3 align="center"><font color="white">Customer's Profile</font></h3>
	<strong>
	<div align="center">
		<font color="white">Customer ID: ${info.id}</font>
		<br/>
		<font color="white">First Name: ${info.first_name}</font>
		<br/>
		<font color="white">Last Name: ${info.last_name}</font>
		<br/>
		<font color="white">Address: ${info.address}</font>
		<br/>
		<font color="white">Contact Number: ${info.contact_number}</font>
		<br/>
		<font color="white">Email Address: ${info.email}</font>
	</div>
	</strong>
	
	<br/>
	<br/>
	<br/>
	
	<div>
		<g:form controller="main" action="searchForCustomer">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div><br/><br/><br/><br/><br/>
	
</body>
</html>