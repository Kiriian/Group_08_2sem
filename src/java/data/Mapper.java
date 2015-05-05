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
import java.text.Format;
import java.text.ParseException;
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

    // Her opretter vi forbindelse til databasen og metoden vil blive kladt hver gang vi kalder Mapper.
    static {
        try {
            Class.forName(DB.DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Vi henter alle users up fra databasen og sammenligner med det username og password brugerne har indtastet.
    // Hvis det er det samme som er i databasen, returner den userne ellers returner den null.
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

    //Vi henter den næste værdi ud af PROJECT_ID_SEQUENCE og returner den
    public int getProjectIDSequence() throws SQLException {
        PreparedStatement statement;
        ResultSet rs;
        int projectIDSequence = 0;

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql15 = "SELECT PROJECT_ID_SEQUENCE.NEXTVAL FROM DUAL";
            statement = connection.prepareStatement(sql15);
            rs = statement.executeQuery();
            while (rs.next()) {
                projectIDSequence = rs.getInt("NEXTVAL");
            }

            return projectIDSequence;
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    // Vi henter informationerne ud fra p, sætter dem ned i databasen sammen med den projectID vi får fra metoden
    // getProjectIDSequence() og derefter henter vi den igen ud ved hjælp af metoden getProject hvorefter vi returner p2
    // som er lige det vi får fra vores getProject metode.
    public ProjectDTO saveProject(ProjectDTO p) throws SQLException, ParseException {
        ProjectDTO p2;
        PreparedStatement statement;
        ResultSet rs = null;
        // for at kunne sætte dato'erne ned i databasen, skal vi først formatter dem,
        //her fortæller vi programmet hvordan de skal se ud.
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            int projectID = getProjectIDSequence();

            String sql2 = "INSERT INTO PROJECT(PROJECT_ID, STATUS, ACTIVITY_DESCRIPTION, COMMENTS, TARGET_AUDIENCE, PROJECT_BUDGET, CURRENCY, START_DATE, END_DATE, OBJECTIVE_RESULT, PARTNER_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(sql2);

            statement.setInt(1, projectID);
            statement.setString(2, p.getStatus());
            statement.setString(3, p.getActivityDescription());
            statement.setString(4, p.getComments());
            statement.setString(5, p.getTargetAudience());
            statement.setInt(6, p.getProjectBudget());
            statement.setString(7, p.getCurrency());
            // først parse vi startDate til den dato-type Java kender.
            java.util.Date startDate1 = formatter.parse(p.getStartDate());
            // derefter laver vi det om til den dato-type vores database kender, så vi bare kan brug setDate.
            java.sql.Date startDate2 = new java.sql.Date(startDate1.getTime());
            statement.setDate(8, startDate2);
            java.util.Date endDate1 = formatter.parse(p.getEndDate());
            java.sql.Date endDate2 = new java.sql.Date(endDate1.getTime());
            statement.setDate(9, endDate2);
            statement.setString(10, p.getObjectiveResult());
            statement.setInt(11, p.getPartnerID());
            statement.executeUpdate();
            p2 = getProject(projectID);
            return p2;

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    //Her får vi en partnerID og status ind, som vi bruger til at søg i databasen, derefter returner vi en array
    // med alle de projekter der matcher vores søgkriterier, hvilket vil sig at en partner kun kan se sine egen projekter.
    public ArrayList<ProjectDTO> getAllPartnerProjects(String searchCriteria, int partnerID) throws SQLException {
        ArrayList<ProjectDTO> pOut = new ArrayList<>();
        ResultSet rs;
        PreparedStatement statement;
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

    //Her får vi en status ind, som vi bruger til at søg i databasen, derefter returner vi en array
    // med alle de projekter der matcher vores søgkriterier.
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

    //her henter vi ved hjælp af projectID et enkelt project ud, hvorefter vi returner det til servletten.
    public ProjectDTO getProject(int projectID) throws SQLException {
        String startDate;
        String endDate;
        ResultSet rs;
        PreparedStatement statement;
        ProjectDTO p2 = null;
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);) {
            String sql5 = "SELECT * FROM PROJECT WHERE PROJECT_ID = ?";
            statement = connection.prepareStatement(sql5);
            statement.setInt(1, projectID);
            rs = statement.executeQuery();

            while (rs.next()) {
                p2 = new ProjectDTO(
                        rs.getString("STATUS"),
                        formatter.format(rs.getDate("START_DATE")),
                        formatter.format(rs.getDate("END_DATE")),
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
            return p2;

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    //Vi henter alle informationer ud fra ProjectDTO'en og updater alle koloner i tabellen,
    //der efter returner vi det.
    public ProjectDTO updateProject(ProjectDTO p) throws SQLException, java.text.ParseException {
        PreparedStatement statement = null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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

    //Samme principe som saveProject udover at vi i stedet for at have en seprate metode, henter vores Partner_id_sequence ud
    // og derefter sætter det ind sammen med de andre værdier, hvorefter vi returner
    // en anden PartnerDTO, så brugerne kan se hvad der er blevet gemt.
    public PartnerDTO savePartner(PartnerDTO part) throws SQLException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        int partnerIDSequence = 0;

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql20 = "SELECT PARTNER_ID_SEQUENCE.NEXTVAL FROM DUAL";
            statement = connection.prepareStatement(sql20);
            rs = statement.executeQuery();
            while (rs.next()) {
                partnerIDSequence = rs.getInt("NEXTVAL");
            }

            String sql7 = "INSERT INTO PARTNER VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql7);
            statement.setInt(1, partnerIDSequence);
            statement.setString(2, part.getCountry());
            statement.setString(3, part.getPartnerName());
            statement.setString(4, part.getPartnerType());
            statement.executeUpdate();

            String sql21 = "SELECT * FROM PARTNER WHERE PARTNER_ID = ?";
            statement = connection.prepareStatement(sql21);
            statement.setInt(1, partnerIDSequence);
            rs = statement.executeQuery();

            while (rs.next()) {
                part = new PartnerDTO(rs.getInt("PARTNER_ID"), rs.getString("COUNTRY"), rs.getString("PARTNER_NAME"), rs.getString("PARTNER_TYPE"));
            }
            return part;

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return null;
    }

    // samme som createPartner.
    public UserDTO createUser(UserDTO user) throws SQLException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        int userIDSequence = 0;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql16 = "SELECT USER_ID_SEQUENCE.NEXTVAL FROM DUAL";
            statement = connection.prepareStatement(sql16);
            rs = statement.executeQuery();
            while (rs.next()) {
                userIDSequence = rs.getInt("NEXTVAL");
            }

            String sql8 = "INSERT INTO USERS VALUES (?, ?, ?,?, ?,?,?,?)";
            statement = connection.prepareStatement(sql8);
            statement.setInt(1, userIDSequence);
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstname());
            statement.setString(5, user.getLastname());
            statement.setString(6, user.getUserType());
            statement.setInt(7, user.getPartnerID());
            statement.setInt(8, user.getEmployeeID());
            statement.executeUpdate();

            String sql17 = "SELECT * FROM USERS WHERE USER_ID = ?";
            statement = connection.prepareStatement(sql17);
            statement.setInt(1, userIDSequence);
            rs = statement.executeQuery();

            while (rs.next()) {
                user = new UserDTO(rs.getInt("USER_ID"),
                        rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
                        rs.getInt("PARTNER_ID"),
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("USER_TYPE"));
            }

            return user;

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    // samme som createPartner.
    public EmployeeDTO createEmployee(EmployeeDTO emp) throws SQLException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        int employeeIDSequence = 0;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql17 = "SELECT EMPLOYEE_ID_SEQUENCE.NEXTVAL FROM DUAL";
            statement = connection.prepareStatement(sql17);
            rs = statement.executeQuery();
            while (rs.next()) {
                employeeIDSequence = rs.getInt("NEXTVAL");
            }

            String sql9 = "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?,?)";
            statement = connection.prepareStatement(sql9);
            statement.setInt(1, employeeIDSequence);
            statement.setString(2, emp.getFirstname());
            statement.setString(3, emp.getLastname());
            statement.setString(4, emp.getCountry());
            statement.setString(5, emp.getEmployeeType());
            statement.executeUpdate();

            String sql18 = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
            statement = connection.prepareStatement(sql18);
            statement.setInt(1, employeeIDSequence);
            rs = statement.executeQuery();

            while (rs.next()) {
                emp = new EmployeeDTO(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("COUNTRY"), rs.getString("EMPLOYEE_TYPE"));
            }

            return emp;

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return null;
    }

    // Her gemme vi filen, uanset hvad type, ned i databasen.
    public void uploadPOE(Part file, String contentType, int projectID) throws SQLException, IOException {
        PreparedStatement statement = null;
        InputStream inputStream = null;
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql10 = "INSERT INTO POE (IMAGE_ID, PROJECT_ID, CONTENT_TYPE, IMAGE) VALUES (IMAGE_ID_SEQUENCE.NEXTVAL, ?, ?, ?)";
            statement = connection.prepareStatement(sql10);
            statement.setInt(1, projectID);
            //For at kunne hente file rigtigt op igen skal vi bruger filetypen,
            //derfor gemmer vi den ned sammen med filen.
            statement.setString(2, contentType);
            //Her tager vi filens inputstream, ligger det ned i en inputStream variable og
            //bruger setBlob til at gemme inputstreamen ned i databasen
            inputStream = file.getInputStream();
            statement.setBlob(3, inputStream);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    //Samme princip some uploadPOE.
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

    //Samme princip som createUser, udover at vi denne gang ikke bruger nogen sequence.
    public QuarterDTO createQuarter(QuarterDTO quarter) throws SQLException {
        ResultSet rs = null;
        PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql12 = "INSERT INTO QUARTER (QUARTER_NAME, QUARTER_BUDGET) VALUES (?, ?)";
            statement = connection.prepareStatement(sql12);
            statement.setString(1, quarter.getQuarterName());
            statement.setInt(2, quarter.getQuarterBudget());
            statement.executeUpdate();

            String sql19 = "SELECT * FROM QUARTER WHERE QUARTER_NAME = ? AND QUARTER_BUDGET = ?";
            statement = connection.prepareStatement(sql19);
            statement.setString(1, quarter.getQuarterName());
            statement.setInt(2, quarter.getQuarterBudget());
            rs = statement.executeQuery();

            while (rs.next()) {
                quarter = new QuarterDTO(rs.getString("QUARTER_NAME"), rs.getInt("QUARTER_BUDGET"));
            }
            return quarter;

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return null;
    }

    //Her hente vi filen ud fra databasen igen
    public ArrayList<ImageDTO> getImage(int projectID) throws SQLException, IOException {
        ArrayList<ImageDTO> imageOut = new ArrayList<>();
        PreparedStatement statement;
        ResultSet rs;
        InputStream inputStream = null;

        //Vi starter ud ligesom vi plejer, med at hente ud fra databasen
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql13 = "SELECT * FROM POE WHERE PROJECT_ID = ?";

            statement = connection.prepareStatement(sql13);
            statement.setInt(1, projectID);
            rs = statement.executeQuery();

            while (rs.next()) {
                //Vi starter med at hente en blob ud,
                Blob blob = rs.getBlob("IMAGE");
                //Derefter gemmer vi blobens binaryStream i en inputstream variable
                inputStream = blob.getBinaryStream();
                //Derefter laver vi en file som vi kan send til vores servlet
                File tmp = new File("tmp.tmp");
                //Filen laver vi om til en OutputStream så vi kan gemme inputstream i den
                OutputStream out = new FileOutputStream(tmp);
                byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
                int len = 0;

                //her begynder vi at læse fra inputStreamen og gemme det ned i filen.
                //Vi fortsætter med at læse til inputstreamen er -1
                while ((len = inputStream.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                //Her efter lukker vi outputstreamen og inputstreamen, hvorefter vi laver et nyt
                //claim objekt som vi returner.
                out.close();
                inputStream.close();
                imageOut.add(new ImageDTO(rs.getInt("IMAGE_ID"), rs.getInt("PROJECT_ID"), rs.getString("CONTENT_TYPE"), new FileInputStream(tmp)));
            }
            return imageOut;
        }
    }

    //Her hente vi filen ud fra databasen igen
    public ClaimDTO getClaim(int projectID) throws SQLException, FileNotFoundException, IOException {
        PreparedStatement statement;
        ResultSet rs;
        InputStream inputStream = null;
        ClaimDTO claim = null;

        //Vi starter ud ligesom vi plejer, med at hente ud fra databasen
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW)) {
            String sql13 = "SELECT * FROM CLAIM WHERE PROJECT_ID = ?";

            statement = connection.prepareStatement(sql13);
            statement.setInt(1, projectID);
            rs = statement.executeQuery();

            while (rs.next()) {
                //Vi starter med at hente en blob ud,
                Blob blob = rs.getBlob("IMAGE");
                //Derefter gemmer vi blobens binaryStream i en inputstream variable
                inputStream = blob.getBinaryStream();
                //Derefter laver vi en file som vi kan send til vores servlet
                File tmp = new File("tmp.tmp");
                //Filen laver vi om til en OutputStream så vi kan gemme inputstream i den
                OutputStream out = new FileOutputStream(tmp);
                byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
                int len = 0;
                //her begynder vi at læse fra inputStreamen og gemme det ned i filen.
                //Vi fortsætter med at læse til inputstreamen er -1
                while ((len = inputStream.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                //Her efter lukker vi outputstreamen og inputstreamen, hvorefter vi laver et nyt
                //claim objekt som vi returner.
                out.close();
                inputStream.close();
                claim = new ClaimDTO(rs.getInt("CLAIM_IMAGE_ID"), rs.getInt("PROJECT_ID"), rs.getString("CONTENT_TYPE"), new FileInputStream(tmp));
            }
            return claim;
        }
    }
}
