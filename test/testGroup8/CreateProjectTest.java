package testGroup8;

import control.Controller;
import control.InvalidDataException;
import control.ProjectDTO;
import control.Validator;
import java.sql.Connection;
import java.sql.SQLException;
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
    private ProjectDTO p2;
    private ArrayList<ProjectDTO> projectDTOArray;
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
        //connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);

    }

    @AfterClass
    public static void tearDownClass() throws SQLException
    {

        //connection.close();

    }

    @Before
    public void setUp() throws SQLException
    {
        //INit class/objecter som man skal bruge til at teste med: 
        ctrl = new Controller();
        v = new Validator();
        p = null;
        p2 = null;
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

        v.validator(projectBudget, PartnerID, startDate, endDate, activityDescription, targetAudience, objectiveResult);
        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, projectBudget);
        p2 = ctrl.SaveProject(p);
        Assert.assertEquals(p.getStartDate(), p2.getStartDate());
        Assert.assertEquals(p.getEndDate(), p2.getEndDate());
        Assert.assertEquals(p.getProjectBudget(), p2.getProjectBudget());
        Assert.assertEquals(p.getPartnerID(), p2.getPartnerID());
        Assert.assertEquals(p.getActivityDescription(), p2.getActivityDescription());
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

    @Test
    public void tc_5_saveProject() throws InvalidDataException
    {
        //er det muligt at indtaste "nonsenstal" i budget
        status = "Project proposal";
        startDate = "2015-02-10";
        endDate = "2015-02-28";
        projectBudget = 100000000;
        currency = "NOK";
        PartnerID = 1;
        activityDescription = "Events for employees";
        comments = "Tight schedule";
        targetAudience = "Reseller";
        objectiveResult = "More customers";
        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, projectBudget);
        p2 = ctrl.SaveProject(p);
        Assert.assertEquals(p.getStartDate(), p2.getStartDate());
        Assert.assertEquals(p.getEndDate(), p2.getEndDate());
        Assert.assertEquals(p.getProjectBudget(), p2.getProjectBudget());
        Assert.assertEquals(p.getPartnerID(), p2.getPartnerID());
        Assert.assertEquals(p.getActivityDescription(), p2.getActivityDescription());

    }

    @Test
    public void tc_6_saveProject() throws InvalidDataException
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
            assertThat(ide.getMessage(), is("The date needs to be write in the format: YYYY-MM-DD"));
        }
    }

    @Test
    public void tc_7_saveProject() throws SQLException, ClassNotFoundException
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
    public void tc_8_saveProject() throws SQLException, ClassNotFoundException
    {
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

        for (int i = 0; i < 101; i++)
        {
            activityDescription = i + "";
        }

        p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, PartnerID, projectBudget);
        try
        {
            ctrl.SaveProject(p);
        } catch (InvalidDataException ide)
        {
            assertThat(ide.getMessage(), is("værdi er for stor for kolonnen \"CPHJB190\".\"PROJECT\".\"ACTIVITY_DESCRIPTION\" (faktisk: 1001, maksimum: 1000)"));
        }
    }
}
