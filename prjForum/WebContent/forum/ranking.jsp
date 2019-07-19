<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Fórum - Ranking</title>
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
				Olá <strong>${usuario.nome}</strong> <a class="badge badge-danger ml-1 font-weight-bold" href="logout">deslogar</a>
			</div>
			<h3 class="text-white ml-4 pt-4 pb-4">Fórum - Ranking de usuários</h3>
			<nav class="navbar navbar-expand-sm bg-gray navbar-light">
				<nav
					class="pt-0 pb-0 m-auto navbar navbar-expand-sm bg-secondary navbar-dark justify-content-center font-weight-bold">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="../forum">Início</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="novo-topico">Novo tópico</a></li>
						<li class="nav-item active"><a class="nav-link" href="#">Ranking</a></li>
						</li>
					</ul>
				</nav>
			</nav>
		</header>
	</div>
	<div class="container mt-4 p-0" style="min-height: 496px;">
		<h3>Ranking de usuários do fórum: </h3>
		<hr>
		<table class="table-bordered table-hover table text-center">
			<thead class="thead-dark font-weight-bold">
				<tr>
					<th>Colocação</th>
					<th>Nome</th>
					<th>Login</th>
					<th>Total de pontos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ranking}" var="usuario">
					<tr>
						<td>#${ranking.indexOf(usuario)+1}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.login}</td>
						<td>${usuario.pontos}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="bg-secondary container-fluid text-white">
		<div class="row">
			<div class="col text-center">Fórum desenvolvido por Pablo Luiz
				Ribeiro para fins acadêmicos.</div>
		</div>
	</footer>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>