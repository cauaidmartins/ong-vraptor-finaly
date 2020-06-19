<%-- 
    Document   : principal
    Created on : 16/04/2020, 12:47:06
    Author     : Martins
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

                            </ul>
                        </div>
                    </div>
                </nav>
                <div id="parallax-image">
                    <div class="row h-100">
                    </div>
                </div><br>
                <h2 class="example">ONG</h2>
                <div  class="container" align="justify">

                    <div class="col-sm">

                        <h8>
                            <p> ONG é a sigla para Organização Não-Governamental. São todas as organizações, sem fins lucrativos, criadas por pessoas que trabalham voluntariamente em defesa de uma causa, seja ela, proteção do meio ambiente, defesa dos direitos humanos, erradicação do trabalho infantil etc.</p>

                            <p> A expressão “Organização não Governamental” foi empregada pela primeira vez no ano de 1950, pela ONU (Organização das Nações Unidas), para fazer referência às organizações civis que não tinham nenhum vínculo com o governo.</p>

                            <p> A partir dos anos 1960 e 1970, a questão da degradação ambiental passou a ser preocupação de muitas pessoas em todo o mundo. Como resultado disso, surgiram movimentos que deram origem a Organizações não governamentais. Nos anos 70, já havia mais de 10 000 ONGs no Brasil.</p>

                            <p> A ONG faz parte do Terceiro Setor da sociedade, que são as instituições privada, sem fins lucrativos que têm a finalidade de dar complementar os serviços de ordem pública. Essas organizações devem funcionar legalmente, com registro em cartório, CNPJ e inscrição estadual.</p>

                            <p>A ONG é mantida financeiramente por pessoas físicas, empresas privadas, fundações e em alguns casos com a colaboração do próprio Estado. Os trabalhos são desenvolvidos por funcionários contratados e principalmente por voluntários.</p>

                            <p>Muitas ONGs, em todo o mundo, foram organizadas para defender o meio ambiente. Entre eles destaca-se o Greenpeace (do inglês green=verde, e peace=paz), que atuam em muitos países. Quando o meio ambiente está ameaçado, o Greenpeace e outras ONGs protestam publicamente para que a população tome conhecimento dos desastres ambientais.</p>
                            </p></h8>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
