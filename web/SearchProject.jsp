<%-- 
    Document   : SearchProject
    Created on : 13-04-2015, 15:30:35
    Author     : martamiszczyk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CreateProject.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Project</h1><h3 align="right"> Username: </h3>
        <hr>
        <p5>Status: &nbsp <select name="status">
            <option>Project proposal</option>
            <option>Submittet</option>
            <option>Execution</option>
            <option>Request POE</option>
            <option>Approval</option>
            <option>Claim sent</option>
            </select></p5>
    <p6>Partner Name: <input type="text" name="partnerName" value="" /> </p6>
    <br><br>
        Quarter:&nbsp <input type="text" name="quarter" value="" />
        
        <p7><input type="submit" value="Search" name="search" /></p7> <br><br>
        
        Result:  <p7> </p7>
    </body>
</html>
