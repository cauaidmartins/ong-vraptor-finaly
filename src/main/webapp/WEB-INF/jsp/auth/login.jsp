
<%-- 
    Document   : Login
    Created on : 16/04/2020, 11:49:57
    Author     : Martins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en" class="html-l">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script type="text/javascript" src="js/vanila.js"></script>
        <title>Login</title>
    </head>

    <body class="body-back">
        
        <div class="login-page">
            <div class="form">
                <h4>Login</h4><br>
                <form class="login-form" action="auth" method="post">
                    <input type="text" id="userName" name="credentials.userName" placeholder="Nome" aria-describedby="emailHelp">
                    <input type="password" id="password" name="credentials.password" placeholder="Senha" name="senha">
                    <button>Entrar</button>
                    <br><br>
                    <p style='color:red;'>
                        ${loginErrorMsg}
                    </p>
                    <p class="message">Não é registrado ? <a href="cadastroUsu.jsp">Registre-se aqui</a></p>
                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>

</html>