<html lang="en">
<head>
	<meta name="layout" content="clerk" />
	<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
	<link href="css/bootstrap.css" rel="stylesheet">
	<meta charset="utf-8"> 
	<title>Clerk Home</title>
</head>
<body>

	<center>
	<div class="container">
		<div id="example" class="modal hide fade in" style="display: none; ">
        	<div class="modal-header">
            	<a class="close" data-dismiss="modal">x</a>
            </div>
            <div class="modal-body">
            	<g:form controller="clerk" action="addCustomer">
					First name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="firstName">
					<br/>
					Last name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lastName">
					<br/>
					Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address">
					<br/>
					Contact number: <input type="text" name="contactNumber">	
					<br/>
					Email Address: &nbsp;&nbsp;&nbsp;<input type="text" name="email">
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
	</div>--%>

	<div align="center">
		<g:form controller="clerk" action="searchForCustomer">
			<input type="submit" class="btn btn-primary btn-large" value="Check Out Movie">
		</g:form>
	</div>
	
	<div align="center">
		<g:form controller="clerk" action="searchForCustomerRecord">
			<input type="submit" class="btn btn-primary btn-large" value="Check In Movie">
		</g:form>
	</div>
</body>
</html>