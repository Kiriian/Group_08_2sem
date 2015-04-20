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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jeanette
 */
public class IO { 

    //public IO() throws ClassNotFoundException, SQLException {
       
    

    

    public void SaveProject(ProjectDTO p) throws ClassNotFoundException {
        try {
            Class.forName(DB.DRIVER);
            Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
//                connection.setAutoCommit(false);
            String sql = "INSERT INTO PROJECT(PROJECT_ID, STATUS, ACTIVITY_DESCRIPTION, COMMENTS, TARGET_AUDIENCE, PROJECT_BUDGET, CURRENCY, START_DATE, END_DATE, OBJECTIVE_RESULT, PARTNER_ID) VALUES (PROJECT_ID_SEQUENCE.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getStatus());
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
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        System.out.println("ok - fra io");
    }

    public static Object getAllProjects(String searchCriteria) throws SQLException, ClassNotFoundException {
        ArrayList<ProjectDTO> out = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            Class.forName(DB.DRIVER);
            connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
            String query = "SELECT * FROM PROJECT WHERE STATUS LIKE '" + searchCriteria + "' ORDER BY PROJECT_ID DESC";

            statement = connection.prepareStatement(query);
            //statement.setString(1, "Project proposal");

            rs = statement.executeQuery(query);

            //=== read the result
            while (rs.next()) {
                out.add(new ProjectDTO(
                        rs.getString("STATUS"),
                        rs.getString("START_DATE"),
                        rs.getString("END_DATE"),
                        rs.getString("CURRENCY"),
                        rs.getString("ACTIVITY_DESCRIPTION"),
                        rs.getString("COMMENTS"),
                        rs.getString("TARGET_AUDIENCE"),
                        rs.getString("OBJECTIVE_RESULT"),
                        rs.getInt("PARTNER_ID"),
                        rs.getInt("PROJECT_BUDGET"),
                        rs.getInt("PROJECT_COST"),
                        rs.getString("REQUIRED_POE"),
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getInt("PROJECT_ID"),
                        rs.getString("QUARTER_NAME")));
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        } finally {
            statement.close();
            connection.close();
        }

        return out;
    }

    public static ProjectDTO getProjectToChange(int projectID) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        ProjectDTO p = null;
        try {
            Class.forName(DB.DRIVER);
            connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
            String sql2 = "SELECT * FROM PROJECT WHERE PROJECT_ID LIKE '" + projectID + "'";

            statement = connection.prepareStatement(sql2);

            rs = statement.executeQuery(sql2);
            
            while(rs.next()){

            p = new ProjectDTO(
                    rs.getString("STATUS"),
                    rs.getString("START_DATE"),
                    rs.getString("END_DATE"),
                    rs.getString("CURRENCY"),
                    rs.getString("ACTIVITY_DESCRIPTION"),
                    rs.getString("COMMENTS"),
                    rs.getString("TARGET_AUDIENCE"),
                    rs.getString("OBJECTIVE_RESULT"),
                    rs.getInt("PARTNER_ID"),
                    rs.getInt("PROJECT_BUDGET"),
                    rs.getInt("PROJECT_COST"),
                    rs.getString("REQUIRED_POE"),
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getInt("PROJECT_ID"),
                    rs.getString("QUARTER_NAME"));
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        } finally {
            statement.close();
            connection.close();
        }
        return p;
    }
public void UpdateProject(ProjectDTO p) throws ClassNotFoundException {
        try {
            Class.forName(DB.DRIVER);
            Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
//                connection.setAutoCommit(false);
           
String sql3= "UPDATE PROJECT SET STATUS=?,"
        + "ACTIVITY_DESCRIPTION=?,"
        + "COMMENTS=?,"
        + "TARGET_AUDIENCE=?,"
        + "PROJECT_BUDGET=?, "
        + "CURRENCY=?, "
        + "START_DATE=?, "
        + "END_DATE=?,"
        + "OBJECTIVE_RESULT=?, "
        + "EMPLOYEE_ID=?,"
        + "QUARTER_NAME=?  WHERE PROJECT_ID=?"; 
            PreparedStatement statement = connection.prepareStatement(sql3);
            statement.setString(1, p.getStatus());
            statement.setString(2, p.getActivityDescription());
            statement.setString(3, p.getComments());
            statement.setString(4, p.getTargetAudience());
            statement.setInt(5, p.getProjectBudget());
            statement.setString(6, p.getCurrency());
            statement.setString(7, p.getStartDate());
            statement.setString(8, p.getEndDate());
            statement.setString(9, p.getObjectiveResult());
            statement.setInt(10, p.getEmployeeID());
            statement.setString(11, p.getQuarter());
            statement.setInt(12, p.getProjectID());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        System.out.println("ok - fra io");
    }
}

