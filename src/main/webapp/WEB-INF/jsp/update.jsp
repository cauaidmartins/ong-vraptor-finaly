<%-- 
    Document   : listaOngs
    Created on : Apr 18, 2020, 2:30:04 PM
    Author     : Martins
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de cliente - ${ongToUpdate.name}</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <main>
            <section>
                <form action="/ongs-web/OngServlet" method="post">
                    <input type="hidden" name="id" value="${ongToUpdate.id}"/>
                    <input type="hidden" name="operation" value="PUT"/>
                    <div>
                        <label for="name">Nome:</label>
                        <input id="name" type="text" name="name" value="${ongToUpdate.name}"/>
                    </div>
                    <div>
                        <input id="number" type="text" name="number" value="${ongToUpdate.number}"/>
                    </div>
                    <div>
                        <input id="email" type="text" name="email" value="${ongToUpdate.email}"/>
                    </div>
                    <div>
                        <button type="submit">Salvar</button>
                    </div>
                </form>
            </section>
        </main>
    </body>
</html>
