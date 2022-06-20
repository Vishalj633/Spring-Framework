<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>
<head>
	<title>spring custom form</title>
</head>

<body>
	
	<h3>My custom login page</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		
		<p>
			User Name: <input type="text" name="username"/>
		</p>
		
		<p>
			Password: <input type="password" name="password"/>
		</p>
		
		<input type="button" value="Login"/>
		
	</form:form>


</body>


</html>