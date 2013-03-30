<html>
	<head>
		<title><g:message code="error.404.title"/></title>
		<meta name="layout" content="login" />
		<g:set var="layout_nomainmenu"		value="${true}" scope="request"/>
		<g:set var="layout_nosecondarymenu"	value="${true}" scope="request"/>
	</head>

<body>
	<%--<content tag="header">
		<!-- Empty Header -->
	</content>--%>
	
  	<section id="Error" class="">
		<div class="big-message">
			<div class="container">
				<h1>
					<%--<g:message code="error.404.callout"/>--%>
				</h1>
				<%--<h2>
					<g:message code="error.404.title"/>
				</h2>--%>
				<%--<p>
					<g:message code="error.404.message"/>
				</p>--%>
				
				<div class="actions">
					<a href="http://localhost:8080/MovieRental" class="btn btn-large btn-primary">
						<i class="icon-chevron-left icon-white"></i>
						<%--<g:message code="error.button.backToHome"/>--%>
						<g:message code="Back to Login Form"/>
					</a>					
				</div>
			</div>
		</div>
	</section>
  
  
  </body>
</html>