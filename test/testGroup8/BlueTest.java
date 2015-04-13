/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testGroup8;

import data.IO;
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
public class BlueTest
{
    //Class variables: 
    private IO io;
    
    
    public BlueTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        //DB connection:
        
    }
    
    @AfterClass
    public static void tearDownClass()
    {
        //Tear down db conn:
    }
    
    @Before
    public void setUp()
    {
        //INit class/objecter som man skal bruge til at teste med: 
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
     public void tc_1_saveProject() {
         //Bruge metoder i Assert klassen
          io.SaveProject(null); //Gemmer et projekt
          //2 Henter man projektet op
          
          //3) ser om det er der:
          assertTrue(            );
          
     }

 @Test
     public void hello1() {}


 @Test
     public void hello2() {}

}
