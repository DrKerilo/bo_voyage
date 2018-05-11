<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votre Choix</title>
</head>
<body>

	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-md-4">
				ID : ${offre.id} Ref : ${offre.reference} <br /> Vous voyagez à
				${offre.destination.ville}, ${offre.destination.pays} <br /> A
				partir de
				<fmt:formatDate value="${offre.dateDep}" pattern="dd-MM-yy" />
				jusqua
				<fmt:formatDate value="${offre.dateRet}" pattern="dd-MM-yy" />
				<br /> Prix total ${offre.prixBoV}, au lieu de
				${offre.prixPublic}!!! <br /> Inclus : ${offre.formule} <br />
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-md-4">Button RESERVE</div>
		</div>
	</div>


</body>
</html>