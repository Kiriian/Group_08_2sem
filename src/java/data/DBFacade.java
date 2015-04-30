/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import control.ClaimDTO;
import control.EmployeeDTO;
import control.ImageDTO;
import control.InvalidDataException;
import control.PartnerDTO;
import control.ProjectDTO;
import control.QuarterDTO;
import control.UserDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author martamiszczyk
 */
public class DBFacade implements IDBFacade {

    Mapper mapper = new Mapper();

    @Override
    public ProjectDTO saveProject(ProjectDTO p) throws InvalidDataException {
        try {
            return mapper.saveProject(p);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }

    }
    
    @Override
    public ArrayList<ProjectDTO> getAllPartnerProjects(String searchCriteria, int partnerID) throws InvalidDataException
    {
        try{
            return mapper.getAllPartnerProjects(searchCriteria, partnerID);
        }catch (SQLException sqle)
        {
            throw new InvalidDataException("" + sqle);
        }
    }
    
    @Override
    public ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws InvalidDataException {
        try {
            return mapper.getAllProjects(searchCriteria);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public ProjectDTO getProject(int projectID) throws InvalidDataException {
        try {
            return mapper.getProject(projectID);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO p) throws InvalidDataException, ParseException {
        try {
            return mapper.updateProject(p);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public void savePartner(PartnerDTO part) throws InvalidDataException {
        try {
            mapper.savePartner(part);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public UserDTO validateCheckLogin(String username, String password) throws InvalidDataException {
        try {
            return mapper.validateCheckLogin(username, password);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public void createUser(UserDTO user) throws InvalidDataException {
        try {
             mapper.createUser(user);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public void createEmployee(EmployeeDTO emp) throws InvalidDataException
    {
       try {
            mapper.createEmployee(emp);
        } catch (SQLException sqle) {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public void uploadPOE(Part file, String contentType, int projectID) throws InvalidDataException
    {
        try
        {
            mapper.uploadPOE(file, contentType, projectID);
        } catch (SQLException | FileNotFoundException ex)
        {
            throw new InvalidDataException("" + ex);
        } catch (IOException ex)
        {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void uploadClaim(Part file, String contentType, int projectID) throws InvalidDataException
    {
        try
        {
            mapper.uploadClaim(file, contentType, projectID);
        } catch (SQLException |FileNotFoundException ex)
        {
            throw new InvalidDataException("" + ex);
        } catch (IOException ex)
        {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void createQuarter(QuarterDTO quarter) throws InvalidDataException{
        try
        {
            mapper.createQuarter(quarter);
        }
        catch(SQLException sqle)
        {
            throw new InvalidDataException("" + sqle);
        }
    }
    
    @Override
    public ArrayList<ImageDTO> getImage(int projectID) throws InvalidDataException
    {
        try
        {
            return mapper.getImage(projectID);
        }
        catch(SQLException | IOException sqle)
        {
            throw new InvalidDataException("" + sqle);
        }
    }

    @Override
    public ClaimDTO getClaim(int projectID) throws InvalidDataException{
        try
        {
            return mapper.getClaim(projectID);
        }
        catch(SQLException | IOException sqle)
        {
            throw new InvalidDataException("" + sqle);
        }
    }
    
    @Override
    public int getProjectIDSequence() throws InvalidDataException
    {
        try
        {
            return mapper.getProjectIDSequence();
        }
        catch(SQLException sqle)
        {
           throw new InvalidDataException("" + sqle); 
        }
    }
}
