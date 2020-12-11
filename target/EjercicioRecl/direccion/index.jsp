<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Menú Dirección</title>
	<link rel="stylesheet" href="bulma/css/bulma.min.css">
 	<link rel="stylesheet" href="bulma/css/all.min.css">
</head>
<body>
	
<div class="container">
<h1 class="title has-text-centered">Direcciones</h1>
	<div class="columns">
  		<div class="column is-one-fifth">
			<a href="DireccionController?action=index" class="button">Ir al menú</a>
		</div>
	</div>
	
	<table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth is-responsive">
		<thead>
			<tr>
				<th>ID</th>
				<th>Calle</th>
				<th>No. Exterior</th>
				<th>Codigo Postal</th>
				<th>Estado</th>
				<th>Referencia</th>
				<th colspan="2">Acciones</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="direccion" items="${lista}">
			<tr>
				<td><c:out value="${direccion.id_direccion}"/></td>
				<td><c:out value="${direccion.calle}"/></td>
				<td><c:out value="${direccion.no_exterior}"/></td>
				<td><c:out value="${direccion.codigo_postal}"/></td>
				<td><c:out value="${direccion.estado}"/></td>
				<td><c:out value="${direccion.referencia}"/></td>
				<td><a href="DireccionController?action=showedit&id=<c:out value="${direccion.id_direccion}" />">Editar</a></td>
				<td><a href="DireccionController?action=eliminar&id=<c:out value="${direccion.id_direccion}"/>">Eliminar</a> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>

</html>