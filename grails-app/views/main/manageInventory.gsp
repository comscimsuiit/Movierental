<html>
<head>
	<title>Manage Inventory</title>
</head>
<body>
	<div>
		<g:form controller="main" action="addInventory">
			Title: <input type="text" name="title">
			<br/>
			Genre: <input type="text" name="genre">
			<br/>
			Director: <input type="text" name="director">
			<br/>
			Actor / Actress: <input type="text" name="actorOrActress">
			<br/>
			Medium: <input type="text" name="medium">
			<br/>
			Rate: <input type="text" name="rate" value="50">
			<br/>
			Overdue Rate: <input type="text" name="overdueRate" value="15">
			<br/>
			<input type="hidden" name="parameter" value="${parameter}">
			<input type="submit" value="Add Movie">
		</g:form>
	</div>

	<div align="center">
		<g:form controller="main" action="manageInventory">
			Search for title,director,genre,medium, actor or actress: <input type="text" name="parameter" value="${parameter}">
			<br/>
			<input type="submit" value="Search">
		</g:form>
	</div>
	
	<div>
		<g:if test="${movies}">
			<table>
				<tr>
					<th>Movie ID</th>
					<th>Title</th>
					<th>Actor / Actress</th>
					<th>Genre</th>
					<th>Director</th>
					<th>Medium</th>
					<th>Rate</th>
					<th>Overdue Rate</th>
					<th colspan="2">Options</th>
				</tr>
				<tr><g:each in="${movies}" var="movie">
					<g:if test="${movie.status.equals("good")}">
						<td bgcolor="#5CB3FF">${movie.id}</td>
						<td bgcolor="#5CB3FF">${movie.title}</td>
						<td bgcolor="#5CB3FF">${movie.actor_or_actress}</td>
						<td bgcolor="#5CB3FF">${movie.genre}</td>
						<td bgcolor="#5CB3FF">${movie.director}</td>
						<td bgcolor="#5CB3FF">${movie.medium}</td>
						<td bgcolor="#5CB3FF">${movie.rate}</td>
						<td bgcolor="#5CB3FF">${movie.overdue_rate}</td>
						<td>
							<g:form controller="main" action="editInventoryInit">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="submit" value="Edit">
							</g:form>
						</td>
						<td>
							<g:form controller="main" action="markAsDamaged">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="submit" name="marker" value="Mark as damaged">
							</g:form>	
						</td>
					</g:if>
					<g:else>
						<td bgcolor="#ffa85c">${movie.id}</td>
						<td bgcolor="#ffa85c">${movie.title}</td>
						<td bgcolor="#ffa85c">${movie.actor_or_actress}</td>
						<td bgcolor="#ffa85c">${movie.genre}</td>
						<td bgcolor="#ffa85c">${movie.director}</td>
						<td bgcolor="#ffa85c">${movie.medium}</td>
						<td bgcolor="#ffa85c">${movie.rate}</td>
						<td bgcolor="#ffa85c">${movie.overdue_rate}</td>
						<td>
							<g:form controller="main" action="editInventoryInit">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="submit" value="Edit">
							</g:form>
						</td>
						<td>
							<g:form controller="main" action="markAsDamaged">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="submit" name="marker" value="Mark as good">
							</g:form>	
						</td>
					</g:else>
					</tr>	
					
				
				</g:each>
			</g:if>
			</table>
	</div>
	
	<div>
		<table>
			<tr>
				<td bgcolor="#5CB3FF"><center>GOOD</center></td>
				<td bgcolor="#ffa85c"><center>DAMAGED</center></td>
			</tr>
		</table>
	</div>
	
</body>
</html>