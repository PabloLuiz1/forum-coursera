<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>F�rum - T�picos criados</title>
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid mx-0 p-0">
		<header class="bg-secondary">
			<div class="alert alert-light col-md-2">
				Ol� <strong>${usuario.nome}</strong> <a
					class="badge badge-danger ml-1 font-weight-bold" href="logout">deslogar</a>
			</div>
			<h3 class="text-white ml-4 pt-4 pb-4">F�rum - T�picos criados</h3>
			<nav class="navbar navbar-expand-sm bg-gray navbar-light">
				<nav
					class="pt-0 pb-0 m-auto navbar navbar-expand-sm bg-secondary navbar-dark justify-content-center font-weight-bold">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link" href="#">In�cio</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="novo-topico">Novo
								t�pico</a></li>
						<li class="nav-item"><a class="nav-link" href="ranking">Ranking</a></li>
					</ul>
				</nav>
			</nav>
		</header>
	</div>
	<div class="container mt-4 p-0" style="min-height: 496px;">
		<h3>Exibindo os t�picos criados:</h3>
		<hr>
		<a href="novo-topico"><button
				class="btn btn-primary font-weight-bold float-left mb-1">Novo
				t�pico</button></a> <a href="ranking"><button
				class="btn btn-primary font-weight-bold float-right mb-1"> <i class="fas fa-list-ol"></i> Ranking</button></a>
		<table class="table-bordered table-hover table text-center">
			<thead class="thead-dark font-weight-bold">
				<tr>
					<th>T�tulo</th>
					<th>Autor</th>
					<th>Visualizar</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${topicos eq null}">
					<tr>
						<td colspan="3">${mensagem}</td>
					</tr>
				</c:if>
				<c:forEach items="${topicos}" var="topico">
					<tr>
						<td>${topico.titulo}</td>
						<td>${topico.usuario.login}</td>
						<td><a href="ver-topico?topico=${topico.id}"><i class="fas fa-newspaper"></i> Ver</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="bg-secondary container-fluid text-white">
		<div class="row">
			<div class="col text-center">F�rum desenvolvido por Pablo Luiz
				Ribeiro para fins acad�micos.</div>
		</div>
	</footer>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>