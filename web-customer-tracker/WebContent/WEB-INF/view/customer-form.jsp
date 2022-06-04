<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
		<title>Customer Form</title>
		
		<!-- Reference our style sheet -->

		<link type="text/css"
	 		rel="styleSheet"
	  		href="${pageContext.request.contextPath}/resources/css/style.css"/>
	  		
	  	<link type="text/css"
	 		rel="styleSheet"
	  		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
	  		
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer RelationShip Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:from action="saveCustomer" modelAtrribute="customer" method="POST">
			<table>
				<tbody>
					<tr>
						<td><lable>First Name:</lable></td>
						<td><form:input path="firstName"></form:input></td>
					</tr>
					
					<tr>
						<td><lable>Last Name:</lable></td>
						<td><form:input path="lastName"></form:input></td>
					</tr>
					
					<tr>
						<td><lable>First Name:</lable></td>
						<td><form:input path="email"></form:input></td>
					</tr>
					
					<tr>
						<td><lable></lable></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:from>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
		</p>
		
	</div>

</body>

</html>