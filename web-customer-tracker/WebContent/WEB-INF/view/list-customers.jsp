<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Reference our style sheet -->

<link type="text/css"
	  rel="styleSheet"
	  href="${pageContext.request.contextPath/resources/css/style.css}"/>

<!DOCTYPE html>
<html>
<head>
<title>List of customer</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- Add html table -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<!-- Loop over and print our customers -->
				
				<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustome.lastName</td>
						<td>${tempCustome.email</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
		</div>
	</div>

</body>

</html>