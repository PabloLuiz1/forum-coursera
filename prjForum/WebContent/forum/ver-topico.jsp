<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Fórum - Ver tópico</title>
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
				Olá <strong>${usuario.nome}</strong> <a
					class="badge badge-danger ml-1 font-weight-bold" href="logout">deslogar</a>
			</div>
			<h3 class="text-white ml-4 pt-4 pb-4">Fórum - Ver tópico</h3>
			<nav class="navbar navbar-expand-sm bg-gray navbar-light">
				<nav
					class="pt-0 pb-0 m-auto navbar navbar-expand-sm bg-secondary navbar-dark justify-content-center font-weight-bold">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="../forum">Início</a></li>
						<li class="nav-item"><a class="nav-link" href="novo-topico">Novo
								tópico</a></li>
						<li class="nav-item"><a class="nav-link" href="ranking">Ranking</a></li>
						</li>
					</ul>
				</nav>
			</nav>
		</header>
	</div>
	<div class="container mt-4 p-0" style="min-height: 496px;">
		<c:if test="${erro != null}">
			<div class="alert alert-danger alert-dismissible">
				<strong>${erro}</strong>
			</div>
			<br>
		</c:if>
		<a href="../forum" class="btn btn-primary font-weight-bold mb-2">Voltar</a>
		<c:if test="${erro == null}">
			<div class="media border p-3">
				<div class="media-body">
					<h4>${topico.titulo}</h4>
					<small><i>postado por </i><strong>${topico.usuario.login}</strong></small>
					<hr>
					<p>${topico.conteudo}</p>
					<hr>
					<h4>Comentários:</h4>
					<c:if test="${comentarios == null}">
					${mensagem}
					<br>
					</c:if>
					<c:forEach items="${comentarios}" var="comentario">
						<div class="border col-md-12">
							#${comentarios.indexOf(comentario) + 1} -
							${comentario.comentario} <br> <small><i>postado
									por </i><strong>${comentario.usuario.login}</strong></small>
						</div>
					</c:forEach>
					<br>
					<hr>
					<h4>Faça um comentário:</h4>
					<form action="ver-topico?topico=${topico.id}" method="POST"
						class="form-horizontal p-0">
						<textarea id="comentario" name="comentario" class="form-control" rows="2" maxlength="1000" onkeyup="validarComentario(this.value, this.id)"></textarea>
						<small
					id="comentarioHelp" class="form-text text-muted"> O comentário deve conter no máximo 1000 caracteres. </small>
						<button type="submit"
							class="btn btn-primary pull-right mt-2 font-weight-bold">Postar</button>
					</form>
				</div>
			</div>
		</c:if>
	</div>
	<footer class="bg-secondary container-fluid text-white">
		<div class="row">
			<div class="col text-center">Fórum desenvolvido por Pablo Luiz
				Ribeiro para fins acadêmicos.</div>
		</div>
	</footer>
</body>
<script src="../js/validarFormComentario.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</html>