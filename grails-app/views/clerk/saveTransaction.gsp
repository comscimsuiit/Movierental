<html>
<head>
		<meta name="layout" content="saveTransaction"/>
        <title>Customer Agreement</title>
</head>
<body>

<g:if test="${!movies}">
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	<center><h1><font color="white">No movies are added to the cart.</font></h1></center><br/><br/><br/>
	<g:form controller="clerk" action="selectMovie">
		<center>
		<input type="hidden" name="id" value="${info.id}">
		<input type="submit" class="btn btn-primary btn-small" value="Back">
		</center>
	</g:form>
</g:if>
<g:else>
<g:set var="rate" value="${movies.rate.sum()}" />
<g:set var="overdueRate" value="${movies.overdue_rate.sum()}" />
        
        <div style='min-width:100px; min-height:100px;'>
        <%--<textarea align="center" style='min-width:1200px; min-height:500px;'>--%>
		<center>===========================================================================</center><center>Movie Rental Agreement</center>
		<center>===========================================================================</center><br/>
      
          On ${currentDate}, Movie Rental System Inc. provided to ${info.last_name}, ${info.first_name} the following media/medium in good operating condition:<br/><br/>
                
                <g:each in="${movies}" var="movie">
                        --${movie.title} == P${movie.rate}<br/>
                </g:each>
           With the total of P${rate}<br/><br/>
                
           ${info.last_name}, ${info.first_name} agrees to take full responsibility for the safety of the above equipment and the return of said media/medium in good operating condition to Movie Rental Systems Inc. by 
	   ${dueFormat}.<br/><br/>

           Any media rented to you which has been lost or damaged while in your care will be charged at the replacement costs, or labor and parts for repair. Additional costs for extension of 
	   rental is P${overdueRate} per day.<br/><br/><br/>
	   <div align="right">______________________________</div>
	   <div align="right">Movie Rental System Inc.</div><br/><br/><br/><br/>
       <div align="right">______________________________</div>
	   <div align="right">Customer</right>
                        
                                                
        <%--</textarea>--%>
        </div>
        
        <div>
                <%--<g:form controller="clerk" action="index">
                        <input type="submit" value="Done">
                </g:form>--%>
				<a href="http://localhost:8080/MovieRental/clerk/index">done</a>
        </div>
		<div>
			<a href="#" onclick="window.print();return false;">print</a>
		</div>
			
</g:else>		
        
</body>
</html>