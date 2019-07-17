<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				Olá <strong>${usuario.nome}</strong> <a class="badge badge-danger ml-1 font-weight-bold" href="logout">deslogar</a>
			</div>
			<h3 class="text-white ml-4 pt-4 pb-4">Fórum - Ver tópico</h3>
			<nav class="navbar navbar-expand-sm bg-gray navbar-light">
				<nav
					class="pt-0 pb-0 m-auto navbar navbar-expand-sm bg-secondary navbar-dark justify-content-center font-weight-bold">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="../forum">Início</a></li>
						<li class="nav-item"><a class="nav-link"
							href="novo-topico">Novo tópico</a></li>
						<li class="nav-item"><a class="nav-link" href="ranking">Ranking</a></li>
						</li>
					</ul>
				</nav>
			</nav>
		</header>
	</div>
	<div class="container mt-4 p-0" style="min-height: 496px;">
		<div class="media border p-3">
			<div class="media-body">
				<h4>
					$Título
				</h4>
				<small><i>postado por </i><strong>$fulano</strong></small>
				<hr>
				<p>$conteudo</p>
				<hr>
				<h4>Comentários: </h4>
				<p>#1 - $comentario <br><small><i>postado por </i><strong>$fulano</strong></small></p>
				<hr>
				<h4>Faça um comentário: </h4>
				<form action="/comentar" method="POST" class="form-horizontal col-md-6 p-0">
					<textarea name="comentario" class="form-control" rows="2" required></textarea>
					<button type="submit" class="btn btn-primary pull-right mt-2">Postar</button>
				</form>
			</div>
		</div>
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