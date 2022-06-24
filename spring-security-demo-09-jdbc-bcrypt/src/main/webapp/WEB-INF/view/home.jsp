<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML>

<html>
<head>
	<title>Myapp</title>
</head>

<body>

	<h2>Welcome to my world</h2>
	
	<hr>
	<p>
	Welcome home 
	</p>
	
	<hr>
	
	<!-- Display user name and role -->
	<p>
	User: <security:authentication property="principal.username"/>
	<br>
	<br>
	Role(s):<security:authentication property="principal.authorities"/>
	</p>
	<hr>

	<security:authorize access="hasRole('MANAGER')">
	<!-- Add a link to point to /leaders ... this is for the managers -->
	
	<p>
	
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		(Only for managers peeps)
		
	</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
	<!-- Add a link to point to /system ... this is for the admins -->
	
	<p>
	
		<a href="${pageContext.request.contextPath}/system">Admin Tasks</a>
		(Only for admin peeps)
		
	</p>
	</security:authorize>
	
	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>


</html>