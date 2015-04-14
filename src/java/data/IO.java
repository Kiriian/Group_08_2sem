/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import control.ProjectDTO;
import data.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jeanette
 */
public class IO 
{
    public IO()throws ClassNotFoundException, SQLException
    {
            Class.forName(DB.DRIVER);
    }
    public void SaveProject(ProjectDTO p) 
    { 
            try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
            {
//                connection.setAutoCommit(false);
                String sql = "INSERT INTO PROJECT(PROJECT_ID, STATUS, ACTIVITY_DESCRIPTION, COMMENTS, TARGET_AUDIENCE, PROJECT_BUDGET, CURRENCY, START_DATE, END_DATE, OBJECTIVE_RESULT, PARTNER_ID) VALUES (PROJECT_ID_SEQUENCE.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
                        
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,p.getStatus());
                statement.setString(2, p.getActivityDescription());
                statement.setString(3, p.getComments());
                statement.setString(4, p.getTargetAudience());
                statement.setInt(5, p.getProjectBudget());
                statement.setString(6, p.getCurrency());
                statement.setString(7, p.getStartDate());
                statement.setString(8, p.getEndDate());
                statement.setString(9, p.getObjectiveResult());
                statement.setInt(10, p.getPartnerID());
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException sqle)
        {
            System.err.println(sqle);        
        }
            System.out.println("ok - fra io");
    }
    }