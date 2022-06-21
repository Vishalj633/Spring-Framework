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
	
	User: <security:authentication property="principal.username"/>
	<br>
	<br>
	Role(s):<security:authentication property="principal.authorities"/>
	
	<hr>
	
	
	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>


</html>