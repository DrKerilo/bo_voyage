<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- pour utiliser bootstrapjs-->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>

<!-- pour utiliser bootstrapjs-->
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>

<!-- pour utiliser bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
</head>
<body>
	<hr />
	<h1 style="color: blue; text-align: center">SUPPRESSION D'UN HOTEL</h1>
	<!-- Dans action on doit mettre l'URI de la méthode (model Attribute peut être remplacé par commandName-->
	<form:form class="form-horizontal" method="POST" action="soumSuppHotel"
		modelAttribute="hotSup">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="id">Id</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" id="id" placeholder="Id"
					path="id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Supprimer</button>
			</div>
		</div>
	</form:form>

</body>
</html>