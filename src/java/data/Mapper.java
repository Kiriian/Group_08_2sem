/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import control.ClaimDTO;
import control.EmployeeDTO;
import control.ImageDTO;
import control.PartnerDTO;
import control.ProjectDTO;
import control.QuarterDTO;
import control.UserDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Mapper {

    static {
        try {
            Class.forName(DB.DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserDTO validateCheckLogin(String username, String password) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql1 = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
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

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public ProjectDTO saveProject(ProjectDTO p) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;
        int projectIDSequence = 0;

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            String sql14 = "SELECT PROJECT_ID_SEQUENCE.NEXTVAL FROM DUAL";
            statement = connection.prepareStatement(sql14);
            rs = statement.executeQuery();
            while (rs.next())
            {
                projectIDSequence = rs.getInt("NEXTVAL");
                System.out.println("nextval er: " + projectIDSequence);
            }

            String sql2 = "INSERT INTO PROJECT(PROJECT_ID, STATUS, ACTIVITY_DESCRIPTION, COMMENTS, TARGET_AUDIENCE, PROJECT_BUDGET, CURRENCY, START_DATE, END_DATE, OBJECTIVE_RESULT, PARTNER_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(sql2);

            statement.setInt(1, projectIDSequence);
            statement.setString(2, p.getStatus());
            statement.setString(3, p.getActivityDescription());
            statement.setString(4, p.getComments());
            statement.setString(5, p.getTargetAudience());
            statement.setInt(6, p.getProjectBudget());
            statement.setString(7, p.getCurrency());
            statement.setString(8, p.getStartDate());
            statement.setString(9, p.getEndDate());
            statement.setString(10, p.getObjectiveResult());
            statement.setInt(11, p.getPartnerID());
            statement.executeUpdate();
            
            return getProject(projectIDSequence);
            
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        System.out.println("ok - fra io");
        return null;
    }

    public ArrayList<ProjectDTO> getAllPartnerProjects(String searchCriteria, int partnerID) throws SQLException {
        ArrayList<ProjectDTO> pOut = new ArrayList<>();
        ResultSet rs;
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql3 = "SELECT * FROM PROJECT WHERE STATUS = ? AND PARTNER_ID = ?";
            statement = connection.prepareStatement(sql3);
            statement.setString(1, searchCriteria);
            statement.setInt(2, partnerID);

            rs = statement.executeQuery();

            while (rs.next()) {
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
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return pOut;
    }

    public ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws SQLException {
        ArrayList<ProjectDTO> out = new ArrayList<>();
        ResultSet rs;
        PreparedStatement statement;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql4 = "SELECT * FROM PROJECT WHERE STATUS LIKE ? ORDER BY PROJECT_ID DESC";

            statement = connection.prepareStatement(sql4);
            statement.setString(1, searchCriteria);

            rs = statement.executeQuery();

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
        }
        return out;
    }

    public ProjectDTO getProject(int projectID) throws SQLException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        ProjectDTO p = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);) {
            String sql5 = "SELECT * FROM PROJECT WHERE PROJECT_ID LIKE '" + projectID + "'";

            statement = connection.prepareStatement(sql5);

            rs = statement.executeQuery(sql5);

            while (rs.next()) {

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
        }
        System.out.println("her" + p.toString());
        return p;
    }

    public ProjectDTO updateProject(ProjectDTO p) throws SQLException, java.text.ParseException {
        PreparedStatement statement = null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql6 = "UPDATE PROJECT SET STATUS=?,"
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
            statement = connection.prepareStatement(sql6);
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
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return p;
    }

    public void savePartner(PartnerDTO part) throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {

            String sql7 = "INSERT INTO PARTNER VALUES (PARTNER_ID_SEQUENCE.NEXTVAL, ?, ?, ?)";
            statement = connection.prepareStatement(sql7);
            statement.setString(1, part.getCountry());
            statement.setString(2, part.getPartnerName());
            statement.setString(3, part.getPartnerType());
            statement.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void createUser(UserDTO user) throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql8 = "INSERT INTO USERS VALUES (USER_ID_SEQUENCE.NEXTVAL, ?, ?,?, ?,?,?,?)";
            statement = connection.prepareStatement(sql8);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstname());
            statement.setString(4, user.getLastname());
            statement.setString(5, user.getUserType());
            statement.setInt(6, user.getPartnerID());
            statement.setInt(7, user.getEmployeeID());
            statement.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

    }

    public void createEmployee(EmployeeDTO emp) throws SQLException {
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql9 = "INSERT INTO EMPLOYEE VALUES (EMPLOYEE_ID_SEQUENCE.NEXTVAL, ?, ?, ?,?)";
            statement = connection.prepareStatement(sql9);
            statement.setString(1, emp.getFirstname());
            statement.setString(2, emp.getLastname());
            statement.setString(3, emp.getCountry());
            statement.setString(4, emp.getEmployeeType());
            statement.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void uploadPOE(Part file, String contentType, int projectID) throws SQLException, IOException {
        PreparedStatement statement = null;
        InputStream inputStream = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql10 = "INSERT INTO POE (IMAGE_ID, PROJECT_ID, CONTENT_TYPE, IMAGE) VALUES (IMAGE_ID_SEQUENCE.NEXTVAL, ?, ?, ?)";
            statement = connection.prepareStatement(sql10);
            statement.setInt(1, projectID);
            statement.setString(2, contentType);
            inputStream = file.getInputStream();
            statement.setBlob(3, inputStream);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void uploadClaim(Part file, String contentType, int projectID) throws SQLException, IOException {
        PreparedStatement statement = null;
        InputStream inputStream = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql11 = "INSERT INTO CLAIM (CLAIM_IMAGE_ID, PROJECT_ID, CONTENT_TYPE, IMAGE) VALUES (IMAGE_ID_SEQUENCE.NEXTVAL, ?, ?, ?)";
            statement = connection.prepareStatement(sql11);
            statement.setInt(1, projectID);
            statement.setString(2, contentType);
            inputStream = file.getInputStream();
            statement.setBlob(3, inputStream);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void createQuarter(QuarterDTO quarter) throws SQLException {
        PreparedStatement statement;

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql12 = "INSERT INTO QUARTER (QUARTER_NAME, QUARTER_BUDGET) VALUES (?, ?)";
            statement = connection.prepareStatement(sql12);
            statement.setString(1, quarter.getQuarterName());
            statement.setInt(2, quarter.getQuarterBudget());
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public ArrayList<ImageDTO> getImage(int projectID) throws SQLException, IOException {
        ArrayList<ImageDTO> imageOut = new ArrayList<>();
        PreparedStatement statement;
        ResultSet rs;
        InputStream inputStream = null;

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql13 = "SELECT * FROM POE WHERE PROJECT_ID = ?";

            statement = connection.prepareStatement(sql13);
            statement.setInt(1, projectID);
            rs = statement.executeQuery();

            while (rs.next()) {
                Blob blob = rs.getBlob("IMAGE");
                inputStream = blob.getBinaryStream();
                File tmp = new File("tmp.tmp");
                OutputStream out = new FileOutputStream(tmp);
                byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
                int len = 0;

                while ((len = inputStream.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                out.close();
                inputStream.close();
                imageOut.add(new ImageDTO(rs.getInt("IMAGE_ID"), rs.getInt("PROJECT_ID"), rs.getString("CONTENT_TYPE"), new FileInputStream(tmp)));
            }
            return imageOut;
        }
    }

    public ClaimDTO getClaim(int projectID) throws SQLException, FileNotFoundException, IOException {
        PreparedStatement statement;
        ResultSet rs;
        InputStream inputStream = null;
        ClaimDTO claim = null;

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql13 = "SELECT * FROM CLAIM WHERE PROJECT_ID = ?";

            statement = connection.prepareStatement(sql13);
            statement.setInt(1, projectID);
            rs = statement.executeQuery();

            while (rs.next()) {
                Blob blob = rs.getBlob("IMAGE");
                inputStream = blob.getBinaryStream();
                File tmp = new File("tmp.tmp");
                OutputStream out = new FileOutputStream(tmp);
                byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
                int len = 0;

                while ((len = inputStream.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                out.close();
                inputStream.close();
                claim = new ClaimDTO(rs.getInt("CLAIM_IMAGE_ID"), rs.getInt("PROJECT_ID"), rs.getString("CONTENT_TYPE"), new FileInputStream(tmp));
            }
            return claim;
        }
    }
}
