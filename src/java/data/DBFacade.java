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
public class DBFacade implements IDBFacade
{

    Mapper mapper = new Mapper();

    @Override
    public void saveProject(ProjectDTO p) throws InvalidDataException
    {
        try
        {
            mapper.saveProject(p);
        } catch (SQLException sqle)
        {
            throw new InvalidDataException(""+sqle);
        }

    }

    @Override
    public ArrayList<ProjectDTO> getAllProjects(String searchCriteria) throws InvalidDataException
    {
        try
        {
            return mapper.getAllProjects(searchCriteria);
        } catch (SQLException sqle)
        {
            throw new InvalidDataException(""+sqle);
        }
    }

    @Override
    public ProjectDTO getProjectToChange(int projectID) throws InvalidDataException
    {
        try
        {
            return mapper.getProjectToChange(projectID);
        } catch (SQLException sqle)
        {
            throw new InvalidDataException(""+sqle);
        }
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO p) throws InvalidDataException, ParseException
    {
        try
        {
            return mapper.updateProject(p);
        } catch (SQLException sqle)
        {
            throw new InvalidDataException(""+sqle);
        }
    }

    @Override
    public void savePartner(PartnerDTO part) throws InvalidDataException
    {
        try
        {
            mapper.savePartner(part);
        } catch (SQLException sqle)
        {
            throw new InvalidDataException(""+sqle);
        }
    }

    @Override
    public boolean validateCheckLogin(String username, String password) throws InvalidDataException
    {
        try
        {
            return mapper.validateCheckLogin(username, password);
        } catch (SQLException sqle)
        {
            throw new InvalidDataException(""+sqle);
        }
    }

}
