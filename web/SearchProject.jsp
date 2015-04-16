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
        <h1>Search Project</h1><h3 align="right"> Username: </h3>
        <hr>
        <p5>Status: &nbsp <select name="status">
                <option value="Project proposal">Project proposal</option>
                <option value="Submit">Submittet</option>
                <option value="Execution">Execution</option>
                <option value="Request POE">Request POE</option>
                <option value="Approval">Approval</option>
            <option>Claim sent</option>
            </select></p5>
    <p6>Partner ID: <input type="text" name="partnerID" value="" disabled="disabled"/> </p6>

    <br><br>
        Quarter:&nbsp <input type="text" name="quarter" value="" disabled="disabled"/>
        
        <p7><input type="submit" value="Search"/></p7>
         <br><br>
        
        Result:  <p7> </p7>
        </form>
        <c:forEach var="p" items="${projects}">
            <p>${p}</p>
        </c:forEach>
    </body>
</html>
