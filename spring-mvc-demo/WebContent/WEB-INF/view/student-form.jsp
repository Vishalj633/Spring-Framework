<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
</head>

<body>

	<h5>Spring MVC form tags</h5>
	<h5>@ModelAttribute</h5>
	<h5>Spring MVC Data Binding</h5>
	
	<form:form action="processForm" modelAttribute="student" >
	
		First Name: <form:input path="firstName"/>
	
		<br><br>
	
		Last Name: <form:input path="lastName"/>
	
		<br><br>
	
		<h5>On submit spring will call student.setCountry</h5>
		<h5> items refers to collection of data</h5>
		Country: <form:select path="country">  
					
					<form:options items="${student.countryOptions}"/>
			
			   	</form:select>
	
		<br><br>
		
		Favorite language:
		
		Java<form:radiobutton path="favoriteLanguage" value="Java"/>
		C#<form:radiobutton path="favoriteLanguage" value="C#"/>
		CSS<form:radiobutton path="favoriteLanguage" value="CSS"/>
		Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br><br>
		
		Operating Systems:
		Linux<form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
		Windows<form:checkbox path="operatingSystems" value="Windows"/>
		
		<br><br>
	
		<input type="submit" value="Submit" />
	</form:form>

</body>


</html>