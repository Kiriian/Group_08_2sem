package testGroup8;

import control.Controller;
import control.InvalidDataException;
import control.ProjectDTO;
import control.Validator;
import data.DB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author martamiszczyk
 */
public class CreateProjectTest
{

    //Class variables: 
    private static Connection connection;
    private Validator v;
    private Controller ctrl;
    private ProjectDTO p;
    private ArrayList<ProjectDTO> projectDTOArray;
    private int projectID;
    private String status;
    private String startDate;
    private String endDate;
    private String currency;
    private String activityDescription;
    private String comments;
    private String targetAudience;
    private String objectiveResult;
    private int PartnerID;
    private int projectBudget;

    public CreateProjectTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException
    {
        //DB connection:
        connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);

    }

    @AfterClass
    public static void tearDownClass() throws SQLException
    {

        connection.close();

    }

    @Before
    public void setUp() throws SQLException
    {
        //INit class/objecter som man skal bruge til at teste med: 
        ctrl = new Controller();
        v = new Validator();
        projectDTOArray = new ArrayList<>();
        Statement statement = connection.createStatement();
        boolean isScriptExecuted = false;
        try
        {
            File tmp = new File("src/conf/TestSaveProject.sql");
            BufferedReader in = new BufferedReader(new FileReader("src/conf/TestSaveProject.sql"));
            String str;
            StringBuffer sb = new StringBuffer();
            while ((str = in.readLine()) != null)
            {
                sb.append(str + "\n ");
            }
            in.close();
            statement.executeUpdate(sb.toString());
            isScriptExecuted = true;
        } catch (Exception e)
        {
            e.printStackTrace();
//            System.err.println("Failed to Execute" + "TestSaveProject.sql" + ". The error is" + e.getMessage());
        }
    }

    @After
    public void tearDown()
    {

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void tc_1_saveProject() throws InvalidDataException
    {
        //Is it possible to make a project with all the attributes
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-03-10";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, projectBudget);
        ctrl.SaveProject(p);
        projectDTOArray = ctrl.getAllProjects(status);

        for (ProjectDTO p2 : projectDTOArray)
        {
            Assert.assertEquals(1, projectDTOArray.size());
        }
    }

    @Test
    public void tc_2_saveProject() throws InvalidDataException
    {
        //Er det muligt at oprette et projekt uden at indtaste budget
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        currency = "NOK";
        PartnerID = 1;
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        try
        {
            v.validator(projectBudget, PartnerID, startDate, endDate, activityDescription, targetAudience, objectiveResult);
        } catch (InvalidDataException ide)
        {
            assertThat(ide.getMessage(), is("Budget cannot be empty"));
        }
    }

    @Test
    public void tc_3_saveProject() throws SQLException, ClassNotFoundException, InvalidDataException
    {
        //Er det muligt at oprette et projekt uden at indtaste activity description
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        activityDescription = "";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        try
        {
            v.validator(projectBudget, PartnerID, startDate, endDate, activityDescription, targetAudience, objectiveResult);
        } catch (InvalidDataException ide)
        {
            assertThat(ide.getMessage(), is("Activity description cannot be empty"));
        }
    }

    @Test
    public void tc_4_saveProject() throws InvalidDataException
    {
        //Er det muligt at oprette et projekt uden start og end date
        status = "Project proposal";
        projectBudget = 20000;
        startDate = "";
        endDate = "";
        currency = "NOK";
        PartnerID = 1;
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        try
        {
            v.validator(projectBudget, PartnerID, startDate, endDate, activityDescription, targetAudience, objectiveResult);
        } catch (InvalidDataException ide)
        {
            assertThat(ide.getMessage(), is("The date cannot be empty"));
        }
    }

//    @Test
//    public void tc_5_saveProject() throws SQLException, ClassNotFoundException {
//        // Kan ikke rigtigt test det i JUnittest
//        status = "Project proposal";
//        startDate = "2015-02-10";
//        endDate = "2015-02-30";
//        projectBudget = 20000;
//        currency = "NOK";
//        PartnerID = 1;
//        activityDescription = "Events for employees";
//        comments = "Tight schedule";
//        targetAudience = "Reseller";
//        objectiveResult = "More customers";
//        
//}
//
    @Test
    public void tc_6_saveProject() throws InvalidDataException
    {
        //er det muligt at indtaste nonsenstal i budget
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 100000000;
        currency = "NOK";
        PartnerID = 1;
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, projectBudget);
        ctrl.SaveProject(p);
        ctrl.getAllProjects(status);

        for (ProjectDTO p2 : projectDTOArray)
        {
            Assert.assertEquals(1, p2.getProjectID());
            Assert.assertEquals(100000000, p2.getProjectBudget());
        }
    }

    @Test
    public void tc_7_saveProject() throws InvalidDataException
    {
        //Er det muligt at taste andet end tal og bindestreger i start og end date
        status = "Project proposal";
        startDate = "Hello World";
        endDate = "hej.3";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";
        try
        {
            v.validator(projectBudget, PartnerID, startDate, endDate, activityDescription, targetAudience, objectiveResult);
        } catch (InvalidDataException ide)
        {
            assertThat(ide.getMessage(), is("The date needs to be write in the format: YYYY-MM-DD0"));
        }
    }

    @Test
    public void tc_8_saveProject() throws SQLException, ClassNotFoundException
    {
        //Er det muligt at indtaste lange inddateringer i comments
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-30";
        projectBudget = 20000;
        currency = "NOK";
        PartnerID = 1;
        activityDescription = "Events for employees";
        comments = "0";
        targetAudience = "Reseller";
        objectiveResult = "More customers";
        comments = "0";

        for (int i = 0; i < 1001; i++)
        {
            comments = i + "";
        }

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, projectBudget);
        try
        {
            ctrl.SaveProject(p);
        } catch (InvalidDataException ide)
        {
            assertThat(ide.getMessage(), is("værdi er for stor for kolonnen \"CPHJB190\".\"PROJECT\".\"COMMENTS\" (faktisk: 1001, maksimum: 1000)"));
        }
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
        activityDescription = "0";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";

        for (int i = 0; i < 101; i++) {
            activityDescription = i + "";
        }

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, projectBudget);
        try
        {
            ctrl.SaveProject(p);
        }
        catch(InvalidDataException ide)
        {
            assertThat(ide.getMessage(), is("værdi er for stor for kolonnen \"CPHJB190\".\"PROJECT\".\"ACTIVITY_DESCRIPTION\" (faktisk: 1001, maksimum: 1000)"));
        }
    }
}
