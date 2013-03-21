<html>
<head>
	<meta name="layout" content="admin" />
	<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
	<link href="css/bootstrap.css" rel="stylesheet">
	<meta charset="utf-8">
	<title>Transactions' View</title>
	
	<style type="text/css">
		body {
			background-image: url("../images/img/tile.jpg");
		}
	</style>
	
</head>
<body>
	<g:set var="total" value="${0}" />
	<div align="center">
		<font color="white">Please select:</font>
		<form controller="main" action="showTransactions">
			<g:if test="${!parameter}">
				<select name="parameter">
					<option value="daily">Daily</option>
					<option value="weekly">Weekly</option>
					<%--<option value="monthly">Monthly</option>--%>
					<option value="yearly">Yearly</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'weekly'}">
				<select name="parameter">
					<option value="daily">Daily</option>
					<option value="weekly" selected="selected">Weekly</option>
					<%--<option value="monthly">Monthly</option>--%>
					<option value="yearly">Yearly</option>
			</select>
			</g:if>
			<g:if test="${parameter == 'yearly'}">
				<select name="parameter">
					<option value="daily">Daily</option>
					<option value="weekly">Weekly</option>
					<%--<option value="monthly">Monthly</option>--%>
					<option value="yearly" selected="selected">Yearly</option>
			</select>
			</g:if>
			<g:if test="${parameter == 'daily'}">
				<select name="parameter">
					<option value="daily" selected="selected">Daily</option>
					<option value="weekly">Weekly</option>
					<%--<option value="monthly">Monthly</option>--%>
					<option value="yearly">Yearly</option>
			</select>
			</g:if>
			<%--<g:if test="${parameter == 'monthly'}">
				<select name="parameter">
					<option value="daily">Daily</option>
					<option value="weekly">Weekly</option>
					<option value="monthly" selected="selected">Monthly</option>
					<option value="yearly">Yearly</option>
				</select>
			</g:if>--%>
			<input type="submit" class="btn btn-primary btn-medium" value="Change">
		</form>
	</div>
	
	<div>
		<g:form controller="main" action="index">
			<input type="submit" class="btn btn-primary btn-small" value="Back">
		</g:form>
	</div>
	
	<div align="center">
		<table border="1">
				<tr>
					<th></th>
				</tr>
			<g:each in="${transactions}" var="transaction">
				<tr bgcolor="PeachPuff">
					<g:if test="${transaction.type == 'check out'}">
						<td>${transaction.date.format('MM/dd/yyyy')} -- ${transaction.last_name}, ${transaction.first_name} checked out
							<b>${transaction.title} </b> (${transaction.medium}) and paid <b>P${transaction.fee}</b>.
						</td>
						<g:set var="total" value="${total + transaction.fee}" />
					</g:if>
					<g:else>
						<g:if test="${transaction.fee > 0}">
							<td>
								${transaction.date.format('MM/dd/yyyy')} -- ${transaction.last_name}, ${transaction.first_name} checked in
							<b>${transaction.title} </b> (${transaction.medium}) and paid P${transaction.fee} as overdue fee.
							</td>
							<g:set var="total" value="${total + transaction.fee}" />
						</g:if>
						<g:else>
							<td>
								${transaction.date.format('MM/dd/yyyy')} -- ${transaction.last_name}, ${transaction.first_name} checked in
							<b>${transaction.title} </b> (${transaction.medium}).
							</td>
						</g:else>
					</g:else>
				</tr>
			</g:each>
				<tr bgcolor="PaleTurquoise">
					<td>TOTAL P${total}</td>
				</tr>
		<table>
	</div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
</body>
</html>