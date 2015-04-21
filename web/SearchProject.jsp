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
    </head>
    <body>
        <form name="Search project" action="searchProject" method="POST">
        <h1>Search Project</h1>
        <h4 align="left">To search for a project, choose the relevant status and press the search button</h4>
        <h4 align="left">To view or change a project, simply click the project ID of the project</h4>
        <h3 align="right">Username: </h3>
        <h3 id ="confirm" align="center" >${projectHaveBeenChanged}</h3>
        <hr>
        <p5>Status: &nbsp <select name="status">
                <option value="Project proposal">Project proposal</option>
                <option value="Submit">Submittet</option>
                <option value="Execution">Execution</option>
                <option value="Request POE">Request POE</option>
                <option value="Approval">Approval</option>
            <option value="Claim sent">Claim sent</option>
            </select></p5>
    <p6>Partner ID: <input type="text" name="partnerID" value="" disabled="disabled"/> </p6>

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
            <td <a onclick="location.href='changeProjectServlet?projectid=${p.getProjectID()}'">${p.getProjectID()}</a></td>
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
