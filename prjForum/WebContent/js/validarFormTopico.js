function validarTitulo(titulo, campo){
	if ((titulo.length != 0 && titulo.length < 2) || titulo.length > 80){
		document.getElementById(campo).setCustomValidity('Insira um titulo valido');
		document.getElementById('tituloHelp').classList.remove('text-muted');
		document.getElementById('tituloHelp').classList.add('text-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-danger');
		return false;
	}
	else if(titulo.length == 0){
		document.getElementById(campo).setCustomValidity('Insira o titulo corretamente');
		document.getElementById('tituloHelp').classList.remove('text-danger');
		document.getElementById('tituloHelp').classList.add('text-muted');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-success');
		return false;
	}
	else{
		document.getElementById(campo).setCustomValidity('');
		document.getElementById('tituloHelp').classList.remove('text-danger');
		document.getElementById('tituloHelp').classList.add('text-success');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-success');
		return true;
	}
	return true;
}

function validarConteudo(conteudo, campo){
	if ((conteudo.length != 0 && conteudo.length < 2) || conteudo.length > 1000){
		document.getElementById(campo).setCustomValidity('Insira o conteudo corretamente');
		document.getElementById('conteudoHelp').classList.remove('text-muted');
		document.getElementById('conteudoHelp').classList.add('text-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-danger');
		return false;
	}
	else if(conteudo.length == 0){
		document.getElementById(campo).setCustomValidity('Insira o conteudo corretamente');
		document.getElementById('conteudoHelp').classList.remove('text-danger');
		document.getElementById('conteudoHelp').classList.add('text-muted');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-success');
		return false;
	}
	else{
		document.getElementById(campo).setCustomValidity('');
		document.getElementById('conteudoHelp').classList.remove('text-danger');
		document.getElementById('conteudoHelp').classList.add('text-success');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-success');
		return true;
	}
	return true;
}