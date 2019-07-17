function validarNome(nome, campo){
	if ((nome.length != 0 && nome.length < 4) || nome.length > 200){
		document.getElementById(campo).setCustomValidity('Insira seu nome e sobrenome completos');
		document.getElementById('nomeHelp').classList.remove('text-muted');
		document.getElementById('nomeHelp').classList.add('text-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-danger');
		return false;
	}
	else if(nome.length == 0){
		document.getElementById(campo).setCustomValidity('Insira seu nome e sobrenome completos');
		document.getElementById('nomeHelp').classList.remove('text-danger');
		document.getElementById('nomeHelp').classList.add('text-muted');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-success');
		return false;
	}
	else{
		document.getElementById(campo).setCustomValidity('');
		document.getElementById('nomeHelp').classList.remove('text-danger');
		document.getElementById('nomeHelp').classList.add('text-success');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-success');
		return true;
	}
	return false;
}

function validarLogin(login, campo){
	if ((login.length != 0 && login.length < 4) || login.length > 15){
		document.getElementById(campo).setCustomValidity('O login precisa ter entre 4 e 15 caracteres');
		document.getElementById('loginHelp').classList.remove('text-muted');
		document.getElementById('loginHelp').classList.add('text-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-danger');
		return false;
	}
	else if(login.length == 0){
		document.getElementById(campo).setCustomValidity('Escolha um login');
		document.getElementById('loginHelp').classList.remove('text-danger');
		document.getElementById('loginHelp').classList.add('text-muted');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-success');
		return false;
	}
	else{
		document.getElementById(campo).setCustomValidity('');
		document.getElementById('loginHelp').classList.remove('text-danger');
		document.getElementById('loginHelp').classList.add('text-success');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-success');
		return true;
	}
	return false;
}

function validarEmail(email, campo){
// usuario = email.indexOf("@");
// dominio = email.indexOf("@")+ 1, email.length);
//
// if ((usuario.length >=1) &&
// (dominio.length >=3) &&
// (usuario.search("@")==-1) &&
// (dominio.search("@")==-1) &&
// (usuario.search(" ")==-1) &&
// (dominio.search(" ")==-1) &&
// (dominio.search(".")!=-1) &&
// (dominio.indexOf(".") >=1)&&
// (dominio.lastIndexOf(".") < dominio.length - 1)) {
// document.getElementById('emailHelp').classList.remove('text-danger');
// document.getElementById('emailHelp').classList.add('text-success');
// document.getElementById(campo).classList.remove('border');
// document.getElementById(campo).classList.remove('border-danger');
// document.getElementById(campo).classList.add('border');
// document.getElementById(campo).classList.add('border-success');
// return true;
// }
// else if (email.length == 0){
// document.getElementById('emailHelp').classList.remove('text-danger');
// document.getElementById('emailHelp').classList.add('text-muted');
// document.getElementById(campo).classList.remove('border');
// document.getElementById(campo).classList.remove('border-danger');
// document.getElementById(campo).classList.remove('border');
// document.getElementById(campo).classList.remove('border-success');
// return false;
// }
// else{
// document.getElementById('emailHelp').classList.remove('text-success');
// document.getElementById('emailHelp').classList.add('text-danger');
// document.getElementById(campo).classList.remove('border');
// document.getElementById(campo).classList.remove('border-success');
// document.getElementById(campo).classList.add('border');
// document.getElementById(campo).classList.add('border-danger');
// return false;
// }
}

function validarSenha(senha, campo){
	if ((senha.length != 0 && senha.length < 5) || senha.length > 20){
		document.getElementById(campo).setCustomValidity('A senha precisa ter entre 5 e 20 caracteres');
		document.getElementById('senhaHelp').classList.remove('text-muted');
		document.getElementById('senhaHelp').classList.add('text-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-danger');
		document.getElementById('confirmarSenha').disabled = true;
		return false;
	}
	else if(senha.length == 0){
		document.getElementById(campo).setCustomValidity('Escolha uma senha');
		document.getElementById('senhaHelp').classList.remove('text-danger');
		document.getElementById('senhaHelp').classList.add('text-muted');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-success');
		document.getElementById('confirmarSenha').disabled = true;
		return false;
	}
	else{
		document.getElementById(campo).setCustomValidity('');
		document.getElementById('senhaHelp').classList.remove('text-danger');
		document.getElementById('senhaHelp').classList.add('text-success');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-success');
		document.getElementById('confirmarSenha').disabled = false;
		return true;
	}
	return true;
}

function validarConfirmacaoSenha(senha, confirmarSenha, campo){
//	if (senha == confirmarSenha)
//		alert ('foi');
		if (senha == confirmarSenha){
			document.getElementById('confirmarSenhaHelp').classList.remove('text-muted');
			document.getElementById('confirmarSenhaHelp').classList.remove('text-danger');
			document.getElementById('confirmarSenhaHelp').classList.add('text-success');
			document.getElementById(campo).classList.remove('border');
			document.getElementById(campo).classList.remove('border-danger');
			document.getElementById(campo).classList.add('border');
			document.getElementById(campo).classList.add('border-success');
			document.getElementById(campo).setCustomValidity('');
			return true;
		}
		else {
			document.getElementById('confirmarSenhaHelp').classList.remove('text-muted');
			document.getElementById('confirmarSenhaHelp').classList.add('text-danger');
			document.getElementById(campo).classList.remove('border');
			document.getElementById(campo).classList.remove('border-success');
			document.getElementById(campo).classList.add('border');
			document.getElementById(campo).classList.add('border-danger');
			document.getElementById(campo).setCustomValidity('Senhas diferentes');
			return false;
		}
	return true;
}