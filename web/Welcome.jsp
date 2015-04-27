<%-- 
    Document   : Welcome
    Created on : 22-Apr-2015, 08:38:40
    Author     : Pernille
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
    <c:set var="user" value="${user}"></c:set>
    <c:choose>
        <c:when test="${user.getUserType() eq 'Partner'}">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">DELL</a>
            </div>
            <ul class="nav nav-tabs">
                <li class="active"><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/UploadPOE.jsp">Submit POE</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <div class="navbar-header">
                <a class="navbar-brand" href="#">DELL</a>
            </div>
            <ul class="nav nav-tabs">
                <li class="active"><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateQuarter.jsp">Create quarter</a></li>
            </ul>
        </c:otherwise>
    </c:choose>
    <br>
    <br>
    <br>
    <br>
    <h1>kan man skrive mere her?</h1>
    <h3>ja da!</h3>
</body>
</html>
