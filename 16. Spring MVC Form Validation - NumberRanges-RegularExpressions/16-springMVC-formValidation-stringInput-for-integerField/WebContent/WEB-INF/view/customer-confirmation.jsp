<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>

<body>
	The customer is confirmed: ${customer.firstName} ${customer.lastName}
	<br></br> 
	Free Passes: ${customer.freePasses}
	<br></br> 
	Postal Code: ${customer.postalCode}
</body>
</html>