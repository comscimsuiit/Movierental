<html lang="en">
<head>
	<meta name="layout" content="login"/>
	<meta charset="utf-8">
	<title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Starter files for implementing Twitter Bootstrap's Carousel -- using Bootstrap version 2.0.4">
    <meta name="author" content="David Cochran for webdesign.tutsplus.com">
	
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

	<style type="text/css">
		label{
			float:left;
			width:65px;
		}
	</style>
</head>
<body>
   
	<br><br>
	<g:if test="${flash.message }">
		<div class="message">
			${flash.message}
		</div>
	</g:if>
	<g:if test="${session.user }">
		<br/>
		Login as : ${session.user } | <g:link action="logout">Logout</g:link>
	</g:if>
	<g:else>
		<g:form controller="user" action="login" style="padding-left:220px">
		<div id="main" style="width:220px">
		<script type="text/javascript" src="js/contact-form.js"></script>
		<div class="forms">
			<h1>Please sign-in</h1>
			<input type="text" name="user_name" value="${user_name}" placeholder="Username"/>
			<input type="password" name="password" value="${password}" placeholder="Password"/>
			<label>&nbsp;</label><input type="submit" class="btn btn-primary btn-default" value="Login"/>
		</div>
		</div>
		</g:form>
	</g:else>
	
    
	
</body>
</html>