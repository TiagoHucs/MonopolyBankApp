const API = 'http://localhost:8080/rest/account/balance';


function getSaldo(){
// faz a chamada para a API da home
$.ajax({
    url: API,
    type: 'GET',
    headers: {
        Authorization: 'Bearer ' + getToken()
    },
    success: function (data) {
        // exibe os dados retornados pela API
        alert(data.message);
    },
    error: function (jqXHR, textStatus, errorThrown) {
        if (jqXHR.status === 403) {
            // se o status for 403 (Forbidden), redireciona para a página de login
            window.location.href = 'login.html';
        } else {
            alert('Erro ao acessar a página home: ' + textStatus);
        }
    }
});
}


function getToken() {
    // obtém o token do localStorage com o nome 'token'
    return localStorage.getItem('token');
}

function sair() {
    localStorage.removeItem('token');
    window.location.href = 'login.html';
}