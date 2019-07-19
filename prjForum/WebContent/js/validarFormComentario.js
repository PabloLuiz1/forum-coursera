function validarComentario(comentario, campo){
	if (comentario.length > 1000){
		document.getElementById(campo).setCustomValidity('Atingiu o limite de caracteres (1000)');
		document.getElementById('comentarioHelp').classList.remove('text-muted');
		document.getElementById('comentarioHelp').classList.add('text-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-danger');
		return false;
	}
	else if (comentario.length == 0){
		document.getElementById(campo).setCustomValidity('');
		document.getElementById('comentarioHelp').classList.remove('text-danger');
		document.getElementById('comentarioHelp').classList.remove('text-success');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-success');
		return true;
	}
	else{
		document.getElementById(campo).setCustomValidity('');
		document.getElementById('comentarioHelp').classList.remove('text-muted');
		document.getElementById('comentarioHelp').classList.remove('text-danger');
		document.getElementById('comentarioHelp').classList.add('text-success');
		document.getElementById(campo).classList.remove('border');
		document.getElementById(campo).classList.remove('border-danger');
		document.getElementById(campo).classList.add('border');
		document.getElementById(campo).classList.add('border-success');
		return true;
	}
	return true;
}