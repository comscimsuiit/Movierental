<html>
<head>
	<meta name="layout" content="admin" />
	<title>Edit Inventory</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>

	<div class="btn-inverse" style='width:400px;'>
		<g:form controller="main" action="editInventory">
			Movie ID: ${infos.id}
			<br/>
			Title:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input required="true" type="text" name="title" value="${infos.title}">
			<br/>
			Genre: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="genre">
				<option value="${infos.genre}">${infos.genre}</option>
				<option value="Action">Action</option>
				<option value="Adventure">Adventure</option>
				<option value="Animation">Animation</option>
				<option value="Biography">Biography</option>
				<option value="Comedy">Comedy</option>
				<option value="Crime">Crime</option>
				<option value="Documentary">Documentary</option>
				<option value="Drama">Drama</option>
				<option value="Family">Family</option>
				<option value="Fantasy">Fantasy</option>
				<option value="History">History</option>
				<option value="Horror">Horror</option>
				<option value="Musical">Musical</option>
				<option value="Romance">Romance</option>
				<option value="Sci-Fi">Sci-Fi</option>
				<option value="Sport">Sport</option>
				<option value="Thriller">Thriller</option>
				<option value="War">War</option>
			</select>
			<br/>
			Director: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input required="true" type="text" name="director" value="${infos.director}">
			<br/>
			Actor / Actress: <input required="true" type="text" name="actorOrActress" value="${infos.actor_or_actress}">
			<br/>
			Medium: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<select name="medium">
				<option value="${infos.medium}">${infos.medium}</option>
				<option value="Blu-Ray">Blu-Ray</option>
				<option value="DVD">DVD</option>
				<option value="HD DVD">HD DVD</option>
				<option value="VCD">VCD</option>
			</select>
			<br/>
			Rate: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp; <input required="true" type="text" name="rate" value="${infos.rate}">
			<br/>
			Overdue Rate: &nbsp;<input required="true" type="text" name="overdueRate" value="${infos.overdue_rate}">
			<br/>
			<input type="hidden" name="parameter" value="${parameter}">
			<input type="hidden" name="id" value="${infos.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary btn-large" value="Submit">			
		</g:form>
	</div>
	
	<div>
		<g:form controller="main" action="manageInventory">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
</body>
</html>