<html>
<head>
	<meta name="layout" content="admin" />
	<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
	<link href="css/bootstrap.css" rel="stylesheet">
	<meta charset="utf-8">
	<title>Administrator Home</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>

</head>
<body>
	
	<div align="center" class="container">
		<div id="example" class="modal hide fade in" style="display: none; ">
        	<div class="modal-header" align="left">
            	<a class="close icon-remove" data-dismiss="modal"></a>
				<h3>Please fill out the form</h3>
            </div>
            <div class="modal-body">
            	<g:form controller="main" action="addClerk">
					Full Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="fullName" required="true"/>
					<br/>
					Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userName" required="true"/>
					<br/>
					Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password1" required="true">
					<br/>
					Confirm password: <input type="password" name="password2" required="true">
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary btn-large" value="Submit">
				</g:form>
            </div>
            <div class="modal-footer">
              	<%--<a href="#" class="btn btn-success">Confirm</a>--%>
            	<a href="#" class="btn" data-dismiss="modal">Close</a>
            </div>
        </div>
	</div>
	<div align="center">
		<a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Add Clerk</a><br/><br/>
	</div>
	
	<div align="center" class="container">
		<div id="example1" class="modal hide fade in" style="display: none; ">
        	<div class="modal-header" align="left">
            	<a class="close icon-remove" data-dismiss="modal"></a>
				<h3>Please fill out the form</h3>
            </div>
            <div class="modal-body">
 				<g:form controller="main" action="addCustomer">
					First Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="firstName" required="true">
					<br/>
					Last Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lastName" required="true">
					<br/>
					Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address" required="true">
					<br/>
					Contact Number: <input type="text" name="contactNumber" required="true">
					<br/>
					Email Address:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" required="true,email">
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary btn-large" value="Submit">
				</g:form>	        
            </div>
            <div class="modal-footer">
              	<%--<a href="#" class="btn btn-success">Confirm</a>--%>
            	<a href="#" class="btn" data-dismiss="modal">Close</a>
            </div>
        </div>
	</div>
	<div align="center">
		<a data-toggle="modal" href="#example1" class="btn btn-primary btn-large">Add Customer</a><br/><br/>
	</div>
	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	
	<div align="center">
		<g:form controller="main" action="searchForCustomer">
			<input type="submit" class="btn btn-primary btn-large" value="View Customer">
		</g:form>
	</div>
	
	<%--<div align="center">
		<g:form controller="main" action="addClerkInit">
			<input type="submit" class="btn btn-primary btn-large" value="Add Clerk">
		</g:form>
	</div>--%>
	
	<%--<div align="center">
		<g:form controller="main" action="addCustomerInit">
			<input type="submit" class="btn btn-primary btn-large" value="Add Customer">
		</g:form>
	</div>--%>
	
	<div align="center">
		<g:form controller="main" action="manageInventory">
			<input type="submit" class="btn btn-primary btn-large" value="Manage Inventory">
		</g:form>
	</div>
	
	<div align="center">
		<g:form controller="main" action="showTransactions">
			<input type="submit" class="btn btn-primary btn-large" value="Show Transactions">
		</g:form>
	</div>
	
	<br/><br/>

	<div>
		<table width="1000">
			
		<g:each in="${requests}" var="request">
			<%--<table width="900">--%>
			<strong>Customer Request:</strong>
			<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Address</th>
				<th>Contact Number</th>
				<th>Email</th>
				<th> </th>
				<th> </th>
			</tr>
			<tr>
				<td><center>${request.first_name}</center></td>
				<td><center>${request.last_name}</center></td>
				<td><center>${request.address}</center></td>
				<td><center>${request.contact_number}</center></td>
				<td><center>${request.email}</center></td>
				<td>
					<g:form controller="main" action="requestAction">
						<input type="hidden" name="id" value="${request.id}">
						<input type="submit" class="btn btn-primary btn-medium" value="Approve" name="response">
					</g:form>
				</td>
				<td>
					<g:form controller="main" action="requestAction">
						<input type="hidden" name="id" value="${request.id}">
						<input type="submit" class="btn btn-primary btn-medium" value="Reject" name="response">
					</g:form>
				</td>
			</tr>
			<%--</table>--%>
		</g:each>
		</table>
	</div>
	


</body>
</html>