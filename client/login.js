const API = 'http://localhost:8080/rest/login';


function login() {
	// obtém os valores dos campos de login
	var username = $('#username').val();
	var password = $('#password').val();

	// faz a chamada para a API de login com os dados informados
	$.ajax({
		url: API,
		type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
			username: username,
			password: password
          }),
		success: function(data) {
			// salva o token no localStorage
			saveToken(data);
            console.log(data);
			// redireciona para a página home
			window.location.href = 'home.html';
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert('Erro ao fazer login: ' + textStatus);
		}
	});
}

function saveToken(token) {
	// salva o token no localStorage com o nome 'token'
	localStorage.setItem('token', token);
}

function cadastrar() {
	// redireciona para a página cadastro
	window.location.href = 'cadastro.html';
}

