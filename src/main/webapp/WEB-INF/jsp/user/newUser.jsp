<%-- 
    Document   : Login
    Created on : 16/04/2020, 11:49:57
    Author     : Martins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Cadastro de Usuário</title>
    </head>

    <body>
        <div class="wrapper d-flex align-items-stretch">
            <nav id="sidebar" class="active">
                <h6><a href="principal.jsp" class="logo">OngWeb</a></h6>
                <ul class="list-unstyled components mb-5">
                    <li class="active">
                        <a href="principal.jsp"><span class="fa fa-home"></span>Inicio</a>
                    </li>
                    <li>
                        <a href="listaUsuario.jsp"><span class="fa fa-user"></span> Usuários</a>
                    </li>
                    <li>
                        <a href="listaOngs.jsp"><span class="fa fa-sticky-note"></span> Ongs </a>
                    </li>
                    <br>

                    <div class="footer">
                        <p>
                        <h7 class="logo">Seja bem vindo, Admin> </h7></p>
                        <a href="login.jsp" class="logo">Deslogar</a>
                    </div>
            </nav>

            <!-- Page Content  -->
            <div id="content" class="p-4 p-md-5">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-primary">
                            <i class="fa fa-bars"></i>
                            <span class="sr-only">Toggle Menu</span>
                        </button>


                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="nav navbar-nav ml-auto">

                            </ul>
                        </div>
                    </div>
                </nav>

                <h7 class="mb-4">

                    <div class="form">
                        <h4>Cadastro de Usuário</h4><br>
                        <form class="login-form" action="novo" method="post">
                            <input type="text"  id="name" name="user.name" placeholder="Nome" aria-describedby="emailHelp">
                            <input type="text"  placeholder="CPF" id="cpf" name="user.cpf">
                            <button>Cadastrar</button>
                        </form>
                    </div>

            </div>
        </h7>
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>
