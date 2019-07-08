<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>My Home Page</title>
</head>

<body>
	<h3>My Home Page</h3>
	<hr />
	<p>Welcome to my home page : Welcome here</p>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
		method="POST">
		
		<input type="submit" value="Logout" >
	</form:form>
</body>
</html>