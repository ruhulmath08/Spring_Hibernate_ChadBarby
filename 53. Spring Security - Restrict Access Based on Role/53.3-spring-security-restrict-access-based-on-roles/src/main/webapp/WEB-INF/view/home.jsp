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
		<!-- User ID -->
		User: <security:authentication property="principal.username" />
		<br /> 
		<!-- User Roles -->
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<hr />
	<p>
		<!-- Add a link to point to /leaders ... this is for the managers -->
		<a href="${pageContext.request.contextPath}/leaders" >LeaderShip Meeting</a>
		(Only for Manager peeps)
	</p>
	
	<hr />
	<p>
		<!-- Add a link to point to /systems ... this is for the admins -->
		<a href="${pageContext.request.contextPath}/systems" >IT Systems Meeting</a>
		(Only for Admins peeps)
	</p>
	<hr />

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout">
	</form:form>
</body>
</html>