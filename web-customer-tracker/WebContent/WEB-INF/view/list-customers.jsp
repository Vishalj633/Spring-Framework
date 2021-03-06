<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<!-- Reference our style sheet -->

<link type="text/css"
	  rel="styleSheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css"/>

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
			
			<!-- Put new button to add new customer -->
			
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"/>
			
			<!-- Add html table -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- Loop over and print our customers -->
				
				<c:forEach var="tempCustomer" items="${customers}">
					<!-- Constructor an update link with customer id -->
					
					<c:url var="updateLink" value="custmer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="custmer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- Display the update link -->
							<a href="${updateLink}">Update</a>
							|
						    <!-- Delete the update link -->
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
		</div>
	</div>

</body>

</html>