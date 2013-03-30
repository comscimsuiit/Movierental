<html>
<head>
	<meta name="layout" content="admin" />
	<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
	<link href="css/bootstrap.css" rel="stylesheet">
	<meta charset="utf-8"> 
	<title>Manage Inventory</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	
	<center>
	<div class="container">
		<div id="example" class="modal hide fade in" style="display: none; ">
        	<div class="modal-header" align="left">
            	<a class="close icon-remove" data-dismiss="modal"></a>
				<h3>Please fill out the form</h3>
            </div>
            <div class="modal-body">
				<g:form controller="main" action="addInventory">
					Title:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input required="true" type="text" name="title" placeholder="Movie Title">
					<br/>
					Genre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select required="true" name="genre">
						<option value=""></option>
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
						<option value="Musical">Musical</option>
						<option value="Romance">Romance</option>
						<option value="Sci-Fi">Sci-Fi</option>
						<option value="Sport">Sport</option>
						<option value="Thriller">Thriller</option>
						<option value="War">War</option>
					</select>
					<br/>
					Director:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input required="true" type="text" name="director" placeholder="Movie Director">
					<br/>
					Actor / Actress: <input required="true" type="text" name="actorOrActress" placeholder="Movie Actor/Actress">
					<br/>
					Medium:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select required="true" name="medium">
						<option value=""></option>
						<option value="Blu-Ray">Blu-Ray</option>
						<option value="DVD">DVD</option>
						<option value="HD DVD">HD DVD</option>
						<option value="VCD">VCD</option>
					</select>
					<br/>
					Rate:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="rate" value="50" required="true">
					<br/>
					Overdue Rate:&nbsp;&nbsp;<input type="text" name="overdueRate" value="15" required="true">
					<br/>
					<input type="hidden" name="parameter" value="${parameter}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary btn-large" value="Add Movie">
				</g:form>
           	</div>
            <div class="modal-footer">
              	<%--<a href="#" class="btn btn-success">Confirm</a>--%>
            	<a href="#" class="btn" data-dismiss="modal">Close</a>
            </div>
         </div>
	</div>
	<p>
		<a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Add Movie</a>
	</p>
	</center>

	<div align="center">
		<g:form controller="main" action="manageInventory" class="form-search">
			<font color="white">Search for title,director,genre,medium, actor or actress:</font> <br/><input type="text" placeholder="Search" name="parameter" value="${parameter}" class="input-medium search-query input-xlarge icon-search">
			<input type="submit" class="btn btn-primary btn-small" value="Search" autocomplete="on">
		</g:form>
	</div>
	
	<%--<div>
		Please select genre:
		<form controller="main" action="manageInventory">
			<g:if test="${!parameter}">
				<select name="parameter">
					<option selected="selected"></option>
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Action'}">
				<select name="parameter">
					<option value="Action" selected="selected">Action</option>
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
			</select>
			</g:if>
			<g:if test="${parameter == 'Adventure'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure" selected="selected">Adventure</option>
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
			</select>
			</g:if>
			<g:if test="${parameter == 'Animation'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation" selected="selected">Animation</option>
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
			</select>
			</g:if>
			<g:if test="${parameter == 'Biography'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation">Animation</option>
					<option value="Biography" selected="selected">Biography</option>
					<option value="Comedy">Comedy</option>
					<option value="Crime">Crime</option>
					<option value="Documentary">Documentary</option>
					<option value="Drama">Drama</option>
					<option value="Family">Family</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Comedy'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation">Animation</option>
					<option value="Biography">Biography</option>
					<option value="Comedy" selected="selected">Comedy</option>
					<option value="Crime">Crime</option>
					<option value="Documentary">Documentary</option>
					<option value="Drama">Drama</option>
					<option value="Family">Family</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Crime'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation">Animation</option>
					<option value="Biography">Biography</option>
					<option value="Comedy">Comedy</option>
					<option value="Crime" selected="selected">Crime</option>
					<option value="Documentary">Documentary</option>
					<option value="Drama">Drama</option>
					<option value="Family">Family</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Documentary'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation">Animation</option>
					<option value="Biography">Biography</option>
					<option value="Comedy">Comedy</option>
					<option value="Crime">Crime</option>
					<option value="Documentary" selected="selected">Documentary</option>
					<option value="Drama">Drama</option>
					<option value="Family">Family</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Drama'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation">Animation</option>
					<option value="Biography">Biography</option>
					<option value="Comedy">Comedy</option>
					<option value="Crime">Crime</option>
					<option value="Documentary">Documentary</option>
					<option value="Drama" selected="selected">Drama</option>
					<option value="Family">Family</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Family'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation">Animation</option>
					<option value="Biography">Biography</option>
					<option value="Comedy">Comedy</option>
					<option value="Crime">Crime</option>
					<option value="Documentary">Documentary</option>
					<option value="Drama">Drama</option>
					<option value="Family" selected="selected">Family</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Fantasy'}">
				<select name="parameter">
					<option value="Action">Action</option>
					<option value="Adventure">Adventure</option>
					<option value="Animation">Animation</option>
					<option value="Biography">Biography</option>
					<option value="Comedy">Comedy</option>
					<option value="Crime">Crime</option>
					<option value="Documentary">Documentary</option>
					<option value="Drama">Drama</option>
					<option value="Family">Family</option>
					<option value="Fantasy" selected="selected">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'History'}">
				<select name="parameter">
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
					<option value="History" selected="selected">History</option>
					<option value="Horror">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Horror'}">
				<select name="parameter">
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
					<option value="Horror" selected="selected">Horror</option>
					<option value="Musical">Musical</option>
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Musical'}">
				<select name="parameter">
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
					<option value="Musical" selected="selected">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Romance'}">
				<select name="parameter">
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
					<option value="Musical">Musical</option>
					<option value="Romance" selected="selected">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Sci-Fi'}">
				<select name="parameter">
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi" selected="selected">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Sport'}">
				<select name="parameter">
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport" selected="selected">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'Thriller'}">
				<select name="parameter">
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller" selected="selected">Thriller</option>
					<option value="War">War</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'War'}">
				<select name="parameter">
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
					<option value="Musical">Musical</option>
					<option value="Romance">Romance</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sport">Sport</option>
					<option value="Thriller">Thriller</option>
					<option value="War" selected="selected">War</option>
				</select>
			</g:if>
			<input type="submit" class="btn btn-primary btn-medium" value="Change">
		</form>
	</div>--%>
	
	<div>
		<g:form controller="main" action="index">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
			
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	
	<div align="center">
		<g:if test="${movies}">
			<table width="1200" border="1">
				<tr class="btn-inverse">
					<th width="70">Movie ID</th>
					<th>Title</th>
					<th>Actor / Actress</th>
					<th>Genre</th>
					<th>Director</th>
					<th width="40">Medium</th>
					<th width="40">Rate</th>
					<th width="1">Overdue Rate</th>
					<th colspan="2">Options</th>
				</tr>
				<tr><g:each in="${movies}" var="movie">
					<g:if test="${movie.status.equals("good")}">
						<%--<td bgcolor="#5CB3FF"><center>${movie.id}</center></td>--%>
						<td bgcolor="Aquamarine"><center>${movie.id}</center></td>
						<td bgcolor="Aquamarine"><center>${movie.title}</center></td>
						<td bgcolor="Aquamarine"><center>${movie.actor_or_actress}</center></td>
						<td bgcolor="Aquamarine"><center>${movie.genre}</center></td>
						<td bgcolor="Aquamarine"><center>${movie.director}</center></td>
						<td bgcolor="Aquamarine"><center>${movie.medium}</center></td>
						<td bgcolor="Aquamarine"><center>${movie.rate}</center></td>
						<td bgcolor="Aquamarine"><center>${movie.overdue_rate}</center></td>
						<td width="1">
							<g:form controller="main" action="editInventoryInit">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="submit" class="btn btn-primary btn-medium" value="Edit">
							</g:form>
						</td>
						<td width="1">
							<g:form controller="main" action="markAsDamaged">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="submit" name="marker" class="btn btn-primary btn-medium" value="Mark as damaged">
							</g:form>	
						</td>
					</g:if>
					<g:else>
						<%--<td bgcolor="#ffa85c"><center>${movie.id}</center></td>--%>
						<td bgcolor="Khaki"><center>${movie.id}</center></td>
						<td bgcolor="Khaki"><center>${movie.title}</center></td>
						<td bgcolor="Khaki"><center>${movie.actor_or_actress}</center></td>
						<td bgcolor="Khaki"><center>${movie.genre}</center></td>
						<td bgcolor="Khaki"><center>${movie.director}</center></td>
						<td bgcolor="Khaki"><center>${movie.medium}</center></td>
						<td bgcolor="Khaki"><center>${movie.rate}</center></td>
						<td bgcolor="Khaki"><center>${movie.overdue_rate}</center></td>
						<td width="1">
							<g:form controller="main" action="editInventoryInit">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="submit" class="btn btn-primary btn-medium" value="Edit">
							</g:form>
						</td>
						<td width="1">
							<g:form controller="main" action="markAsDamaged">
								<input type="hidden" name="parameter" value="${parameter}">
								<input type="hidden" name="id" value="${movie.id}">
								<input type="submit" name="marker" class="btn btn-primary btn-medium" value="Mark as good">
							</g:form>	
						</td>
					</g:else>
					</tr>	
					
				
				</g:each>
			</g:if>
			</table>
	</div><br/><br/>
	
	<div>
		<p class="btn-inverse" style='width:50px;'>Legend:</p>
		<table>
			<tr>
				<td bgcolor="Aquamarine"><center>GOOD</center></td>
				<td bgcolor="Khaki"><center>DAMAGED</center></td>
			</tr>
		</table>
	</div>
	
</body>
</html>