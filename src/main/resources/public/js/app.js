const API = 'http://localhost:8080/rest';

//login
function login() {
    // obtém os valores dos campos de login
    var username = $('#username').val();
    var password = $('#password').val();

    // faz a chamada para a API de login com os dados informados
    $.ajax({
        url: API + '/login/',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            username: username,
            password: password
        }),
        success: function (data) {
            // salva o token no localStorage
            saveToken(data);
            // redireciona para a página home
            window.location.href = 'home.html';
        },
        error: function (jqXHR, textStatus, errorThrown) {
            message(1, 'Erro ao fazer login: ');
        }
    });
}

function saveToken(token) {
    // salva o token no localStorage com o nome 'token'
    localStorage.setItem('token', token);
}

//cadastrar
function cadastrar() {
    // obtém os valores dos campos de login
    var username = $('#username').val();
    var password = $('#password').val();

    // faz a chamada para a API de login com os dados informados
    $.ajax({
        url: API + '/users/create',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            username: username,
            password: password
        }),
        success: function (data) {
            message(0, 'Usuario cadastrado com sucesso.');
            window.location.href = 'login.html';
        },
        error: function (jqXHR, textStatus, errorThrown) {
            message(1, 'Erro ao cadastrar: ' + textStatus);
        }
    });
}

//home
function getHome() {
    // faz a chamada para a API da home
    $.ajax({
        url: API + '/account/home',
        type: 'GET',
        headers: {
            Authorization: 'Bearer ' + getToken()
        },
        success: function (data) {
            // exibe os dados retornados pela API
            montaHome(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            if (jqXHR.status === 401) {
                // se o status for 401 (UNAUTHORIZED), redireciona para a página de login
                window.location.href = 'login.html';
            } else {
                message(1, 'Erro ao acessar a página: ' + textStatus + jqXHR.status);
            }
            //fake data
            montaHome(
                {balance:123,clientName:'juca',history:[
                    {hora:'13:33',tipo:'Crédito',usuario:'Lucas',valor:'R$123,45'},
                    {hora:'13:33',tipo:'Crédito',usuario:'Lucas',valor:'R$123,45'},
                    {hora:'13:33',tipo:'Crédito',usuario:'Lucas',valor:'R$123,45'}
                ]});
        }
    });
}

function montaHome(data) {
    document.getElementById('clientBalance').innerText = data.balance;
    document.getElementById('clientName').innerText = data.clientName;
    let tranferencias = '';
    data.history.forEach(element => {
        console.log(element);
        tranferencias += '<tr><td>13:33</td><td>Credito</td><td>Joao</td><td>R$150,00</td></tr>';
    });

    document.getElementById('transferencias').innerHTML = tranferencias;
}

//tranferencias
function obterFavorecidos() {
    $.ajax({
        url: API + '/users/list',
        type: 'GET',
        headers: {
            Authorization: 'Bearer ' + getToken()
        },
        success: function (data) {
            criaOpcoesFavorecidos(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            if (jqXHR.status === 403) {
                window.location.href = 'login.html';
            } else {
                message(1, 'Erro ao acessar a página home: ' + textStatus);
            }
        }
    });
}

function transferir() {
    // obtém os valores dos campos de login
    var accountId = $('#favorecidoAccountId').val();
    var value = $('#trasferValue').val();

    // faz a chamada para a API de login com os dados informados
    $.ajax({
        url: API + '/account/transfer',
        type: 'POST',
        contentType: 'application/json',
        headers: {
            Authorization: 'Bearer ' + getToken()
        },
        data: JSON.stringify({
            accountId: accountId,
            value: value
        }),
        success: function (data) {
            message(0, 'Transferência realizada com sucesso');
            goTo('home.html')
        },
        error: function (jqXHR, textStatus, errorThrown) {
            message(1, 'Erro ao transferir: ' + textStatus);
        }
    });
}

function criaOpcoesFavorecidos(data) {
    console.log(data);
    let options = ''
    data.forEach(element => {
        options += `<option value="${element.accountId}">${element.username}</option>`;
    });
    document.getElementById('favorecidosList').innerHTML = options;
}

//all
function sair() {
    localStorage.removeItem('token');
    window.location.href = 'login.html';
}

function goTo(page) {
    window.location.href = page;
}

function getToken() {
    // obtém o token do localStorage com o nome 'token'
    return localStorage.getItem('token');
}

function message(code, msg) {
    alert(msg)
}
