const API = 'http://localhost:8080/rest/';


function getUsers(){
$.ajax({
    url: API + 'users/list',
    type: 'GET',
    headers: {
        Authorization: 'Bearer ' + getToken()
    },
    success: function (data) {
        montaOpcoes(data);
    },
    error: function (jqXHR, textStatus, errorThrown) {
        if (jqXHR.status === 403) {
            window.location.href = 'login.html';
        } else {
            alert('Erro ao acessar a página home: ' + textStatus);
        }
    }
});
}

function transfer() {
	// obtém os valores dos campos de login
	var accountId = $('#accountId').val();
	var value = $('#value').val();

	// faz a chamada para a API de login com os dados informados
	$.ajax({
		url: API,
		type: 'POST',
        contentType: 'application/json',
        headers: {
			Authorization: 'Bearer ' + getToken()
		},
		data: JSON.stringify({
			accountId: accountId,
			value: value
          }),
		success: function(data) {
			alert('Transferido');
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert('Erro ao fazer login: ' + textStatus);
		}
	});
}

function montaOpcoes(data){
	console.log(data);
	let options = ''
	data.forEach(element => {
		options += `<option value="${element.accountId}">${element.username}</option>`;
	});
    document.getElementById('userList').innerHTML = options;
}


function getToken() {
    // obtém o token do localStorage com o nome 'token'
    return localStorage.getItem('token');
}

function sair() {
    localStorage.removeItem('token');
    window.location.href = 'login.html';
}

function voltar() {
    window.location.href = 'home.html';
}

getUsers();