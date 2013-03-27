<html>
<head>
	<title>Check Customer</title>
</head>
<body>
	
	<div>
		<g:form controller="clerk" action="searchForCustomer">
			<input type="text" name="parameter" value="${parameter}">
			<input type="submit" value="Search">
		</g:form>
	</div>
	
	<div>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			
			<g:each in="${infos}" var="${info}">
				<tr>
					<td>${info.first_name}</td>
					<td>${info.last_name}</td>
					<td>
						<g:form controller="clerk" action="viewCustomer">
							<input type="hidden" name="id" value="${info.id}">
							<input type="submit" value="View">
						</g:form>
					</td>
				</tr>
			</g:each>
		</table>
	</div>

</body>
</html>