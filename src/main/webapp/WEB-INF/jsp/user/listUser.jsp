<%-- 
    Document   : Login
    Created on : 16/04/2020, 11:49:57
    Author     : Martins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Lista de Ongs</title>
    </head>

    <body><div class="wrapper d-flex align-items-stretch">
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
                        <h7 class="logo">Seja bem vindo, <%= request.getAttribute("user")%> </h7></p>
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
                                <li class="nav-item active">

                                    <a class="nav-link" href="cadastroUsu.jsp"><i class="fa fa-plus "></i>  Cadastrar Usuário</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <h7 class="mb-4"> 
                    <h4>Lista de Usuários</h4><br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Email</th>
                                <th>Senha</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${user}" var="user">
                                <tr>
                                    <td>${user.nome}</td>
                                    <td>${user.cpf}</td>
                                    <td>${user.email}</td>
                                    <td>${user.senha}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/user/editar/${user.id}"><i class="material-icons teal-text">create</i></a>
                                        <a href="${pageContext.request.contextPath}/user/remover/${user.id}"><i class="material-icons red-text">delete</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table></h7>

            </div>
        </div>
        <script src="../js/jquery.min.js"></script>
        <script src="../js/popper.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>

</html>
