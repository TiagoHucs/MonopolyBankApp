const API = 'http://localhost:8080/rest/account/home';


function getHome(){
// faz a chamada para a API da home
$.ajax({
    url: API,
    type: 'GET',
    headers: {
        Authorization: 'Bearer ' + getToken()
    },
    success: function (data) {
        // exibe os dados retornados pela API
        montaHome(data);
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

getHome();

function montaHome(data){
    document.getElementById('clientBalance').innerText = data.balance;
    document.getElementById('clientName').innerText = data.clientName;
     /* document.getElementById('menu').innerHTML = 
`<div style="cursor: pointer">
    Home | Extrato | Transferencias
</div>`; 
   //menu.criaMenu() */
}


function getToken() {
    // obtém o token do localStorage com o nome 'token'
    return localStorage.getItem('token');
}

function sair() {
    localStorage.removeItem('token');
    window.location.href = 'login.html';
}

function transferir() {
    window.location.href = 'transferencia.html';
}