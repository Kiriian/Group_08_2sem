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
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import javax.servlet.http.Part;

/**
 *
 * @author martamiszczyk
 */
interface IDBFacade
{
    void saveProject(ProjectDTO p) throws InvalidDataException;
    
    ArrayList<ProjectDTO> getAllPartnerProjects(String searchCriteria, int partnerID) throws InvalidDataException;
    
    ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws InvalidDataException;
    
    ProjectDTO getProjectToChange(int projectID) throws InvalidDataException;
    
    ProjectDTO updateProject(ProjectDTO p) throws InvalidDataException, ParseException;
    
    void savePartner(PartnerDTO part) throws InvalidDataException;
    
    UserDTO validateCheckLogin(String username, String password) throws InvalidDataException;
    
   void createUser(UserDTO user) throws InvalidDataException;
   
   void createEmployee(EmployeeDTO emp) throws InvalidDataException;
   
   void uploadPOE(Part file, String contentType, int projectID) throws InvalidDataException;
   
   void uploadClaim(Part file, String contentType, int projectID) throws InvalidDataException;
   
   void createQuarter(QuarterDTO quarter) throws InvalidDataException;
   
   ArrayList<ImageDTO> getImage(int projectID) throws InvalidDataException;
   
   ClaimDTO getClaim(int ProjectID) throws InvalidDataException;
}
