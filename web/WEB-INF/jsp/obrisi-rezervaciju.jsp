<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obrisi rezervaciju</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navigation.jsp" %>
        <div class="container">
            <h1>Obrisi rezervaciju</h1>

            <h3 class="text-danger">Da li ste sigurni da zelite da obrisete ovu rezervaciju?</h3>
            <sf:form class="form-horizontal" method="POST" action="brisi-rezervaciju" modelAttribute="obrisanaRezervacija">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="imePrezime">Ime i prezime istrazivaca:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="imePrezime" path="imePrezime" readonly="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="naziv">Naziv uredjaja:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="naziv" path="naziv" readonly="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="datum">Datum:</label>
                    <div class="col-sm-10">
                        <sf:input type="date" class="form-control" id="datum" path="datum" readonly="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="parametar">Parametar:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="parametar" path="parametar" readonly="true"/>
                    </div>
                </div>
                <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                        <sf:hidden path="id"></sf:hidden>
                        <sf:button type="submit" class="btn btn-danger">Obrisi rezervaciju</sf:button>
                            <a class="btn btn-default" href="moje-rezervacije">Vrati se na moj raspored</a>
                        </div>
                    </div>
                </div>
        </sf:form>
    </div>
</body>
</html>
