<html lang="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'}">
<head>
	<meta name="layout" content="clerk" />
	
	<meta charset="utf-8"> 
	<title>Select Movie</title>
	<link href="css/bootstrap.css" rel="stylesheet">
	
	<style>
		body {
			background-color: #000000;
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-modal.js"></script>

	<div align="center">
		<table width="980">
			<font color="white"><h4 class="icon-shopping-cart">Cart</h4></font>
			<tr bgcolor="Aquamarine">
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
				<td bgcolor="AntiqueWhite"><center>${cart.title}</center></td>
				<td bgcolor="AntiqueWhite"><center>${cart.actor_or_actress}</center></td>
				<td bgcolor="AntiqueWhite"><center>${cart.director}</center></td>
				<td bgcolor="AntiqueWhite"><center>${cart.genre}</center></td>
				<td bgcolor="AntiqueWhite"><center>${cart.medium}</center></td>
				<td bgcolor="AntiqueWhite"><center>${cart.rate}</center></td>
				<td bgcolor="AntiqueWhite"><center>${cart.overdue_rate}</center></td>
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
	
	<g:if test = "${counter < 3}">
	<div align="center">
		<font color="white">Search for Title, Director, Actor or Actress, Genre, or Medium:</font>
		<g:form controller="clerk" action="selectMovie" class="form-search">
			<input type="text" placeholder="Search" name="parameter" value="${parameter}" class="input-medium search-query icon-search">
			<input type="hidden" name="id" value="${id}">
			<input type="submit" class="btn btn-primary btn-small" value="Search">
		</g:form>
	</div>
	
	
	<div align="center">
		<table width="980">
			<tr bgcolor="Aquamarine">
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
				<td bgcolor="AntiqueWhite"><center>${movie.title}</center></td>
				<td bgcolor="AntiqueWhite"><center>${movie.actor_or_actress}</center></td>
				<td bgcolor="AntiqueWhite"><center>${movie.director}</center></td>
				<td bgcolor="AntiqueWhite"><center>${movie.genre}</center></td>
				<td bgcolor="AntiqueWhite"><center>${movie.medium}</center></td>
				<td bgcolor="AntiqueWhite"><center>${movie.rate}<center></td>
				<td bgcolor="AntiqueWhite"><center>${movie.overdue_rate}</center></td>
				<td>
					
					<g:form controller="clerk" action="addToCart">
						<input type="hidden" name="parameter" value="${parameter}">
						<input type="hidden" name="movieId" value="${movie.id}">
						<input type="hidden" name="id" value="${id}">
						<i class="icon-shopping-cart"></i>
						<input type="submit" class="btn btn-primary btn-small" value="Add to Cart">
					</g:form>
				</td>
			</tr>
			</g:each>
		</table>
	</div><br/>
	</g:if>
	<div class="container">
		<div id="example" class="modal hide fade in" style="display: none; ">
        	<div class="modal-header" align="center">
            	<a class="close icon-remove" data-dismiss="modal"></a>
				<h3>Are you sure?</h3>
            </div>
            <div class="modal-body" align="center">
            	<g:form url="http://localhost:8080/MovieRental/clerk/saveTransaction" controller="clerk" action="saveTransaction">
					<input type="hidden" name="id" value="${id}">
					<input type="submit" class="btn btn-primary btn-small" value="Yes">
					<a href="#" class="btn btn-primary btn-small" data-dismiss="modal">No</a>
				</g:form>	        
            </div>
         </div>
	</div>
	<p>
		<center><a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Print Receipt</a></center>
	</p>
	
	<%--<div align="center">
		<g:form url="http://localhost:8080/MovieRental/clerk/saveTransaction" controller="clerk" action="saveTransaction">
			<input type="hidden" name="id" value="${id}">
			<input type="submit" class="btn btn-primary btn-large" value="Print Receipt">
		</g:form>
	</div>--%>
	
	<div>
		<g:form url="http://localhost:8080/MovieRental/clerk/searchForCustomer">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
</body>
</html>