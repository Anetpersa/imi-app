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

            <form class="form-horizontal" method="POST" action="dodaj-rezervaciju">
                <c:if test="${hasErrors}">
                    <div class="alert alert-danger">
                        <errors path="*"></errors>
                        </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="imePrezime">Ime i prezime:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="imePrezime" name="imePrezime" placeholder="Upisite ime i prezime istrazivaca"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="naziv">Naziv uredjaja:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="naziv" name="naziv" readonly="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="datum">Datum:</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="datum" name="datum" placeholder="Izaberite datum eksperimenta"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="parametar">Parametar:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="parametar" name="parametar" placeholder="Upisite temperaturu, broj obrtaja..."/>
                    </div>
                </div>
                <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Rezervisi uredjaj</button>
                        </div>
                    </div>
            </form>
        </div>
    </body>
</html>
