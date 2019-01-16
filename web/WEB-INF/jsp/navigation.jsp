<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:if test="${pageContext.request.userPrincipal.name !=null}">
    <h2>Dobrodosao, ${pageContext.request.userPrincipal.name}
    <a href="login?logout">Izloguj se</a> </h2>
</c:if>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="home">IMI App</a>
        </div>
        <ul class="nav navbar-nav">
            <li id="home"><a href="home">Home</a></li>
            <li id="dodaj-istrazivaca"><a href="dodaj-istrazivaca">Dodaj istrazivaca</a></li>
            <li id="lista-istrazivaca"><a href="lista-istrazivaca">Lista istrazivaca</a></li>
            <li id="dodaj-uredjaj"><a href="dodaj-uredjaj">Dodaj uredjaj</a></li>
            <li id="lista-uredjaja"><a href="lista-uredjaja">Lista uredjaja</a></li>
            <li id="lista-uredjaja-za-rezervisanje"><a href="lista-uredjaja-za-rezervisanje">Rezervisi uredjaj</a></li>
            <li id="moje-rezervacije"><a href="moje-rezervacije">Moje rezervacije</a></li>
                    </ul>
    </div>
</nav>
