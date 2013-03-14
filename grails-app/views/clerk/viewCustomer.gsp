<html>
<head>
	<title>View Customer's Ledger</title>
</head>
<body>
	
	<strong>
	<div align="left">
		Customer ID: ${info.id}
		<br/>
		First Name: ${info.first_name}
		<br/>
		Last Name: ${info.last_name}
		<br/>
		Address: ${info.address}
		<br/>
		Contact Number: ${info.contact_number}
		<br/>
		Email Address: ${info.email}
		
	</div>
	</strong>
	
	<br/>
	<br/>
	<br/>
	
	<div align="center">
		<g:if test="${liabilities}">
			<strong>Pending Liabilities:</strong>
			
			<table border="1" width="600">
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
				The client still has a liability, he/she can't rent another movie/s for the moment.
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
			There are no pending liabilities.
			
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