<%@ include file="entete.jsp" %>
<div class="container">
<div class="row">
<h2>Liste des visites</h2>
    <table class=" table table-bordered">
    	<tr>
    		<th>ID</th>
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