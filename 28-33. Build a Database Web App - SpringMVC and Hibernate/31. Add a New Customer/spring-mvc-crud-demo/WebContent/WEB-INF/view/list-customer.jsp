<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Customer List</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<!-- Return false from a JavaScript event usually cancels the "default" behavior - in the case of links, it tells the browser to not follow the link. -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false"
				class="add-button" />

			<!-- Add out html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<!-- Loop over and print out customer -->
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>