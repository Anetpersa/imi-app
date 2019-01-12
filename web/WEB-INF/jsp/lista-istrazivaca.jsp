<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista istrazivaca</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navigation.jsp" %>

        <div class="container">
            <h1>Lista istrazivaca</h1>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Redni Broj</th>
                        <th>Ime i prezime</th>
                        <th>Istrazivacka grupa</th>
                        <th>Email</th>
                        <th>Sifra</th>
                        <th>Promeni</th>
                        <th>Obrisi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaIstrazivaca}" var="istrazivac">
                        <tr>
                            <td>${istrazivac.id}</td>
                            <td>${istrazivac.imePrezime}</td>
                            <td>${istrazivac.istrazivackaGrupa}</td>
                            <td>${istrazivac.email}</td>
                            <td>${istrazivac.sifra}</td>
                            <td><a class="btn btn-default" href="promena?id=${istrazivac.id}">Promeni <span class="glyphicon glyphicon-edit text-info"></span></a></td>
                            <td><a class="btn btn-default" href="brisanje?id=${istrazivac.id}">Obrisi <span class="glyphicon glyphicon-trash text-danger"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
