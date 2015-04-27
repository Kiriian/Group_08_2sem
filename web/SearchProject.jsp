<%-- 
    Document   : SearchProject
    Created on : 13-04-2015, 15:30:35
    Author     : martamiszczyk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CreateProject.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                    <li class="active"><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                    <li><a href="#">Submit POE</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">DELL</a>
                </div>
                <ul class="nav nav-tabs">
                    <li ><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                    <li class="active"><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
        
        <form name="Search project" action="searchProject" method="POST">
            <h1>Search Project</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
            <h4 align="left">To search for a project, choose the relevant status and press the search button</h4>
            <h4 align="left">To view or change a project, simply click the project ID of the project</h4>
            <input type="hidden" name="hiddenPartnerID" value='${user.getPartnerID()}' size="20" />
            <h3 id ="confirm" align="center" >${projectHaveBeenChanged}</h3>
            <hr>
            <p5>Status: &nbsp <select name="status">
                    <option value="Project proposal">Project proposal</option>
                    <option value="Project approval">Submittet</option>
                    <option value="Execution">Execution</option>
                    <option value="POE uploaded">Request POE</option>
                    <option value="POE approval">Approval</option>
                    <option value="Claim uploaded">Claim sent</option>
                    <option value="Claim approved">Claim sent</option>
                    <option value="Reimburst">Claim sent</option>                    
                </select></p5>
            <p6>Partner ID: <input type="text" name="partnerID" value='${user.getPartnerID()}' disabled="disabled"/> </p6>

            <br><br>
            Quarter:&nbsp <input type="text" name="quarter" value="" disabled="disabled"/>

            <p7><input type="submit" value="Search"/></p7>
            <br><br>

            <table>
                <tr>
                    <th>ProjectID</th>
                    <th>Status</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Activity Description</th>
                    <th>Objective & Result</th>
                    <th>Partner ID</th>
                    <th>Project Budget</th>
                    <th>Cost</th>
                    <th>Currency</th>
                    <th>Quarter</th>
                </tr>

        </form>
        <c:forEach var="p" items="${projects}">
        <tr>
            <td <a onclick="location.href = 'changeProjectServlet?projectid=${p.getProjectID()}'">${p.getProjectID()}</a></td>
            <td>${p.getStatus()}</td>
            <td>${p.getStartDate()}</td>
            <td>${p.getEndDate()}</td>
            <td>${p.getActivityDescription()}</td>
            <td>${p.getObjectiveResult()}</td>
            <td>${p.getPartnerID()}</td>
            <td>${p.getProjectBudget()}</td>
            <td>${p.getCost()}</td>
            <td>${p.getCurrency()}</td>
            <td>${p.getQuarter()}</td>

<!-- <p>${p}</p> -->
        </tr>
    </c:forEach>
</table>
</body>
</html>
