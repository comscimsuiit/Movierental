<html>
<head>
	<meta name="layout" content="clerk" />
	<title>Search Customer</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	
	<div align="center">
		<g:form controller="clerk" action="searchForCustomerRecord" class="form-search">
			<input type="text" placeholder="Search Customer" name="parameter" value="${parameter}" class="input-medium search-query icon-search">
			<input type="submit" class="btn btn-primary btn-small" value="Search">
		</g:form>
	</div>
	
	<div align="center">
	<g:if test="${infos}">
		<table width=700>
				<tr>
					<th><font color="white">First Name</font></th>
					<th><font color="white">Last Name</font></th>
				</tr>
			<g:each in="${infos}" var="${info}">
				<tr>
					<td><font color="white"><center>${info.first_name}</center></font></td>
					<td><font color="white"><center>${info.last_name}</center></font></td>
					<td>
						<g:form controller="clerk" action="viewCustomerRecord">
							<input type="hidden" name="id" value="${info.id}">
							<input required="true" type="submit" class="btn btn-primary btn-small" value="View">
						</g:form>
					</td>
				</tr>
			</g:each>
		</table>
	</g:if>
	</div><br/><br/><br/><br/>
	
	<div>
		<g:form controller="clerk" action="index">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>		
	</div><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
</body>
</html>