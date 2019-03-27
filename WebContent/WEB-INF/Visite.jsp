<%@ include file="entete.jsp" %>
<div class="container">
	<div class="col-md-12 row">
		 <h2>Ajout d'une nouvelle visite</h2>
		  <form method="POST" action="visite">
		   	<table>
			   	<tr>
			   		<td><label for="commentaire_visite">Commentaire : </label></td>
			   		<td><input type="text" class="form-control" id="commentaire_visite" name="commentaire_visite" width=150px></td>
			   	</tr>
			   	<tr>
			   		<td><label for="id_cache">ID de la cache : </label></td>
			   		<td>
			   			<select name="id_cache" id="id_cache" class="form-control">
				    	<option value=0>Choisir une cache</option>
				    	<c:forEach var="cachette" items="${ cachettes }">
							  <option value="${cachette.idt_cache}"/><c:out value="${ cachette.nom_cache }" /></option>
						</c:forEach>
						</select>
			   		</td>
			   	</tr>
			   	<tr style="display:none">
			   		<td><label for="id_user">Créateur : </label></td>
			   		<td><input type="text" class="form-control" id="id_user" name="id_user" value="<%=user.getId() %>" /></td>
			   	</tr>
			   	<tr>
			   		<td><label for="resultat_visite">Résultat : </label></td>
			   		<td><select name="resultat_visite" id="resultat_visite" class="form-control">
							  <option value="'FIND'">Trouvée</option>
							  <option value="'NFIND'">Non trouvée</option>
						</select></td>
			   	</tr>
			   	<tr>
			   		<td><input type="submit" class="btn btn-primary" value="CREER" name="btn_cache" id="btn_cache"/></td>
			   	</tr>
		    </table>
		</form>
	</div>
	<div class="col-md-12 row">
		<h2>Liste des visites</h2>
	    <table class=" table table-bordered">
	    	<tr>
	    		<th>Cache visitee</th>
	    		<th>Date de la visite</th>
	    		<th>Commentaire</th>
	    		<th>Resultat</th>
	    	</tr>
	        <c:forEach var="visite" items="${ visites }">
	            <tr>
	            	<td><c:out value="${ visite.id_cache }" /></td>
	            	<td> <c:out value="${ visite.date_visite.toString() }" /></td>
	            	<td> <c:out value="${ visite.commentaire_visite }" /></td>
	            	<td> <c:out value="${ visite.resultat_visite }" /></td>
	            </tr>
	        </c:forEach>
	    </table>  
	</div>
</div>
<%@ include file="pied.jsp" %>