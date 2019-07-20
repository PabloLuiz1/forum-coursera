<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Login</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid mx-0 p-0">
		<header class="bg-secondary">
			<h3 class="text-white ml-4 pt-4 pb-4">Login</h3>
			<nav class="navbar navbar-expand-sm bg-gray navbar-light">
				<nav
					class="pt-0 pb-0 m-auto navbar navbar-expand-sm bg-secondary navbar-dark justify-content-center font-weight-bold">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link" href="#">Login</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="criar-conta">Criar
								conta</a></li>
						<li class="nav-item"><a class="nav-link" href="sobre">Sobre</a></li>
						</li>
					</ul>
				</nav>
			</nav>
		</header>
	</div>
	<div class="container mt-4 p-0" style="min-height: 496px;">
		<form action="login" method="POST" class="col-md-4 mx-auto">
			<c:if test="${erro != null}">
				<div class="alert alert-danger alert-dismissible fade show">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>${erro}</strong>
				</div>
			</c:if>
			<h6>Preencha suas informações para logar no fórum.</h6>
			<div class="form-group">
				<div class="input-group mb-1">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fas fa-user"></i></span>
					</div>
					<input type="text" name="login" class="form-control"
						placeholder="Login" required>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group mb-1">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fas fa-lock"></i></span>
					</div>
					<input type="password" name="senha" class="form-control"
						placeholder="Senha" required>
				</div>
			</div>
			<button class="btn btn-link">
				<a href="criar-conta">Não tem uma conta?</a>
			</button>
			<button type="submit"
				class="btn btn-primary font-weight-bold pull-right">Logar</button>
		</form>
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