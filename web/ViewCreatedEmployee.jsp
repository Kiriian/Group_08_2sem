<%-- 
    Document   : ViewCreatedEmployee
    Created on : 02-05-2015, 11:58:40
    Author     : Jeanette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="control.EmployeeDTO"%>
<%EmployeeDTO emp = (EmployeeDTO) request.getAttribute("emp");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View created employee</title><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
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
    <br>
    <hr>
    <br>
    <h4>Employee ID: <%=emp.getEmployeeID()%></h4>
    <br>
    <h4>Country: <%=emp.getCountry()%></h4>
    <br>
    <h4>Employee type: <%=emp.getEmployeeType()%></h4>
    <br>
    <h4>Firstname: <%=emp.getFirstname()%></h4>
    <br>
    <h4>Lastname: <%=emp.getLastname()%></h4>
    <br>
</body>
</html>
