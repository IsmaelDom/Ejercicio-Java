<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
 <link rel="stylesheet" href="bulma/css/bulma.min.css">
 <link rel="stylesheet" href="bulma/css/all.min.css">
</head>
<body>
<%
String msg = (String)session.getAttribute("msg");
//session.setAttribute("msg", null);
if(msg == null || msg.isEmpty()){
	out.print("");
}else{%>
<section class="hero">
<div class="container is-centered columns">
  	<div class="column is-three-fifths is-offset-one-fifth">
  			<div class="notification is-danger has-text-centered">
  				<strong><% out.append(msg); %></strong>
			</div>
	</div>
</div>
</section>
<% } %>

<form method="POST" action="DireccionController" class="box">
	<section class="hero is-fullheight is-fullwidth">
  		<div class="hero-body">
    		<div class="container">
    		<h1 class="title has-text-centered">Iniciar Sesión</h1>
      			<div class="columns is-centered">
        			<div class="column is-5-tablet is-4-desktop is-3-widescreen">
            			<div class="field">
              				<label for="" class="label">Usuario</label>
              					<div class="control is-loading">
              						<p class="control has-icons-left has-icons-right">
        	        					<input type="text" placeholder="Ingrese Usuario" name="txtUsuario" class="input" required>
    	            					<span class="icon is-small is-left">
	    									<i class="fas fa-user"></i>
    									</span>
    								</p>
              					</div>
            			</div>
            			
            			<div class="field">
              				<label for="" class="label">Password</label>
              					<div class="control">
              						<p class="control has-icons-left has-icons-right">
        	        					<input type="password" placeholder="Ingrese Contraseña" name="txtPass" class="input" required>
    	            					<span class="icon is-small is-left">
	    									<i class="fas fa-lock"></i>
    									</span>
    									 <span class="icon is-small is-right">
      										<i class="fas fa-check"></i>
    									</span>
    								</p>
              					</div>
            			</div>
            			
            			<div class="field">
							<button type="submit" class="button is-success is-outlined">
								<span class="icon is-small">
      								<i class="fas fa-check"></i>
    							</span>
    							<span>Ingresar</span>
							</button>
							
							<button type="reset" class="button is-danger is-outlined">
              					<span class="icon is-small">
      								<i class="fas fa-times"></i>
    							</span>
    							<span>Cancelar</span>
              				</button>
            			</div>
        			</div>
      			</div>
    		</div>
  		</div>
	</section>
</form>
</body>
</html>