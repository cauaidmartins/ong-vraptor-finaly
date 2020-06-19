<%-- 
    Document   : Donations
    Created on : Jun 19, 2020, 6:22:35 PM
    Author     : Lucas Rasec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <title>Inicio</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <div class="wrapper d-flex align-items-stretch">
            <nav id="sidebar" class="active">
                <h6><a href="principal.jsp" class="logo">OngWeb</a></h6>
                <ul class="list-unstyled components mb-5">
                    <li class="active">
                         <a href="${pageContext.request.contextPath}/"><span class="fa fa-home"></span>Inicio</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/user/lista"><span class="fa fa-user"></span> Doadores</a>
                        
                    </li>
                    <li>
                         <a href="${pageContext.request.contextPath}/ong/lista"><span class="fa fa-sticky-note"></span> Ongs </a>
                    </li>
                    <br>

                    <div class="footer">
                        <p>
                        <h7 class="logo">Seja bem vindo</h7></p>
                        <a href="${pageContext.request.contextPath}/signin" class="logo">Login</a>
                    </div>
            </nav>
                    
        <div id="content" class="p-4 p-md-5">

                <h7 class="mb-4"> 
                    <h4>Lista de Casos</h4><br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Descrição</th>
                                <th>Ong</th>
                                <th>Valor</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${user}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.desc}</td>
                                    <td>${user.ong}</td>
                                    <td>${user.value}</td>
                                    <td>
                                       
                                        <a  class="btn btn-primary" href="${pageContext.request.contextPath}/user/novo/${user.id}"><i class="material-icons teal-text">Doar</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table></h7>
    </body>
</html>
