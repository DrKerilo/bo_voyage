<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="j_spring_security_check" method="post">
		Identifiant : <input type="text" name="j_username"/>
		<br/>
		Mot de passe : <input type="password" name="j_password"/> 
		<br/>
		<input type="submit" value="Connexion"/>
	</form>

<c:if test="${not empty erreur}">
<h2 style="color:red; text-align:center">Identifiant ou mot incorrect</h2>
</c:if>
</body>
</html>