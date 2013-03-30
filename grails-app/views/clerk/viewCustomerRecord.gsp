<html>
<head>
	<title>View Customer's Record</title>
</head>
<body>
	<g:set var="total" value="${0}" />
	<div align="center">
		<table width="900">
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
						<td><center>${movie.id}</center></td>
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
						<td><input type="checkbox" name="movieID" value="${movie.id}"></td>
					<tr/>
				</g:each>
				
		</table><br/>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		&nbsp;TOTAL OVERDUE FEE: ${total}
		<br/>
		<input type="hidden" name="totalDue" value="${total}">
		<input type="submit" class="btn btn-primary btn-large" value="Return Movie">
		</g:form>
	</div>
	
	<div>
		<g:form controller="clerk" action="searchForCustomerRecord">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
	
</body>
</html>