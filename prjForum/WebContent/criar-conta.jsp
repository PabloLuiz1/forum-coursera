<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Criar conta</title>
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
			<h3 class="text-white ml-4 pt-4 pb-4">Criar uma conta</h3>
			<nav class="navbar navbar-expand-sm bg-gray navbar-light">
				<nav
					class="pt-0 pb-0 m-auto navbar navbar-expand-sm bg-secondary navbar-dark justify-content-center font-weight-bold">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/prjForum/">Login</a>
						</li>
						<li class="nav-item active"><a class="nav-link" href="#">Criar
								conta</a></li>
						<li class="nav-item"><a class="nav-link" href="sobre">Sobre</a></li>
						</li>
					</ul>
				</nav>
			</nav>
		</header>
	</div>
	<div class="container mt-4 p-0">
		<c:if test="${sucesso != null }">
			<div class="alert alert-success">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>${sucesso}</strong>
			</div>
		</c:if>

		<c:if test="${erro != null}">
			<div class="alert alert-danger alert-dismissible fade show">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>${erro}</strong>
			</div>
		</c:if>
		<form action="criar-conta" method="POST" class="col-md-8 mx-auto">
			<h6>Preencha suas informações para criar uma conta no fórum.</h6>
			<hr>
			<div class="form-group">
				<input type="text" id="nome" name="nome" class="form-control"
					placeholder="Nome" maxlength="200"
					onblur="validarNome(this.value, this.id)" required> <small
					id="nomeHelp" class="form-text text-muted"> Insira o seu
					nome e sobrenome completos. </small>
			</div>
			<div class="form-group">
				<div class="form-row">
					<div class="col">
						<input type="text" id="login" name="login" class="form-control"
							placeholder="Login" maxlength="15"
							onblur="validarLogin(this.value, this.id)" required pattern="^[a-zA-Z0-9]+$"> <small
							id="loginHelp" class="form-text text-muted"> Precisa ter
							entre 4 e 15 caracteres. Apenas letras e números.</small>
					</div>
					<div class="col">
						<input type="email" id="email" name="email" class="form-control"
							placeholder="E-mail" maxlength="50"
							onblur="validarEmail(this.value, this.id)" required> <small
							id="emailHelp" class="form-text text-muted"> Insira um
							e-mail válido e que você tenha acesso. </small>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-row">
					<div class="col">
						<input type="password" id="senha" name="senha"
							class="form-control" maxlength="20" placeholder="Senha"
							onblur="validarSenha(this.value, this.id)" required> <small
							id="senhaHelp" class="form-text text-muted"> Precisa ter
							entre 5 e 20 caracteres. </small>
					</div>
					<div class="col">
						<input type="password" id="confirmarSenha" name="confirmarSenha"
							class="form-control" placeholder="Confirmar a senha"
							maxlength="20"
							onblur="validarConfirmacaoSenha(senha.value, this.value, this.id)"
							required disabled> <small id="confirmarSenhaHelp"
							class="form-text text-muted"> Confirme a senha. </small>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="bg-light mb-3">
					Todos os campos são <span class="font-weight-bold">obrigatórios.</span>
				</div>
				<a href="criar-conta"
					class="btn btn-danger font-weight-bold pull-left">Cancelar</a>
				<button type="submit"
					class="btn btn-primary font-weight-bold pull-right">Cadastrar</button>
			</div>
		</form>
	</div>
	<footer class="bg-secondary container-fluid text-white float-left mt-5">
		<div class="row">
			<div class="col text-center">Fórum desenvolvido por Pablo Luiz
				Ribeiro para fins acadêmicos.</div>
		</div>
	</footer>
</body>
<script src="js/validarFormUsuario.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>