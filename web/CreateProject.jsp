<%-- 
    Document   : CreateProject
    Created on : 09-Apr-2015, 13:04:04
    Author     : Pernille
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="ProjectCSS.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </head>
    <body>
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
        </c:otherwise>
    </c:choose>
        <form name="Create project" action="createProject" method="POST">

            <h1>Create Project</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5><input type="hidden" name="type" value='${user.getUserType()}' size="20" />
            <hr>
            <br>
            <p> ${validateMsg} </p>
            <br>
            
            <div> Project id:
                <span>Status:&nbsp <input type="text" name="status" value="Project proposal" size="20" readonly="readonly" /> </span> </div> <br>
            Partner ID:
            <input type="text" name="partnerID" value="" size="20" />
            Start date: 
            <input type="text" name="startDate" value="" size="20" />&nbsp &nbsp &nbsp
            End date: 
            <input type="text" name="endDate" value="" size="20" /><br>
            <br>

            <p1>Budget: 
                <input type="text" name="budget" value="" size="20" />&nbsp &nbsp &nbsp
                Currency: 
                <select name="currency">
                    <option value="DKK">DKK</option>
                    <option value="NOK">NOK</option>
                    <option value="EUR">EUR</option>
                    <option value="USD">USD</option>

                </select></p1><br>
            <br>

            Activity description:
            <br>
            <textarea name="activityDescription" rows="10" cols="40"></textarea>
            <br>

            <p3>Comments: 
                <br>
                <textarea name="comments" rows="10" cols="40"></textarea> </p3>
            <br>
            Target audience: 
            <input type="text" name="targetAudience" value="" size="20" />
            <br> <br>
            Objective & result: 
            <br>
            <textarea name="objectiveResult" rows="10" cols="40"></textarea>
            <br>

            <p4><input type="submit" value="Create project" name="Create project" style="width: 10em;  height:5em;" /></p4>
        </form>
    </body>
</html>
