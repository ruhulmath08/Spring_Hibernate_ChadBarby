<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />
		<br></br>
		Last name: <form:input path="lastName" />
		<br></br>
		
		Country: <form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br></br>
		
		Favorite Language:
		Java: <form:radiobutton path="favoriteLanguage" value="Java" />
		C: <form:radiobutton path="favoriteLanguage" value="C" />
		C++: <form:radiobutton path="favoriteLanguage" value="C++" />
		PHP: <form:radiobutton path="favoriteLanguage" value="PHP" />
		Go: <form:radiobutton path="favoriteLanguage" value="Go" />
		<br></br>
		
		Operating System:
		Linux <form:checkbox path="operatingSystem" value="Linux" />
		MS Windows <form:checkbox path="operatingSystem" value="MS Windows" />
		Mac-OS <form:checkbox path="operatingSystem" value="Mac OS" />
		Solaries-OS <form:checkbox path="operatingSystem" value="Solaries" />
		<br></br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>