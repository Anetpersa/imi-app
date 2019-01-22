<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Odbijen pristup</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <div class="container">    
            <%@include file="navigation.jsp" %>
            <h2 class="text-danger">Zao nam je, nemate pristup ovoj stranici.</h2>
            <h3><a href="login?logout">Izlogujte se</a></h3>          
    </div>
</body>
</html>