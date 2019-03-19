<%@ include file="entete.jsp" %>
<div class="container">
<div class="row">
	<div class="col-md-6">
	 <h2>Ajout d'une nouvelle cache</h2>
	    <form method="POST" action="cache">
	    	<table>
		    	<tr>
		    		<td><label for="nom_cache">Nom de la cache : </label></td>
		    		<td><input type="text" class="form-control" id="nom_cachette" name="nom_cachette" width=150px></td>
		    	</tr>
		    	<tr>
		    		<td><label for="description_cache">Description : </label></td>
		    		<td><input type="text" class="form-control" id="description_cachette" name="description_cachette" /></td>
		    	</tr>
		    		<td><label for="etat_cache">Etat : </label></td>
		    		<td><input type="text" class="form-control" id="etat_cachette" name="etat_cachette" value="C" /></td>
		    	<tr>
		    		<td><label for="coordonnees_cache">Coordonnées : </label></td>
		    		<td><input type="text" class="form-control" id="coordonnees_cachette" name="coordonnees_cachette"/></td>
		    	</tr>
		    	<tr>
		    		<td><label for="createur">Créateur : </label></td>
		    		<td><input type="text" class="form-control" id="createur" name="createur" value=1 /></td>
		    	</tr>
		    	<tr>
		    		<td><input type="submit" class="btn btn-primary" value="CREER" name="btn_cache" id="btn_cache"/></td>
		    	</tr>
	    	</table>
	    </form>
	</div>
	<div class="col-md-6">
	<h2>Changement d'état d'une cache</h2>
	    <form method="POST" action="cache">
	    	<table>
	    		<tr>
		    		<td><label for="idt_cachette">Cache à modifier : </label></td>
		    		<td>
				    	<select name="idt_cachette" id="idt_cachette" class="form-control">
				    	<option value=0>Choisir une cache</option>
				    	<c:forEach var="cachette" items="${ cachettes }">
							  <option value="${cachette.idt_cache}"/><c:out value="${ cachette.nom_cache }" /></option>
						</c:forEach>
						</select>
					</td>
				</tr>
	    		<tr>
		    		<td><label for="etat_cachette">Nouvel état : </label></td>
		    		<td>
				    	<select name="etat_cachette" id="etat_cachette" class="form-control">
							  <option value="C">Créée</option>
							  <option value="V">Validée</option>
							  <option value="F">Fermée</option>
							  <option value="S">Suspendue</option>
						</select>
					</td>
				</tr>
		    
		    	<tr>
		    		<td><input type="submit" class="btn btn-primary" value="MODIFIER" name="btn_cache" id="btn_cache"/></td>
		    	</tr>
	    	</table>
	    </form>
	</div>
</div>
<div class="row">
<h2>Liste des caches actives</h2>
    <table class=" table table-bordered">
    	<tr><th>Nom</th><th>Coordonnées</th></tr>
        <c:forEach var="cachette" items="${ cachettesActives }">
            <tr><td><c:out value="${ cachette.nom_cache }" /></td><td> <c:out value="${ cachette.coordonnees_cache }" /></td></tr>
        </c:forEach>
    </table>  
</div>
</div>
<%@ include file="pied.jsp" %>