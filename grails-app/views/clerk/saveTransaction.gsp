<html>
<head>
	<title>Customer Agreement</title>
	 <script type="text/javascript">
      function printTextArea() {
        childWindow = window.open('','childWindow','location=yes, menubar=yes, toolbar=yes');
        childWindow.document.open();
        childWindow.document.write('<html><head></head><body>');
        childWindow.document.write(document.getElementById('targetTextArea').value.replace(/\n/gi,'<br>'));
        childWindow.document.write('</body></html>');
        childWindow.print();
        childWindow.document.close();
        childWindow.close();
      }
    </script>

	
</head>
<body>
<g:set var="rate" value="${movies.rate.sum()}" />
<g:set var="overdueRate" value="${movies.overdue_rate.sum()}" />

	
	<div align="center">
		<g:textArea name="text" rows="30" cols="75">
===========================================================================
                            Movie Rental Agreement
===========================================================================
      
	  On ${currentDate}, Movie Rental System Inc. provided to ${info.last_name}, ${info.first_name} the following media/medium in good operating condition:
		
		<g:each in="${movies}" var="movie">
			--${movie.title} == P${movie.rate}
		</g:each>
	   With the total of P${rate}
		
           ${info.last_name}, ${info.first_name} agrees to take full responsibility for the safety of the above equipment and the return of said media/medium in good operating condition to Movie Rental Systems Inc. by ${dueFormat}.

	   Any media rented to you which has been lost or damaged while in your care will be charged at the replacement costs, or labor and parts for repair. Additional costs for extension of rental is P${overdueRate} per day.
	   
	   
	                                  ______________________________ 
	                                      Movie Rental System Inc.                                                                          
				
             				    
	                                  ______________________________
						     Customer
                        
						
				</g:textArea>
		<input type="button" onclick="printTextArea()" value="Print Text"/>
	</div>
	
	<div>
		<g:form controller="clerk" action="index">
			<input type="submit" value="Done">
		</g:form>
	</div>
	
</body>
</html>