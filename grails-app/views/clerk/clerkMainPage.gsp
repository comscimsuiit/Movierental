<html lang="en">
<head>
	<meta name="layout" content="clerk" />
	<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
	<link href="css/bootstrap.css" rel="stylesheet">
	<meta charset="utf-8"> 
	<title>Clerk Home</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>

	<div align="center">
		<g:form controller="clerk" action="searchForCustomer">
			<input type="submit" class="btn btn-primary btn-large" value="Rent Movie">
		</g:form>
	</div>
	
	<div align="center">
		<g:form controller="clerk" action="searchForCustomerRecord">
			<input type="submit" class="btn btn-primary btn-large" value="Return Movie">
		</g:form>
	</div>

	<center>
	<div class="container">
		<div id="example" class="modal hide fade in" style="display: none; ">
        	<div class="modal-header" align="left">
            	<a class="close icon-remove" data-dismiss="modal"></a>
				<h3>Please fill out the form</h3>
            </div>
            <div class="modal-body">
            	<g:form controller="clerk" action="addCustomer">
					First name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="firstName" required="true">
					<br/>
					Last name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lastName" required="true">
					<br/>
					Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address" required="true">
					<br/>
					Contact number: <input type="text" name="contactNumber" required="true">	
					<br/>
					Email Address: &nbsp;&nbsp;&nbsp;<input type="email" name="email" required="true">
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary btn-large" value="Add Customer">
				</g:form>		        
            </div>
            <div class="modal-footer">
              	<%--<a href="#" class="btn btn-success">Confirm</a>--%>
            	<a href="#" class="btn" data-dismiss="modal">Close</a>
            </div>
         </div>
	</div>
		<p>
			<a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Add Customer</a>
		</p>
	</center>
	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	
	<%--<div align="center">
		<g:form controller="clerk" action="addCustomerInit">
			<input type="submit" class="btn btn-primary btn-large" value="Add Customer">
		</g:form>
	</div>--%><br/><br/><br/><br/><br/>
	
</body>
</html>