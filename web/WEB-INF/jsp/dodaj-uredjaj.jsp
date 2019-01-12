<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj uredjaj</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navigation.jsp" %>
        <div class="container">
            <h1>Dodaj uredjaj</h1>

            <sf:form class="form-horizontal" method="POST" action="dodaj-uredjaj" modelAttribute="noviUredjaj">
                <c:if test="${hasErrors}">
                    <div class="alert alert-danger">
                        <sf:errors path="*"></sf:errors>
                        </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="naziv">Naziv:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="naziv" path="naziv" placeholder="Upisite naziv uredjaja"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lab">Laboratorija:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="lab" path="lab" placeholder="Upisite naziv laboratorije u kojoj se uredjaj nalazi"/>
                    </div>
                </div>
            </div>
            <div class="form-group"> 
                <div class="col-sm-offset-2 col-sm-10">
                    <sf:button type="submit" class="btn btn-default">Dodaj uredjaj</sf:button>
                    </div>
                </div>
        </sf:form>
    </div>
</body>
</html>
