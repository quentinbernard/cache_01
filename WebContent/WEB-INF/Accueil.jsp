<%@ include file="entete.jsp" %>
<div class="container">
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