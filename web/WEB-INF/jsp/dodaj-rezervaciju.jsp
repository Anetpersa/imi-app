<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj rezervaciju</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navigation.jsp" %>
        <div class="container">
            <h1>Dodaj rezervaciju</h1>

            <sf:form class="form-horizontal" method="POST" action="dodaj-rezervaciju" modelAttribute="novaRezervacija">
                <c:if test="${hasErrors}">
                    <div class="alert alert-danger">
                        <sf:errors path="*"></sf:errors>
                        </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="imePrezime">Ime i prezime:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="imePrezime" path="imePrezime" placeholder="Upisite ime i prezime istrazivaca"/>
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
                        <sf:input type="date" class="form-control" id="datum" path="datum" placeholder="Izaberite datum eksperimenta"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="parametar">Parametar:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="parametar" path="parametar" placeholder="Upisite temperaturu, broj obrtaja..."/>
                    </div>
                </div>
                <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                        <sf:button type="submit" class="btn btn-default">Rezervisi uredjaj</sf:button>
                        </div>
                    </div>
            </sf:form>
        </div>
    </body>
</html>
