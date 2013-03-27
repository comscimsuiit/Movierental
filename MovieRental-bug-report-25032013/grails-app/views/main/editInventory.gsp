<html>
<head>
	<title>Edit Inventory</title>
</head>
<body>

	<div>
		<g:form controller="main" action="editInventory">
			${infos.id}
			<br/>
			Title: <input type="text" name="title" value="${infos.title}">
			<br/>
			Genre: <input type="text" name="genre" value="${infos.genre}">
			<br/>
			Director: <input type="text" name="director" value="${infos.director}">
			<br/>
			Actor / Actress: <input type="text" name="actorOrActress" value="${infos.actor_or_actress}">
			<br/>
			Medium: <input type="text" name="medium" value="${infos.medium}">
			<br/>
			Rate: <input type="text" name="rate" value="${infos.rate}">
			<br/>
			Overdue Rate: <input type="text" name="overdueRate" value="${infos.overdue_rate}">
			<br/>
			<input type="hidden" name="parameter" value="${parameter}">
			<input type="hidden" name="id" value="${infos.id}">
			<input type="submit" value="Submit">			
		</g:form>
	</div>
	
</body>
</html>