<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page supprimer vol</title>
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

	<%@include file="/resources/template/header.html"%>

	<h1 style="color: red; text-align: center">Supprimer une offre</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreSupprO" modelAttribute="oSuppr">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">id</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<button type="submit" class="btn btn-default">Supprimer</button>
			</div>
		</div>


	</form:form>
</body>
</html>