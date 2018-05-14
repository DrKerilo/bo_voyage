<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votre Choix</title>
<!-- pour utiliser jquery js-->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>

<!-- pour utiliser bootstrap js-->
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>

<!-- pour utiliser bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />

<style>
.borderexample {
	margin: 20px;
	padding: 10px;
	border-style: solid;
	border-color: #287EC7;
	padding: 10px;
}
</style>
</head>
<body>

	<h2 style="text-align: center">
		${offre.destination.ville} est magnifique pour la période du
		<fmt:formatDate value="${offre.dateDep}" pattern="dd-MM-yy" />
		jusqu'au
		<fmt:formatDate value="${offre.dateRet}" pattern="dd-MM-yy" />
	</h2>

	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-md-4">
			<br /> 
				Prix total ${offre.prixBoV}, au lieu de ${offre.prixPublic}!!! <br />
				Juste ${offre.nbPlacesDispo} places restent <br /> Inclus :
				${offre.formule}
			</div>

			<div class="col-md-4">
				<br /> Vols disponible:
				<div align="center">

					<table class="table table-bordered" style="text-align: center">
						<tr style="text-align: center">
							<th>ID</th>

							<th>Ville Dep</th>
							<th>Ville Arr</th>
							
							<th>Date Dep</th>
							<th>Heure Dep</th>
							
							<th>Date Ret</th>
							<th>Heure Arr</th>

							<th>Modele</th>
							
							<th></th>
						</tr>
						<c:forEach var="vol" items="${offre.listeVol}">
							<tr>
								<td>${vol.id}</td>
								<td>${vol.aeroportDep}</td>
								<td>${vol.aeroportArr}</td>
								
								<td><fmt:formatDate value="${vol.horaire.dateDep}"
										pattern="dd-MM" /></td>
								<td>${vol.horaire.heureDep}</td>
								<td><fmt:formatDate value="${vol.horaire.dateRet}"
										pattern="dd-MM" /></td>
								<td>${vol.horaire.heureRet}</td>
								
								<td>${vol.modele}</td>
								
								<td><a>RESERVE</a></td>
							</tr>
						</c:forEach>
					</table>
				
					
					<table class="table table-bordered" style="text-align: center">
			<tr style="text-align: center">
								<th>photo<th>
						</tr>
							<tr>
					
					<td><c:forEach var="im" items="${offre.images}">
						<img src="${im}" width="100" height="100">
					</c:forEach></td>
					
				</tr>
		
		</table>
					
					
					
				</div>
			</div>
			
		</div>
	</div>

</body>
</html>