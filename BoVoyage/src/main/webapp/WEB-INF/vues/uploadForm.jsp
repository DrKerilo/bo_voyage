<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/monJs.js'/>"></script>

</head>
<body>
<h3>Télécharger vos images</h3>
<h3>${filesuccess}</h3>
<form:form method="post" action="savefile" enctype="multipart/form-data">
<p>
<label for="image">Choisir une image</label>
</p>
<p>
<input name="upFiles" id="fileToUpload" type="file" multiple/>
</p>
<p>
<input type="submit" value="Upload">
</p>

</form:form>






</body>
</html>