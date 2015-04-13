/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.IO;
import java.sql.SQLException;

/**
 *
 * @author Jeanette
 */
public class Controller
{

    public void CreateProject(String startDate, String endDate, int budget, String currency, String activityDescription, String comments, String targetAudience, String objectiveResult, int partnerID, String firstname, String lastname, String phone) throws ClassNotFoundException, SQLException
    {
        int projectID = 0;
        ProjectDTO p = new ProjectDTO(projectID, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, partnerID, firstname, lastname, phone, budget);
        IO io = new IO();
        io.SaveProject(p);
    }
}
