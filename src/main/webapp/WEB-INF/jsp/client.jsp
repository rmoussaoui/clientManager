<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Client record</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<form:form method="POST" modelAttribute="client" action="/clients">
		<h1>Client record</h1>
		
		<form:input type="hidden" path="clientId"/>
		
		<label for="name">Name:</label>
		<form:input path="name" />
		
		
		<br/>
	
		<label for="birthdate">Birthdate:</label>
		<form:input path="birthDate" />
		
		<input type="submit" value="submit" />
		
	</form:form>
	<a href="/clients">Retour</a>

</body>
</html>