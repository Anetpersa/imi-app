<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dobrodosli</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <div class="container" >
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
        </div>


        <div class="container">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <h1 class="navbar-brand">Korisnicki panel</h1>
                </div>
                <div class="container-fluid">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="lista-uredjaja-za-rezervisanje">Rezervisi uredjaj</a></li>
                        <li class="nav-item">
                            <a class="nav-link" href="lista-rezervacija">Lista rezervacija</a></li>
                    </ul>
                </div>
        </div>

    </div>  
</nav>
</body>
</html>
