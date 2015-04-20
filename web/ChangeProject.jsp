<%-- 
    Document   : ChangeProject
    Created on : 17-04-2015, 11:50:24
    Author     : martamiszczyk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="Change project" action="UpdateChangeProjectServlet" method="POST">
            <hr> 
            <br>
            <br>
            <br>
            <div> Project id:<input type="text" name="projectID" value='${project.getProjectID()}' size="20" readonly="readonly" /><br>
                <span>Status:&nbsp <input type="text" name="status" value='${project.getStatus()}'  size="20" readonly="readonly"/> </span> </div> <br>
            Status: &nbsp <select name="status">
                <option value="Project proposal">Project proposal</option>
                <option value="Submit">Submittet</option>
                <option value="Execution">Execution</option>
                <option value="Request POE">Request POE</option>
                <option value="Approval">Approval</option>
                <option value="Claim sent">Claim sent</option>
            </select>
            Start date: 
            <input type="text" name="startDate" value='${project.getStartDate()}' size="20" />&nbsp &nbsp &nbsp
            End date: 
            <input type="text" name="endDate" value='${project.getEndDate()}' size="20" /><br>
            <br>
            Quarter:
            <input type="text" name="quarter" value="FY1501" size="20" />
            <p1>Budget: 
                <input type="text" name="budget" value='${project.getProjectBudget()}' size="20" />&nbsp &nbsp &nbsp
                Cost: 
                <input type="text" name="cost" value='${project.getCost()}' size="20" />
                Currency: 
                <input type="text" name="currency" value='${project.getCurrency()}' size="20" readonly="readonly" />
                <select name="currency">
                    <option value="DKK">DKK</option>
                    <option value="NOK">NOK</option>
                    <option value="EUR">EUR</option>
                    <option value="USD">USD</option>
                </select> </p1>
            <p1>Quarter:</p1>
            <input type="text" name="quarter" value="FY????" size="20" />&nbsp &nbsp &nbsp
            Activity description:
            <br>
            <textarea name="activityDescription" rows="10" cols="40"  > ${project.getActivityDescription()}</textarea>
            <br>

            <p3>Comments: 
                <br>
                <textarea name="comments" rows="10" cols="40" >${project.getComments()}</textarea> </p3>
            <br>
            Target audience: 
            <input type="text" name="targetAudience" value='${project.getTargetAudience()}' size="20" />
            <br> <br>
            Objective & result: 
            <br>
            <textarea name="objectiveResult" rows="10" cols="40">${project.getObjectiveResult()}</textarea>
            <br>
            Required POE:
            <input type="text" name="requiredPOE" value="Nothing here yet" size="20" disabled="disabled" />
            <br>
            Employee ID:
            <input type="text" name="employeeID" value='${project.getEmployeeID()}' />
            <br>
            Partner ID:
            <input type="text" name="partnerID" value="1" size="20" readonly="readonly" />
            <input type="submit" value="UpdateChangeProjectServlet" name="UpdateChangeProjectServlet" style="width: 10em;  height:5em;" />
        </form>
    </body>
</html>
