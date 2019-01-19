<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dobrodosli</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <c:if test="${pageContext.request.userPrincipal.name !=null}">
            <h2>Dobrodosao, ${pageContext.request.userPrincipal.name}
                <a href="login?logout">Izloguj se</a> </h2>
            </c:if>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <h1 class="navbar-brand">Administratorski panel</h1>
</div>
            <div class="container-fluid">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="dodaj-istrazivaca">Dodaj istrazivaca</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista-istrazivaca">Lista istrazivaca</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="dodaj-uredjaj">Dodaj uredjaj</a></li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="lista-uredjaja">Lista uredjaja</a></li>
                </ul>
            </div>
        </nav>
    </body>
</html>
