<%@ include file="entete.jsp" %>
<div class="container">
	<div class="col-md-12 row">
		<h2>S'enregistrer</h2>
		  <form method="POST" action="Register">
		   	<table>
			   	<tr>
			   		<td><label for="nom">Nom : </label></td>
			   		<td><input type="text" class="form-control" id="nom" name="nom" width=150px></td>
			   	</tr>
			   	<tr>
			   		<td><label for="prenom">Prénom : </label></td>
			   		<td><input type="text" class="form-control" id="prenom" name="prenom" width=150px></td>
			   	</tr>
			   	<tr>
			   		<td><label for="mail">Mail : </label></td>
			   		<td><input type="text" class="form-control" id="mail" name="mail" width=150px></td>
			   	</tr>
			   	<tr>
			   		<td><label for="pseudo">Pseudo : </label></td>
			   		<td><input type="text" class="form-control" id="pseudo" name="pseudo" width=150px></td>
			   	</tr>
			   	<tr>
			   		<td><label for="password">Mot de passe : </label></td>
			   		<td><input type="password" class="form-control" id="password" name="password" width=150px></td>
			   	</tr>
			   	<tr>
			   		<td><button type="submit" class="btn btn-primary">Register</button></td>
			   	</tr>
		    </table>
		</form>
	</div>
</div>