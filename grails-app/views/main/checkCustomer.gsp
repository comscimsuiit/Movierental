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
<<<<<<< HEAD
		<g:form class="form-search" controller="main" action="searchForCustomer">
=======
		<g:form class="form-search" controller="main" action="searchForCustomer2">
>>>>>>> origin/master
			<input type="text" placeholder="Search Customer" name="parameter" value="${parameter}" class="input-medium search-query icon-search">
			<input type="submit" class="btn btn-primary btn-small" value="Search">
		</g:form>
	</div>
	
<<<<<<< HEAD
	<div align="center">
	<g:if test="${infos}">
		<table width="400px">
				<tr>
					<th><font color="white">First Name</font></th>
					<th><font color="white">Last Name</font></th>
				</tr>
=======
	<%--<div align="center">
		<table width="400px">
			<tr>
				<th><font color="white">First Name</font></th>
				<th><font color="white">Last Name</font></th>
			</tr>
			
>>>>>>> origin/master
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
<<<<<<< HEAD
	</g:if>
	</div>
=======
	</div>--%>
>>>>>>> origin/master
	
	<div>
		<g:form controller="main" action="index">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
</body>
</html>