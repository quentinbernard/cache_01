<%@ include file="entete.jsp" %>
<div class="container">
	<%if(user != null && user.getType().equals("A")){%>
	<div class="row">
		<div class="col-md-6">
		<h2>Changement d'état d'une cache</h2>
		    <form method="POST" action="cache">
		    	<table>
		    		<tr>
			    		<td><label for="idt_cachette">User à modifier : </label></td>
			    		<td>
					    	<select name="idt_cachette" id="idt_cachette" class="form-control">
					    	<option value=0>Choisir un user</option>
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
		<h2>Liste des users</h2>
	    <table class=" table table-bordered">
	    	<tr><th>Nom</th><th>Coordonnées</th><th>Description</th><th>Etat</th></tr>
	        <c:forEach var="cachetteUser" items="${ cachettesUser }">
	            <tr>
	            	<td> <c:out value="${ cachetteUser.nom_cache }" /></td>
	            	<td> <c:out value="${ cachetteUser.coordonnees_cache }" /></td>
	            	<td> <c:out value="${ cachetteUser.description_cache }" /></td>
	            	<td> <c:out value="${ cachetteUser.etat_cache }" /></td>
	            </tr>
	        </c:forEach>
	    </table>
    </div>
	<%} %>
</div>
<%@ include file="pied.jsp" %>