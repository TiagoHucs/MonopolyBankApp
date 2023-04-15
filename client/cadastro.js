const API = 'http://localhost:8080/rest/users/create';


function cadastrar() {
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
			// redireciona para a página home
			window.location.href = 'login.html';
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert('Erro ao cadastrar: ' + textStatus);
		}
	});
}

function login() {
	// redireciona para a página cadastro
	window.location.href = 'login.html';
}


