<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>Clients list</h1>
<table>
	<tr>
		<th>Name</th>
		<th>Birthdate</th>
		<th></th>
	</tr>
	<c:forEach items="${allClients}" var="client">
		<tr>
			<td>${client.name}</td>
			<td>${client.birthDate}</td>
			<th><a href="/clients/${client.clientId}">View</a></th>
		</tr>
	</c:forEach>
</table>
</body>
</html>