<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Form</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>

<body>
	<i><b>Fill out the form. Asterisk (*) means required</b></i>
	<br></br>

	<form:form action="processForm" modelAttribute="customer">
		First Name: <form:input path="firstName" />
		<br></br>
		
		Last Name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br></br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>