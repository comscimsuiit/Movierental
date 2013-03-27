<html>
<head>
	<title>Administrator Home</title>
</head>
<body>
	
	<div>
		<g:form controller="main" action="addClerkInit">
			<input type="submit" value="Add Clerk">
		</g:form>
	</div>
	
	<div>
		<g:form controller="main" action="addCustomerInit">
			<input type="submit" value="Add Customer">
		</g:form>
	</div>
	
	<div>
		<g:form controller="main" action="manageInventory">
			<input type="submit" value="Manage Inventory">
		</g:form>
	</div>
	
	<div>
		<g:form controller="main" action="showTransactions">
			<input type="submit" value="Show Transactions">
		</g:form>
	</div>

	<div>
		<g:each in="${requests}" var="request">
		
			<table border="0">
				<td>${request.first_name}</td>
				<td>${request.last_name}</td>
				<td>${request.address}</td>
				<td>${request.contact_number}</td>
				<td>${request.email}</td>
				<td>
					<g:form controller="main" action="requestAction">
						<input type="hidden" name="id" value="${request.id}">
						<input type="submit" value="Approve" name="response">
					</g:form>
				</td>
				<td>
					<g:form controller="main" action="requestAction">
						<input type="hidden" name="id" value="${request.id}">
						<input type="submit" value="Reject" name="response">
				</g:form>
				</td>
				
			</table>
		</g:each>
	</div>
	


</body>
</html>