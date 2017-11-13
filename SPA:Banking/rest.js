var rootURL = "http://localhost:7000/ibanking/";

$('#btnAcessar').click(function() {
 console.log('Acessar');
 acessar();
 return false;
});

$('#btnPagar').click(function() {
 console.log('Pagar');
 pagar();
 return false;
});

$('#btnListar').click(function() {
 console.log('Listar');
 buscar();
 return false;
});

function acessar(){
    var newUsuario={};
    newUsuario.login = $('#login').val();
    newUsuario.senha = $('#senha').val();
    newUsuario.conta = '';
    newUsuario.banco = '';
    newUsuario.nome = '';
    $.ajax({
        type: 'POST',
        crossDomain: true,
        contentType: 'application/json',
        url: rootURL+'autenticar',
        data: JSON.stringify(newUsuario),
        success: function(response){
            console.log(response);
            menu(response);
        },
        error: function(data){
            console.log('Error: ' + data);
        }
    });
}

function buscar(){
    var newUsuario={};
    newUsuario.login = $('#login').val();
    newUsuario.senha = $('#senha').val();
    newUsuario.conta = '';
    newUsuario.banco = '';
    newUsuario.nome = '';
    $.ajax({
        type: 'POST',
        crossDomain: true,
        contentType: 'application/json',
        url: rootURL+'buscar',
        data: JSON.stringify(newUsuario),
        success: function(response){
            console.log(response);
            tabela(response);
        },
        error: function(data){
            console.log('Error: ' + data);
        }
    });
}

function pagar(){
    var newTrans={};
    newTrans.solvente = $('#solvente').val();
    newTrans.banco = $('#banco').val();
    //newTrans.estado = $('#estado').val();
    newTrans.data = $('#data').val();
    newTrans.acipiente = $('#acipiente').val();
    newTrans.valor = $('#valor').val();
    newTrans.metodo = $('#metodo').val();

    $.ajax({
        type: 'POST',
        crossDomain: true,
        contentType: 'application/json',
        url: rootURL+'pagar',
        data: JSON.stringify(newTrans),
        success: function(response){
            console.log(response.estado);
            document.getElementById("Conteudo").innerHTML =response.estado;
        },
        error: function(data){
            console.log('Error: ' + data);
            document.getElementById("Conteudo").innerHTML =response;
        }
    });
}

function menu(response){
    var currentDate = new Date()
    var day = currentDate.getDate()
    var month = currentDate.getMonth() + 1
    var year = currentDate.getFullYear()

    var html = "<h1>Realizar pagamento - "+response.nome+"</h1>";
    html += "<br><form id='transferenciaForm'>";
    html += "<input id='solvente' name='solvente' type='hidden' value='"+response.conta+"'/>";
    html += "<input id='banco' name='banco' type='hidden' value='"+response.banco+"'/>";
    //html += "<input id='estado' name='estado' type='hidden' value='Inicial'/>";
    html += "<input id='data' name='data' type='hidden' value='"+ day + "/" + month + "/" + year +"'/>";
    html += "<label>Acipiente:</label><input id='acipiente' name='acipiente' type='text' />";
    html += "<label>valor:</label><input id='valor' name='valor' type='text' />";
    html += "<label>Meio de pagamento:</label><input id='metodo' name='metodo' type='text' />";
    html +=  "<button id='btnPagar'>Entrar</button></form>";
    html +=  "<form><button id='btnListar'>Listar transações</button>";
    html += "<input id='login' name='login' type='hidden' value='"+response.login+"'/>";
    html += "<input id='senha' name='senha' type='hidden' value='"+response.senha+"'/></form>";
    html+="<div id='Script'></div>";
    document.getElementById("Conteudo").innerHTML = html;
    var script = "<script src='jquery.min.js'></script><script src='rest.js'></script>";
    insertAndExecute("Script", script);
    return true;
}

function tabela(response){
    var html = "<table border='1|1'>";
    html+="<tr><th>Acipiente</th><th>Solvente</th><th>Banco</th><th>Método</th><th>Valor</th><th>Data</th></tr>";
    for (var i = 0; i < response.length; i++) {
    html+="<tr>";
    html+="<td>"+response[i].acipiente+"</td>";
    html+="<td>"+response[i].solvente+"</td>";
    html+="<td>"+response[i].banco+"</td>";
    html+="<td>"+response[i].metodo+"</td>";
    html+="<td>"+response[i].valor+"</td>";
    html+="<td>"+response[i].data+"</td>";
    html+="</tr>";
    }
    html+="</table>";
    document.getElementById("Conteudo").innerHTML = html;
}

//EU AMO O CARA QUE ESCREVEU ESSA FUNÇÃO
function insertAndExecute(id, text) {
    document.getElementById(id).innerHTML = text;
    var scripts = Array.prototype.slice.call(document.getElementById(id).getElementsByTagName("script"));
    for (var i = 0; i < scripts.length; i++) {
        if (scripts[i].src != "") {
            var tag = document.createElement("script");
            tag.src = scripts[i].src;
            document.getElementsByTagName("head")[0].appendChild(tag);
        }
        else {
            eval(scripts[i].innerHTML);
        }
    }
}
