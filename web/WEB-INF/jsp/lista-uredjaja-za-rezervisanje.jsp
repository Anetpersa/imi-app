<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista uredjaja za rezervisanje</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
       <div class="container">
        <%@include file="navigation.jsp" %>
        </div>
        <div class="container">
            <h1>Lista uredjaja dostupnih za rezervisanje</h1>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Redni Broj</th>
                        <th>Naziv</th>
                        <th>Laboratorija</th>
                        <th>Rezervisi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaUredjajaZaRezervisanje}" var="uredjaj">
                        <tr>
                            <td>${uredjaj.id}</td>
                            <td>${uredjaj.naziv}</td>
                            <td>${uredjaj.lab}</td>
                            <td><a class="btn btn-default" href="rezervisi-uredjaj?idUredjaja=${uredjaj.id}">Rezervisi <span class="glyphicon glyphicon-edit text-info"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
