<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>
	
	<h5>used JSP expression language to display first and last name</h5>
	
	The Customer is confirmed: ${customer.firstName} ${customer.lastName}
	
	<br><br>
	
	Free Passes: ${customer.freePasses}
	
	<br><br>
	
	Postal Code: ${customer.postalCode}
	
	<br><br>
	
	Course Code: ${customer.courseCode}

</body>

</html>