<html>
<head>
	<meta name="layout" content="clerk" />
	<title>View Customer's Ledger</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	
	<strong>
	<div align="left">
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
	
	<div align="center">
		<g:if test="${liabilities}">
			<font color="white"><strong>Pending Liabilities:</strong></font>
			
			<table border="1" width="600" class="btn-inverse" style='width:600px;'>
				<tr>
					<th>Movie ID</th>
					<th>Title</th>
					<th>Medium</th>
					<th>Due Date</th>
				</tr>
				<tr>
					<g:each in="${liabilities}" var="liability">
						<td>${liability.movie_id}</td>
						<td>${liability.title}</td>
						<td>${liability.medium}</td>
						<td>${liability.due_date.format('MM/dd/yyyy')}</td>
						</tr>
					</g:each>
				
			</table>
			
			<bold>
				<font color="white">The client still has a liability, he/she can't rent another movie/s for the moment.</font>
			</bold>
			
			<g:form controller="clerk" action="selectMovie">
				<input type="hidden" name="id" value="${info.id}">
				<input type="submit" value="Proceed" disabled="disabled">
			</g:form>
			<!--<g:form controller="clerk" action="index">
				<input type="submit" value="Home">
			</g:form>-->
		</g:if>
		
		<g:else>
			<font color="white">There are no pending liabilities.</font>
			
			<g:form controller="clerk" action="selectMovie">
			<input type="hidden" name="id" value="${info.id}">
			<input type="submit" class="btn btn-primary btn-large" value="Proceed">
		</g:form>
		</g:else>
	</div>
	
	<div>
		<g:form controller="clerk" action="searchForCustomer">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
</body>
</html>