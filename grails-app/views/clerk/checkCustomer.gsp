<html>
<head>
	<title>Check Customer</title>
</head>
<body>
	
	<div align="center">
		<g:form controller="clerk" action="searchForCustomer">
			<input type="text" placeholder="Search Customer" name="parameter" value="${parameter}">
			<input type="submit" class="btn btn-primary btn-small" value="Search">
		</g:form>
	</div>
	
	<div align="center">
		<table width=700>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			
			<g:each in="${infos}" var="${info}">
				<tr>
					<td><center>${info.first_name}</center></td>
					<td><center>${info.last_name}</center></td>
					<td>
						<g:form controller="clerk" action="viewCustomer">
							<input type="hidden" name="id" value="${info.id}">
							<input type="submit" class="btn btn-primary btn-small" value="View">
						</g:form>
					</td>
				</tr>
			</g:each>
		</table>
	</div>
	
	<div>
		<g:form controller="clerk" action="index">
			<i class="icon-chevron-left icon-white"></i>
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
</body>
</html>