<%@ include file="entete.jsp" %>
<div class="container">
	<div class="row">
		<form method="POST" action="login">
			<div class="form-group">
			    <label for="username">Username</label>
			    <input name="un" type="text" class="form-control" id="username" placeholder="Username">
		  	</div>
		 	<div class="form-group">
			   <label for="password">Password</label>
			   <input name="pw" type="password" class="form-control" id="password" placeholder="Password">
		 	</div>
		  	<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</div>
<%@ include file="pied.jsp" %>