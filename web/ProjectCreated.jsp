<%-- 
    Document   : projectCreated
    Created on : 13-Apr-2015, 09:31:24
    Author     : Pernille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="control.ProjectDTO"%>
<%ProjectDTO p=(ProjectDTO)request.getAttribute("Project");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Created</title><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
                <li class="active"><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
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
                <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                <li class="active"><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
                <li><a href="http://localhost:8080/Group_08_2sem/CreateQuarter.jsp">Create quarter</a></li>
            </ul>
        </c:otherwise>
    </c:choose>
    <h5>Start date: <%= p.getStartDate()%></h5>
        <h5>End date: <%= p.getEndDate()%></h5>
        <h5>Budget: <%= p.getProjectBudget()%></h5>
        <h5>Currency: <%= p.getCurrency()%></h5>
        <h5>Partner ID: <%= p.getPartnerID() %></h5>
        <h5>Activity Description: <%= p.getActivityDescription() %></h5>
        <h5>Comments: <%= p.getComments() %></h5>
        <h5>Target Audience: <%= p.getTargetAudience() %></h5>
        <h5>Objective & Result: <%= p.getObjectiveResult() %></h5>
    </body>
</html>
