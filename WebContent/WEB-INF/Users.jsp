<%@ include file="entete.jsp" %>
<div class="container">
	<%if(user != null && user.getType().equals("A")){%>
	<div class="row">
		<div class="col-md-6">
		<h2>Changement d'état d'une cache</h2>
		    <form method="POST" action="gestionusers">
		    	<table>
		    		<tr>
			    		<td><label for="idt_user">User à modifier : </label></td>
			    		<td>
					    	<select name="idt_user" id="idt_user" class="form-control">
					    	<c:forEach var="userE" items="${ users }">
								  <option value="${userE.id}"/><c:out value="${ userE.pseudo }" /></option>
							</c:forEach>
							</select>
						</td>
					</tr>
		    		<tr>
			    		<td><label for="etat_user">Nouvel état : </label></td>
			    		<td>
					    	<select name="etat_user" id="etat_user" class="form-control">
								  <option selected value="E">En attente</option>
								  <option value="V">Validée</option>
							</select>
						</td>
					</tr>
			    	<tr>
			    		<td><label for="type_user">Nouveau type : </label></td>
			    		<td>
					    	<select name="type_user" id="type_user" class="form-control">
								  <option selected value="J">Joueur</option>
								  <option value="A">Admin</option>
							</select>
						</td>
					</tr>
			    	<tr>
			    		<td><input type="submit" class="btn btn-primary" value="MODIFIER" name="btn_user" id="btn_user"/></td>
			    	</tr>
		    	</table>
		    </form>
		</div>
	</div>
	<div class="row">
		<h2>Liste des users</h2>
	    <table class=" table table-bordered">
	    	<tr><th>Pseudo</th><th>A valider</th><th>Type</th></tr>
	        <c:forEach var="userE" items="${ users }">
	            <tr>
	            	<td> <c:out value="${ userE.pseudo }" /></td>
	            	<td> <c:out value="${ userE.valid }" /></td>
	            	<td> <c:out value="${ userE.type }" /></td>
	            </tr>
	        </c:forEach>
	    </table>
    </div>
	<%} %>
</div>
<%@ include file="pied.jsp" %>