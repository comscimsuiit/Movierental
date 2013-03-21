<html>
<head>
	<meta name="layout" content="admin" />
	<title>Check Customer</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	
	<div align="center">
		<g:form class="form-search" controller="clerk" action="searchForCustomer">
			<input type="text" placeholder="Search Customer" name="parameter" value="${parameter}" class="input-medium search-query icon-search">
			<input type="submit" class="btn btn-primary btn-small" value="Search">
		</g:form>
	</div>
	
	<div align="center">
		<table width="400px">
			<tr>
				<th><font color="white">First Name</font></th>
				<th><font color="white">Last Name</font></th>
			</tr>
			
			<g:each in="${infos}" var="${info}">
				<tr>
					<td><font color="white"><center>${info.first_name}</center></font></td>
					<td><font color="white"><center>${info.last_name}</center></font></td>
					<td>
						<g:form controller="main" action="viewCustomer">
							<input type="hidden" name="id" value="${info.id}">
							<input type="submit" class="btn btn-primary btn-small" value="View">
						</g:form>
					</td>
				</tr>
			</g:each>
		</table>
	</div>
	
	<div>
		<g:form controller="main" action="index">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div><br/><br/><br/>
	
</body>
</html>