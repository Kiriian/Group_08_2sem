/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import control.InvalidDataException;
import control.PartnerDTO;
import control.ProjectDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author martamiszczyk
 */
interface IDBFacade
{
    void saveProject(ProjectDTO p) throws InvalidDataException;
    
    ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws InvalidDataException;
    
    ProjectDTO getProjectToChange(int projectID) throws InvalidDataException;
    
    ProjectDTO updateProject(ProjectDTO p) throws InvalidDataException, ParseException;
    
    void savePartner(PartnerDTO part) throws InvalidDataException;
    
    boolean validateCheckLogin(String username, String password) throws InvalidDataException;
}
