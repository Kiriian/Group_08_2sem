/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import control.EmployeeDTO;
import control.PartnerDTO;
import control.ProjectDTO;
import control.UserDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author Jeanette
 */
public class Mapper
{

    static
    {
        try
        {
            Class.forName(DB.DRIVER);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserDTO validateCheckLogin(String username, String password) throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String checkLogin = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

            PreparedStatement statement = connection.prepareStatement(checkLogin);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                UserDTO user = new UserDTO(rs.getInt("USER_ID"),
                        rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
                        rs.getInt("PARTNER_ID"),
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("USER_TYPE"));
                return user;
            }

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        return null;
    }

    public void saveProject(ProjectDTO p) throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
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
            
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        System.out.println("ok - fra io");
    }

    public ArrayList<ProjectDTO> getAllPartnerProjects(String searchCriteria, int partnerID) throws SQLException
    {
        ArrayList<ProjectDTO> pOut = new ArrayList<>();
        ResultSet rs;
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String sql7 = "SELECT * FROM PROJECT WHERE STATUS = ? AND PARTNER_ID = ?";
            statement = connection.prepareStatement(sql7);
            statement.setString(1, searchCriteria);
            statement.setInt(2, partnerID);
            
            rs = statement.executeQuery();
            
            while (rs.next())
            {
                pOut.add(new ProjectDTO(
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
        }
        catch (SQLException sqle)
        {
            System.err.println(sqle); 
        }
       
        return pOut;
    }
    
    public ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws SQLException
    {
        ArrayList<ProjectDTO> out = new ArrayList<>();
        ResultSet rs;
        PreparedStatement statement;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String query = "SELECT * FROM PROJECT WHERE STATUS LIKE ? ORDER BY PROJECT_ID DESC";

            statement = connection.prepareStatement(query);
            statement.setString(1, searchCriteria);

            rs = statement.executeQuery();

            //=== read the result
            while (rs.next())
            {
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
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        return out;
    }

    public ProjectDTO getProjectToChange(int projectID) throws SQLException
    {
        ResultSet rs = null;
        PreparedStatement statement = null;
        ProjectDTO p = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);)
        {
            String sql2 = "SELECT * FROM PROJECT WHERE PROJECT_ID LIKE '" + projectID + "'";

            statement = connection.prepareStatement(sql2);

            rs = statement.executeQuery(sql2);

            while (rs.next())
            {

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
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        System.out.println("her" + p.toString());
        return p;
    }

    public ProjectDTO updateProject(ProjectDTO p) throws SQLException, java.text.ParseException
    {
        PreparedStatement statement = null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String sql3 = "UPDATE PROJECT SET STATUS=?,"
                    + "ACTIVITY_DESCRIPTION=?,"
                    + "COMMENTS=?,"
                    + "TARGET_AUDIENCE=?,"
                    + "PROJECT_BUDGET=?,"
                    + "PROJECT_COST=?,"
                    + "CURRENCY=?,"
                    + "START_DATE=?,"
                    + "END_DATE=?,"
                    + "OBJECTIVE_RESULT=?,"
                    + "EMPLOYEE_ID=?,"
                    + "QUARTER_NAME=?"
                    + "WHERE PROJECT_ID=?";
            statement = connection.prepareStatement(sql3);
            statement.setString(1, p.getStatus());
            statement.setString(2, p.getActivityDescription());
            statement.setString(3, p.getComments());
            statement.setString(4, p.getTargetAudience());
            statement.setInt(5, p.getProjectBudget());
            statement.setInt(6, p.getCost());
            statement.setString(7, p.getCurrency());
            java.util.Date startDate1 = formatter.parse(p.getStartDate());
            java.sql.Date startDate2 = new java.sql.Date(startDate1.getTime());
            statement.setDate(8, startDate2);
            java.util.Date endDate1 = formatter.parse(p.getEndDate());
            java.sql.Date endDate2 = new java.sql.Date(endDate1.getTime());
            statement.setDate(9, endDate2);
            statement.setString(10, p.getObjectiveResult());
            statement.setInt(11, p.getEmployeeID());
            statement.setString(12, p.getQuarter());
            statement.setInt(13, p.getProjectID());
            statement.executeUpdate();
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        return p;
    }

    public void savePartner(PartnerDTO part) throws SQLException
    {
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {

            String sql4 = "INSERT INTO PARTNER VALUES (PARTNER_ID_SEQUENCE.NEXTVAL, ?, ?, ?)";
            statement = connection.prepareStatement(sql4);
            statement.setString(1, part.getCountry());
            statement.setString(2, part.getPartnerName());
            statement.setString(3, part.getPartnerType());
            statement.executeUpdate();

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }

    public void createUser(UserDTO user) throws SQLException
    {
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String sql5 = "INSERT INTO USERS VALUES (USER_ID_SEQUENCE.NEXTVAL, ?, ?,?, ?,?,?,?)";
            statement = connection.prepareStatement(sql5);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstname());
            statement.setString(4, user.getLastname());
            statement.setString(5, user.getUserType());
            statement.setInt(6, user.getPartnerID());
            statement.setInt(7, user.getEmployeeID());
            statement.executeUpdate();

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }

    }

    public void createEmployee(EmployeeDTO emp) throws SQLException
    {
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String sql6 = "INSERT INTO EMPLOYEE VALUES (EMPLOYEE_ID_SEQUENCE.NEXTVAL, ?, ?, ?,?)";
            statement = connection.prepareStatement(sql6);
            statement.setString(1, emp.getFirstname());
            statement.setString(2, emp.getLastname());
            statement.setString(3, emp.getCountry());
            statement.setString(4, emp.getEmployeeType());
            statement.executeUpdate();

        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
    
    public void uploadPOE (Part file, int projectID) throws SQLException, IOException
    {
        PreparedStatement statement = null;
        InputStream inputStream = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String sql8="INSERT INTO POE (IMAGE_ID, PROJECT_ID, IMAGE) VALUES (IMAGE_ID_SEQUENCE.NEXTVAL, ?, ?)";
            statement = connection.prepareStatement(sql8);
            statement.setInt(1, projectID);
            inputStream = file.getInputStream();
            statement.setBlob(2, inputStream);
            statement.executeUpdate();         
        }
        catch(SQLException sqle)
        {
            System.err.println(sqle);
        }
    }
}
