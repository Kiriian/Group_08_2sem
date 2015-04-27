/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.DBFacade;
import data.Mapper;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Jeanette
 */
public class Controller {

    DBFacade facade = new DBFacade();

    public void SaveProject(ProjectDTO p) throws InvalidDataException {
        facade.saveProject(p);
    }

    public ArrayList<ProjectDTO> getAllPartnerProjects(String searchCriteria, int partnerID) throws InvalidDataException
    {
        return facade.getAllPartnerProjects(searchCriteria, partnerID);
    }
    
    public ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws InvalidDataException {
        return facade.getAllProjects(searchCriteria);
    }

    public ProjectDTO getProjectToChange(int projectID) throws InvalidDataException {
        return facade.getProjectToChange(projectID);
    }

    public ProjectDTO updateProject(ProjectDTO p) throws InvalidDataException, ParseException {
        return facade.updateProject(p);
    }

    public void savePartner(PartnerDTO part) throws InvalidDataException {
        facade.savePartner(part);
    }

    public UserDTO validateCheckLogin(String username, String password) throws InvalidDataException {
        return facade.validateCheckLogin(username, password);
    }

    public void createUser(UserDTO user) throws InvalidDataException {
          facade.createUser(user);
    }

    public void createEmployee(EmployeeDTO emp) throws InvalidDataException
    {
        facade.createEmployee(emp);
    }
    
   
}
