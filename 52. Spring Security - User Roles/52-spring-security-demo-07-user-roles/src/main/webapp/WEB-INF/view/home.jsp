<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>My Home Page</title>
</head>

<body>
	<h3>My Home Page</h3>
	<hr />
	<p>Welcome to my home page : Welcome here</p>

	<hr />
	<!-- Display user-name and role -->
	<p>
		User: <security:authentication property="principal.username" />
		<br />
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<hr />

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout">
	</form:form>
	</body>
</html>