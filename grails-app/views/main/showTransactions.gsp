<html>
<head>
	<meta name="layout" content="admin" />
	<title>Transactions</title>
</head>
<body>
	<g:set var="total" value="${0}" />
	<div>
		<form controller="main" action="showTransactions">
			<g:if test="${!parameter}">
				<select name="parameter">
					<option value="daily">Daily</option>
					<option value="weekly">Weekly</option>
					<option value="yearly">Yearly</option>
				</select>
			</g:if>
			<g:if test="${parameter == 'weekly'}">
				<select name="parameter">
					<option value="daily">Daily</option>
					<option value="weekly" selected="selected">Weekly</option>
					<option value="yearly">Yearly</option>
			</select>
			</g:if>
			<g:if test="${parameter == 'yearly'}">
				<select name="parameter">
					<option value="daily">Daily</option>
					<option value="weekly">Weekly</option>
					<option value="yearly" selected="selected">Yearly</option>
			</select>
			</g:if>
			<g:if test="${parameter == 'daily'}">
				<select name="parameter">
					<option value="daily" selected="selected">Daily</option>
					<option value="weekly">Weekly</option>
					<option value="yearly">Yearly</option>
			</select>
			</g:if>
			
			<input type="submit" class="btn btn-primary btn-medium" value="Change">
		</form>
	</div>
	<div>
		<table border="1">
			<g:each in="${transactions}" var="transaction">
				<tr>
					<g:if test="${transaction.type == 'check out'}">
						<td>${transaction.date.format('MM/dd/yyyy')} -- ${transaction.last_name}, ${transaction.first_name} checked out
							<b>${transaction.title} </b> (${transaction.medium}) and paid P${transaction.fee}.
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
		<table>
		P${total}
	</div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
</body>
</html>