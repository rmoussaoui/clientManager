
<html>
<head>
<title>Client record</title>
</head>
<body>
	<h1>Client record</h1>
	<label for="name">Name:</label>
	<input type="text" id="name" name="name" value="${client.name}"/>
	
	<br/>

	<label for="birthdate">Birthdate:</label>
	<input type="text" id="birthdate" name="birthdate" value="${client.birthDate}"/>
	
	<br/>
	<a href="/clients">Retour</a>

</body>
</html>