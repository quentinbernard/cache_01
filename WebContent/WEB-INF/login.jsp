<%@ include file="entete.jsp" %>
<div class="container">
	<div class="row">
		<form method="POST" action="login">
			<div class="form-group col-md-7">
			    <label for="username">Username</label>
			    <input name="un" type="text" class="form-control" id="username" placeholder="Username">
		  	</div>
		 	<div class="form-group col-md-7">
			   <label for="password">Password</label>
			   <input name="pw" type="password" class="form-control col-md-2" id="password" placeholder="Password">
		 	</div>
		 	<%if(user == null && session.getAttribute("errLogin")!=null){ %>
		 		<div style="margin-bottom:10px"><%= session.getAttribute("errLogin") %></div>
		 		<%session.setAttribute("errLogin", null); %>
		 	<%} %>
		 	<div class="col-md-6">
		  		<button type="submit" class="btn btn-primary">Login</button>
	  		</div>
		</form>
	</div>
</div>
<%@ include file="pied.jsp" %>