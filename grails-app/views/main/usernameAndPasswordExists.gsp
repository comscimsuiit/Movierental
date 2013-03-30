<html lang="en">
<head>
	<meta name="layout" content="admin" />
	<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
	<link href="css/bootstrap.css" rel="stylesheet">
	<meta charset="utf-8"> 
	<title>Username and Password Exists</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	
	<div align="center">
		<h2><font color="white">The username and password you entered are already exists.</font></h2>
	</div>
	
	<div align="center">
		<g:form controller="main" action="index">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	
</body>
</html>