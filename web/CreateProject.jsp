<%-- 
    Document   : CreateProject
    Created on : 09-Apr-2015, 13:04:04
    Author     : Pernille
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
        <form name="Create project" action="createProject" method="POST">
        
        <h1>Create Project</h1><h3 align="right">Username: </h3>
        <hr>
        <br>
        <p> ${validateMsg} </p>
        <br>
        <br>
        <div> Project id:
            <span>Status:&nbsp <input type="text" name="status" value="Project proposal" size="20" readonly="readonly" /> </span> </div> <br>
        
        Start date: 
        <input type="text" name="startDate" value="" size="20" />&nbsp &nbsp &nbsp
        End date: 
        <input type="text" name="endDate" value="" size="20" /><br>
        <br>
        
        <p1>Budget: 
        <input type="text" name="budget" value="" size="20" />&nbsp &nbsp &nbsp
        Currency: 
        <select name="Currency">
            <option>DKK</option>
            <option>NOK</option>
            <option>EUR</option>
            <option>USD</option>
        </select></p1><br>
        <br>
        
        <p2>Contact information:
        <br> <br>
        Partner id: <input type="text" name="partnerID" value="" size="30" />
        <br><br>
        First name:
        <input type="text" name="firstName" value="" size="30" />
        <br> <br>
        Last name:
        <input type="text" name="lastName" value="" size="30" />
        <br> <br>
        Phone: 
        <input type="text" name="phone" value="" size="12" /> </p2>
        <br> <br><br>
        
        Activity description:
        <br>
        <textarea name="activetyDescription" rows="10" cols="40"></textarea>
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
