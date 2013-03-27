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

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	
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
					Confirm Password: <input type="password" name="password2" required="true">
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
					Email Address:&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email" required="true,email">
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
	
<section id="info">
<div class="row-fluid">
	<div class="span2">
	<table>
	
	<tr>
	<td><div>
		<a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Add Clerk</a><br/><br/>
		</div>
	
	<div>
		<a data-toggle="modal" href="#example1" class="btn btn-primary btn-large">Add Customer</a><br/><br/>
	</div>
	
	<div>
		<g:form controller="main" action="searchForCustomer">
			<input type="submit" class="btn btn-primary btn-large" value="View Customer">
		</g:form>
	</div>
	
	<div>
		<g:form controller="main" action="manageInventory">
			<input type="submit" class="btn btn-primary btn-large" value="Manage Inventory">
		</g:form>
	</div>

	<div>
		<g:form controller="main" action="showTransactions">
			<input type="submit" class="btn btn-primary btn-large" value="Show Transaction">
		</g:form>
	</div>
	</td>
	</tr>
	
	</table>
	</div>

	
	<div class="span2">
	<g:if test="${requests}">
		<strong><font color="white">Customer Request:</font></strong>
		<table width="1000">
			
			<tr>
				<th><font color="white">ID</font></th>
				<th><font color="white">First Name</font</th>
				<th><font color="white">Last Name</font</th>
				<th><font color="white">Address</font</th>
				<th><font color="white">Contact Number</font</th>
				<th><font color="white">Email</font</th>
				<th> </th>
				<th> </th>
			</tr>
		<g:each in="${requests}" var="request">
			<tr>
				<td><font color="white"><center>${request.id}</center></font></td>
				<td><font color="white"><center>${request.first_name}</center></font></td>
				<td><font color="white"><center>${request.last_name}</center></font></td>
				<td><font color="white"><center>${request.address}</center></font></td>
				<td><font color="white"><center>${request.contact_number}</center></font></td>
				<td><font color="white"><center>${request.email}</center></font></td>
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
		</g:each>
		</table>
	</g:if>
	</div><br/><br/><br/><br/><br/>
</div>
</section>


</body>
</html>