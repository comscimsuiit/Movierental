<html>
<head>
	<title>Select Movie</title>
</head>
<body>
	
	
	
	<div align="center">
		<table>
		<g:each in="${carts}" var="cart">
			<tr>
				<td>${cart.title}</td>
				<td>${cart.actor_or_actress}</td>
				<td>${cart.director}</td>
				<td>${cart.genre}</td>
				<td>${cart.medium}</td>
				<td>${cart.rate}</td>
				<td>${cart.overdue_rate}</td>
				<td>
					<g:form controller="clerk" action="deleteFromCart">
						<input type="hidden" name="parameter" value="${parameter}">
						<input type="hidden" name="movieId" value="${cart.id}">
						<input type="hidden" name="id" value="${id}">
						<input type="submit" value="Delete">
					</g:form>
				</td>
			</tr>
		</g:each>
		</table>
	</div>
	<br/>
	<br/>
	
	
	<div align="center">
		Search for Title, Director, Actor or Actress, Genre, or Medium: 
		<g:form controller="clerk" action="selectMovie">
			<input type="text" name="parameter" value="${parameter}">
			<input type="hidden" name="id" value="${id}">
			<input type="submit" value="Search">
		</g:form>
	</div>
	
	<div>
		<table>
			<tr>
				<th>Title</th>
				<th>Actor / Actress</th>
				<th>Director</th>
				<th>Genre</th>
				<th>Medium</th>
				<th>Rate</th>
				<th>Overdue Rate</th>
			</tr>
			<g:each in="${movies}" var="${movie}">
			<tr>
			
				<td>${movie.title}</td>
				<td>${movie.actor_or_actress}</td>
				<td>${movie.director}</td>
				<td>${movie.genre}</td>
				<td>${movie.medium}</td>
				<td>${movie.rate}</td>
				<td>${movie.overdue_rate}</td>
				<td>
					<g:form controller="clerk" action="addToCart">
						<input type="hidden" name="parameter" value="${parameter}">
						<input type="hidden" name="movieId" value="${movie.id}">
						<input type="hidden" name="id" value="${id}">
						<input type="submit" value="Add to Cart">
					</g:form>
				</td>
			</tr>
			</g:each>
		</table>
	</div>
	
	<div>
		<g:form controller="clerk" action="saveTransaction">
			<input type="hidden" name="id" value="${id}">
			<input type="submit" value="Proceed">
		</g:form>
	</div>

</body>
</html>