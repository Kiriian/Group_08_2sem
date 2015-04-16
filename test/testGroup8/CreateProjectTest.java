/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class CreateProjectTest
{
    
    //Class variables: 
    private IO io;
    private static Connection connection;
    private ProjectDTO p;
    private String status = "PENDING";
    private String startDate = "2015-04-10";
    private String endDate = "2015-04-30";
    private String currency = "NOK";
    private String activityDescription = "se næste input";
    private String comments = "se næste næste input";
    private String targetAudience = "resellers";
    private String objectiveResult = "more customers";
    private int PartnerID = 1;
    private String firstname =  "Hans";
    private String lastname = "Hansen";
    private String phone = "45454545";
    private int projectBudget = 1;
    
    
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
    public void setUp() throws ClassNotFoundException, SQLException
    {
        //INit class/objecter som man skal bruge til at teste med: 
        
        p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
        io = new IO();
       
        
    }
    
    @After
    public void tearDown()
    {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void tc_1_saveProject() throws SQLException {
         //Bruge metoder i Assert klassen
          io.SaveProject(p); //Gemmer et projekt
          //2 Henter man projektet op
          
          //3) ser om det er der:
          assertEquals("Hans", p.getFirstname());
          
     }
     
          @Test
     public void tc_2_saveProject() throws SQLException {
         //Bruge metoder i Assert klassen
         //projectBudget = null;  Int kan ikke være null
         projectBudget = 0;
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
         
          assertEquals("Hans", p.getFirstname());
          
     }

               @Test
     public void tc_3_saveProject() throws SQLException {
        
         activityDescription = null;
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
          
          
          
     }
       @Test
     public void tc_4_saveProject() throws SQLException {
        
         startDate=null;
         endDate=null;
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
}
     @Test
     public void tc_5_saveProject() throws SQLException {
        
         
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
          
          
          
}
       @Test
     public void tc_6_saveProject() throws SQLException {
        
         projectBudget = 100000000;
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
}
     
       @Test
     public void tc_7_saveProject() throws SQLException {
        
         startDate = "Hello World";
         endDate = "hej.3";
                
         
         
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
}
      @Test
     public void tc_8_saveProject() throws SQLException {
        
         comments="0";
         
          for (int i = 0; i < 1001; i++) {
              comments = i+"";
              
          }
         
         
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
}
     @Test
     public void tc_9_saveProject() throws SQLException {
        
         activityDescription="0";
         
          for (int i = 0; i < 101; i++) {
              activityDescription = i+"";
              
          }
         
         
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
}
       @Test
     public void tc_10_saveProject() throws SQLException {
        
         activityDescription="0";
         
          for (int i = 0; i < 101; i++) {
              activityDescription = i+"";
              
          }
         
         
         p = new ProjectDTO (status,startDate,endDate,currency,activityDescription,comments,targetAudience,objectiveResult,PartnerID,firstname,lastname,phone,projectBudget);
          io.SaveProject(p); //Gemmer et projekt
          
          assertEquals("Hans", p.getFirstname());
}
}
