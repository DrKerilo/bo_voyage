<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Réservation client</title>

<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />

</head>


<body>
	<h1 style="color: teal; text-align: center">Nouvelle
		reservation</h1>
	<hr />
	<br />


	<form:form cssClass="form-horizontal w3-container w3-teal" action="soumettreNewResa"
		method="post" modelAttribute="newResa">
			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="nbPlaces">Nb places</form:label>
				<div class="col-sm-2">
					<form:select class="form-control" path="nbPlaces">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					</form:select>
				</div>
			</div>

			<hr />
			<div class="container light-grey">
				<h3 style="color: lightcoral; text-align: center">Informations
				sur le client</h3>
			</div>
			<hr />

				<div class="form-group">
					<label class="col-sm-2 control-label">Civilité</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pCiviliteClient" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Nom</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pNomClient" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Prenom</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pPrenomClient" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Date de naissance</label>
					<div class="col-sm-8">
						<input type="date" class="form-control" name="pDnClient" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Mail</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pMailClient" />
					</div>
				</div>
				

			<h4 style="text-align: center" class="control-label">Adresse :</h4><br/>

				<div class="form-group">
					<label class="col-sm-2 control-label">Numero</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" name="pNumeroAdresse" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Rue</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pRueAdresse" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Code postal</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pCpAdresse" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Ville</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pVilleAdresse" />
					</div>
				</div>

			<hr />
			<h3 style="color: lightcoral; text-align: center">Informations
				sur les accompagnants</h3>
			<hr />
			
			<div class="form-group">
					<label class="col-sm-2 control-label">Civilité</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pCiviliteClient" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Nom</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pNomClient" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Prenom</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pPrenomClient" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Date de naissance</label>
					<div class="col-sm-8">
						<input type="date" class="form-control" name="pDnClient" />
					</div>
				</div>
			

			<h4 style="text-align: center" class="control-label">Adresse :</h4><br/>

				<div class="form-group">
					<label class="col-sm-2 control-label">Numero</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" name="pNumeroAdresse" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Rue</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pRueAdresse" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Code postal</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pCpAdresse" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Ville</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="pVilleAdresse" />
					</div>
				</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Assurance : </label>
				<div class="col-sm-10">
					Souscrire : <input type="radio" name="pChoix" value="1" /> 
					Ne pas souscrire : <input type="radio" name="pChoix" value="0" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="compte.id">Numero de compte du client </form:label>
				<div class="col-sm-2">
					<form:input type="number" cssClass="form-control" path="compte.id" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<form:button type="submit" cssClass="btn btn-default">Reserver</form:button>
				</div>
			</div>
	</form:form>



</body>
</html>