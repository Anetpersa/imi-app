<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista rezervacija</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navigation.jsp" %>

        <div class="container">
            <h1>Lista rezervacija</h1>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Ime i prezime</th>
                        <th>Naziv uredjaja</th>
                        <th>Datum</th>
                        <th>Parametar</th>
                        <th>Promeni</th>
                        <th>Obrisi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaRezervacija}" var="rezervacija">
                        <tr>
                            <td>${rezervacija.istrazivacModel.imePrezime}</td>
                            <td>${rezervacija.uredjajModel.naziv}</td>
                            <td>${rezervacija.datum}</td>
                            <td>${rezervacija.parametar}</td>
                            <td><a class="btn btn-default" href="promena-rezervacije?id=${rezervacija.id}">Promeni <span class="glyphicon glyphicon-edit text-info"></span></a></td>
                            <td><a class="btn btn-default" href="brisanje-rezervacije?id=${rezervacija.id}">Obrisi <span class="glyphicon glyphicon-trash text-danger"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
