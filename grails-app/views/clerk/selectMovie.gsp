<html>
<head>
	<title>Select Movie</title>
</head>
<body>
	
	<center><h4>Cart</h4></center>
	<div align="center">
		<table width="900">
			<tr>
				<th>Title</th>
				<th>Actor / Actress</th>
				<th>Director</th>
				<th>Genre</th>
				<th>Medium</th>
				<th>Rate</th>
				<th>Overdue Rate</th>
			</tr>
		<g:each in="${carts}" var="cart">
			<tr>
				<td><center>${cart.title}</center></td>
				<td><center>${cart.actor_or_actress}</center></td>
				<td><center>${cart.director}</center></td>
				<td><center>${cart.genre}</center></td>
				<td><center>${cart.medium}</center></td>
				<td><center>${cart.rate}</center></td>
				<td><center>${cart.overdue_rate}</center></td>
				<td>
					<g:form controller="clerk" action="deleteFromCart">
						<input type="hidden" name="parameter" value="${parameter}">
						<input type="hidden" name="movieId" value="${cart.id}">
						<input type="hidden" name="id" value="${id}">
						<input type="submit" class="btn btn-primary btn-small" value="Delete">
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
			<input type="text" placeholder="Search" name="parameter" value="${parameter}">
			<input type="hidden" name="id" value="${id}">
			<input type="submit" class="btn btn-primary btn-small" value="Search">
		</g:form>
	</div>
	
	<div align="center">
		<table width="900">
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
			
				<td><center>${movie.title}</center></td>
				<td><center>${movie.actor_or_actress}</center></td>
				<td><center>${movie.director}</center></td>
				<td><center>${movie.genre}</center></td>
				<td><center>${movie.medium}</center></td>
				<td><center>${movie.rate}<center></td>
				<td><center>${movie.overdue_rate}</center></td>
				<td>
					<g:form controller="clerk" action="addToCart">
						<input type="hidden" name="parameter" value="${parameter}">
						<input type="hidden" name="movieId" value="${movie.id}">
						<input type="hidden" name="id" value="${id}">
						<input type="submit" class="btn btn-primary btn-small" value="Add to Cart">
					</g:form>
				</td>
			</tr>
			</g:each>
		</table>
	</div>
	
	<div align="center">
		<g:form controller="clerk" action="saveTransaction">
			<input type="hidden" name="id" value="${id}">
			<input type="submit" class="btn btn-primary btn-large" value="Proceed">
		</g:form>
	</div>
	
	<div>
		<g:form url="http://localhost:8080/MovieRental/clerk/searchForCustomer">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
</body>
</html>