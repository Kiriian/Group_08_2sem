/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.DBFacade;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import javax.servlet.http.Part;

/**
 *
 * @author Jeanette
 */
public class Controller {

    DBFacade facade = new DBFacade();

    public ProjectDTO SaveProject(ProjectDTO p) throws InvalidDataException {
        return facade.saveProject(p);
    }

    public ArrayList<ProjectDTO> getAllPartnerProjects(String searchCriteria, int partnerID) throws InvalidDataException {
        return facade.getAllPartnerProjects(searchCriteria, partnerID);
    }

    public ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws InvalidDataException {
        return facade.getAllProjects(searchCriteria);
    }

    public ProjectDTO getProject(int projectID) throws InvalidDataException {
        return facade.getProject(projectID);
    }

    public ProjectDTO updateProject(ProjectDTO p) throws InvalidDataException, ParseException {
        return facade.updateProject(p);
    }

    public PartnerDTO savePartner(PartnerDTO part) throws InvalidDataException {
        return facade.savePartner(part);
    }

    public UserDTO validateCheckLogin(String username, String password) throws InvalidDataException {
        return facade.validateCheckLogin(username, password);
    }

    public UserDTO createUser(UserDTO user) throws InvalidDataException {
        return facade.createUser(user);
    }

    public EmployeeDTO createEmployee(EmployeeDTO emp) throws InvalidDataException {
        return facade.createEmployee(emp);
    }

    public void uploadPOE(Part file, String contentType, int projectID) throws InvalidDataException {
        facade.uploadPOE(file, contentType, projectID);
    }

    public void uploadClaim(Part file, String contentType, int projectID) throws InvalidDataException {
        facade.uploadClaim(file, contentType, projectID);
    }

    public QuarterDTO createQuarter(QuarterDTO quarter) throws InvalidDataException {
        return facade.createQuarter(quarter);
    }

    public ArrayList<ImageDTO> getImage(int projectID) throws InvalidDataException {
        return facade.getImage(projectID);
    }

    public ClaimDTO getClaim(int projectID) throws InvalidDataException {
        return facade.getClaim(projectID);
    }

    public int getProjectIDSequence() throws InvalidDataException {
        return facade.getProjectIDSequence();
    }
}
