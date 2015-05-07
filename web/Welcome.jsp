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
        <h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
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
                    <li><a href="http://localhost:8080/Group_08_2sem/UploadClaim.jsp">Upload claim</a></li>
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

        <img src="http://orig01.deviantart.net/6b6b/f/2015/127/f/8/dell_logo_by_kiriian-d8sgnfi.jpg" align="top" /> 
        <br>
        <br>
        <h4>To create a project, please press "Create project".</h4>

        <h4>  To search for a project, choose the relevant status and press the search button.</h4>

        <h4>  To view or change a project, press Search and change project. 
            Choose the relevant status and press the search button and click the project ID of the project.</h4>

        <h4>   To create a partner, please press "Create partner".</h4>

        <h4>   To create a user, please press "Create user".</h4>

        <h4>   To create a employee, please press "Create employee".</h4>

        <h4>   To create a quarter, please press "Create quarter".</h4>


    </body>
</html>
