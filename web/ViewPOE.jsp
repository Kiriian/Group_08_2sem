<%-- 
    Document   : ViewPOE
    Created on : 28-Apr-2015, 09:32:56
    Author     : Pernille
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <c:set var="user" value="${user}"></c:set>
    <c:choose>
        <c:when test="${user.getUserType() eq 'Partner'}">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">DELL</a>
            </div>
            <ul class="nav nav-tabs">
                <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/UploadPOE.jsp">Submit POE</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/UploadClaim.jsp">Upload claim</a></li>
                <li class="active"><a href="http://localhost:8080/Group_08_2sem/ViewPOE.jsp">View POE</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <div class="navbar-header">
                <a class="navbar-brand" href="#">DELL</a>
            </div>
            <ul class="nav nav-tabs">
                <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateQuarter.jsp">Create quarter</a></li>
                <li class="active"><a href="http://localhost:8080/Group_08_2sem/ViewPOE.jsp">View POE</a></li>
        </c:otherwise>
    </c:choose>
       
            <br>
            <br>
    </body>
</html>
