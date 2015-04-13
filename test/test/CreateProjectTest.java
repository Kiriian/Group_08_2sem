package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import control.Controller;
import control.ProjectDTO;
import static oracle.jdbc.driver.DatabaseError.test;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeanette
 */
public class CreateProjectTest
{
    public Mockery context = new JUnitRuleMockery();
    // The test is testing if the given data is saved in the database.
    
    @Test
    public void setup()
    {
        //Controller control = new Controller();
        ProjectDTO p = context.mock(ProjectDTO.class);
    }

    public CreateProjectTest()
    {

    }

}
