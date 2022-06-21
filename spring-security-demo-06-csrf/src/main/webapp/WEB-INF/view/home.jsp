<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	
	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>


</html>