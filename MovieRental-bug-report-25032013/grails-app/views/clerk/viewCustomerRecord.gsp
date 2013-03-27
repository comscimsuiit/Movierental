<html>
<head>
	<title>View Customer's Record</title>
</head>
<body>
	<g:set var="total" value="${0}" />
	<div>
		<table border="1">
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
				<input type="hidden" name="id" value="${id}">
				<g:each in="${movies}" var="movie">
						<td>${movie.id}</td>
						<td>${movie.title}</td>
						<td>${movie.genre}</td>
						<td>${movie.actor_or_actress}</td>
						<td>${movie.director}</td>
						<td>${movie.medium}</td>
						<g:if test="${now.minus(movie.due_date) > 0}">
							<g:set var="overDue" value="${now.minus(movie.due_date) * movie.overdue_rate}" />
							
							<td>${overDue}</td>
							
							<g:set var="total" value="${total + overDue}" />
						</g:if>
						<g:else>
							<td>0</td>
						</g:else>
						<td><input type="checkbox" name="movieID" value="${movie.id}"></td>
					<tr/>
				</g:each>
				
		</table>
		TOTAL OVERDUE FEE: ${total}
		<input type="hidden" name="totalDue" value="${total}">
		<input type="submit" value="Return Movie">
		</g:form>
	</div>
	
	
</body>
</html>