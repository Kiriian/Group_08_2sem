package testGroup8;

import control.ProjectDTO;
import data.DB;
import data.IO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martamiszczyk
 */
public class CreateProjectTest {

    //Class variables: 
    private IO io;
    private static Connection connection;
    private ProjectDTO p;
    private String status;
    private String startDate;
    private String endDate;
    private String currency;
    private String activityDescription;
    private String comments;
    private String targetAudience;
    private String objectiveResult;
    private int PartnerID;
    private String firstname;
    private String lastname;
    private String phone;
    private int projectBudget;

    public CreateProjectTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        //DB connection:

        connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);

    }

    @AfterClass
    public static void tearDownClass() throws SQLException {

        connection.close();

    }

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        //INit class/objecter som man skal bruge til at teste med: 
        io = new IO();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void tc_1_saveProject() throws SQLException, ClassNotFoundException {
        //Bruge metoder i Assert klassen
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt
        //2 Henter man projektet op

        //3) ser om det er der:
        assertEquals("Hans", p.getFirstname());

    }

    @Test
    public void tc_2_saveProject() throws SQLException, ClassNotFoundException {
        //Er det muligt at oprette et projekt uden at indtaste budget
        //Bruge metoder i Assert klassen
        //projectBudget = null;  Int kan ikke være null
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 0;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertEquals("2015-02-10", p.getStartDate());
        assertEquals("2015-02-30", p.getEndDate());
        assertEquals(0, projectBudget);
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals("Events for employees", p.getActivityDescription());
        assertEquals("Tight schedule", p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());
    }

    @Test
    public void tc_3_saveProject() throws SQLException, ClassNotFoundException{
        //Er det muligt at oprette et projekt uden at indtaste activity description
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = null;
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";
        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertEquals("2015-02-10", p.getStartDate());
        assertEquals("2015-02-30", p.getEndDate());
        assertEquals(20000, p.getProjectBudget());
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals(activityDescription, p.getActivityDescription());
        assertEquals("Tight schedule", p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());

    }

    @Test
    public void tc_4_saveProject() throws SQLException, ClassNotFoundException{
        //Er det muligt at oprette et projekt uden start og end date
        status = "Project proposal";
        startDate = null;
        endDate = null;
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertNull(startDate, p.getStartDate());
        assertNull(endDate, p.getEndDate());
        assertEquals(20000, p.getProjectBudget());
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals("Events for employees", p.getActivityDescription());
        assertEquals("Tight schedule", p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());
    }

    @Test
    public void tc_5_saveProject() throws SQLException, ClassNotFoundException {
        // Kan ikke rigtigt test det i JUnittest
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";
        
        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertEquals("2015-02-10", p.getStartDate());
        assertEquals("2015-02-30", p.getEndDate());
        assertEquals(20000, p.getProjectBudget());
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals("Events for employees", p.getActivityDescription());
        assertEquals("Tight schedule", p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());

    }

    @Test
    public void tc_6_saveProject() throws SQLException, ClassNotFoundException {
        //er det muligt at indtaste nonsenstal i budget
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 100000000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertEquals("2015-02-10", p.getStartDate());
        assertEquals("2015-02-30", p.getEndDate());
        assertEquals(100000000, p.getProjectBudget());
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals("Events for employees", p.getActivityDescription());
        assertEquals("Tight schedule", p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());
    }

    @Test
    public void tc_7_saveProject() throws SQLException, ClassNotFoundException {
        //Er det muligt at taste andet end tal og bindestreger i start og end date
        status = "Project proposal";
        startDate = "Hello World";
        endDate = "hej.3";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertEquals("Hello World", p.getStartDate());
        assertEquals("hej.3", p.getEndDate());
        assertEquals(20000, p.getProjectBudget());
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals("Events for employees", p.getActivityDescription());
        assertEquals("Tight schedule", p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());
    }

    @Test
    public void tc_8_saveProject() throws SQLException, ClassNotFoundException {
        //Er det muligt at indtaste lange inddateringer i comments
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "Events for employees";
        comments = "0";
        targetAudience = "Reseller";
        objectiveResult = "More customers";
        comments = "0";

        for (int i = 0; i < 1001; i++) {
            comments = i + "";
        }

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertEquals("2015-02-10", p.getStartDate());
        assertEquals("2015-02-30", p.getEndDate());
        assertEquals(20000, p.getProjectBudget());
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals("Events for employees", p.getActivityDescription());
        assertEquals(comments, p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());
    }

    @Test
    public void tc_9_saveProject() throws SQLException, ClassNotFoundException {
        //Er det muligt at indtaste lange inddateringer i activety description
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        firstname = "Hans";
        lastname = "Hansen";
        phone = "45454545";
        activityDescription = "0";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        for (int i = 0; i < 101; i++) {
            activityDescription = i + "";
        }

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, firstname, lastname, phone, projectBudget);
        io.SaveProject(p); //Gemmer et projekt

        assertEquals("2015-02-10", p.getStartDate());
        assertEquals("2015-02-30", p.getEndDate());
        assertEquals(20000, p.getProjectBudget());
        assertEquals("NOK", p.getCurrency());
        assertEquals(1, p.getPartnerID());
        assertEquals("Hans", p.getFirstname());
        assertEquals("Hansen", p.getLastname());
        assertEquals("45454545", p.getPhone());
        assertEquals(activityDescription, p.getActivityDescription());
        assertEquals("Tight schedule", p.getComments());
        assertEquals("Reseller", p.getTargetAudience());
        assertEquals("More customers", p.getObjectiveResult());
    }

}
