<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obrisi uredjaj</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navigation.jsp" %>
        <div class="container">
            <h1>Obrisi uredjaj</h1>

            <h3 class="text-danger">Da li ste sigurni da zelite da obrisete ovaj uredjaj?</h3>
            <sf:form class="form-horizontal" method="POST" action="brisi-uredjaj" modelAttribute="obrisanUredjaj">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="naziv">Naziv:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="naziv" path="naziv" readonly="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lab">Laboratorija:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="lab" path="lab" readonly="true"/>
                    </div>
                </div>
            </div>
            <div class="form-group"> 
                <div class="col-sm-offset-2 col-sm-10">
                    <sf:hidden path="id"></sf:hidden>
                    <sf:button type="submit" class="btn btn-danger">Obrisi uredjaj</sf:button>
                        <a class="btn btn-default" href="lista-uredjaja">Vrati se na listu</a>
                    </div>
                </div>
        </sf:form>
    </div>
</body>
</html>
