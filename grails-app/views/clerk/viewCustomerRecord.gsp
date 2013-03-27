<html>
<head>
	<meta name="layout" content="clerk" />
	<title>View Customer's Record</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	
	<g:if test="${!movies}">
		<div align="center"><font color="white">NO MOVIES RENTED!<font><div>
		<div>
		<g:form controller="clerk" action="searchForCustomerRecord">
			<%--<center><input type="submit" disable="disable" class="btn btn-primary btn-small" value="Return Movie"></centers>--%>
		</g:form>
	</div>
	</g:if>
	<g:else>
	<g:set var="total" value="${0}" />
	<div align="center">
		<table width="900" class="btn-inverse" style='width:900px;'>
			<tr>
				<th>Movie ID</th>
				<th>Title</th>
				<th>Genre</th>
				<th>Actor or Actress</th>
				<th>Director</th>
				<th>Medium</th>
				<th>Overdue Fee</th>
			</tr>
			<tr>
				<g:form controller="clerk" action="clearLiability">
				<g:each in="${movies}" var="movie">
						<td><center>${movie.movie_id}</center></td>
						<td><center>${movie.title}</center></td>
						<td><center>${movie.genre}</center></td>
						<td><center>${movie.actor_or_actress}</center></td>
						<td><center>${movie.director}</center></td>
						<td><center>${movie.medium}</center></td>
						<g:if test="${now.minus(movie.due_date) > 0}">
							<g:set var="overDue" value="${now.minus(movie.due_date) * movie.overdue_rate}" />
							
							<td><center>${overDue}</center></td>
							<g:set var="total" value="${total + overDue}" />
						</g:if>
						<g:else>
							<td><center>0</center></td>
						</g:else>
						<td><input type="checkbox" name="movieID" value="${movie.movie_id}"></td>
					<tr/>
				</g:each>
				
		</table><br/>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		&nbsp;<font color="white">TOTAL OVERDUE FEE: ${total}</font>
		<br/>
		<input type="hidden" name="totalDue" value="${total}">
		<input type="hidden" name="id" value="${id}">
		<input type="submit" class="btn btn-primary btn-large" value="Return Movie">
		</g:form>
	</div>
	</g:else>
	
	<div>
		<g:form controller="clerk" action="searchForCustomerRecord">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
	
</body>
</html>