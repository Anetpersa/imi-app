<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promeni istrazivaca</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <div class="container">
        <%@include file="navigation.jsp" %>
        </div>
        <div class="container">
            <h1>Promeni istrazivaca</h1>

            <sf:form class="form-horizontal" method="POST" action="menjaj-istrazivaca" modelAttribute="promenjenIstrazivac">
                <c:if test="${hasErrors}">
                    <div class="alert alert-danger">
                        <sf:errors path="*"></sf:errors>
                        </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="imePrezime">Ime i prezime:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="imePrezime" path="imePrezime" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="istrazivackaGrupa">Istrazivacka grupa:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="istrazivackaGrupa" path="istrazivackaGrupa"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-10">
                        <sf:input type="email" class="form-control" id="email" path="email" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="sifra">Sifra:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="sifra" path="sifra" />
                    </div>
                </div>
                <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                        <sf:hidden path="id"></sf:hidden>
                        <sf:button type="submit" class="btn btn-default">Promeni istrazivaca</sf:button>
                            <a class="btn btn-primary"href="lista-istrazivaca">Vrati se na listu</a>
                        </div>
                    </div>
            </sf:form>
        </div>
    </body>
</html>
