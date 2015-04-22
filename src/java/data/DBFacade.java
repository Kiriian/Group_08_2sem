/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import control.ProjectDTO;

/**
 *
 * @author martamiszczyk
 */
public class DBFacade implements IDBFacade
{
    public void SaveProject(ProjectDTO p) throws ClassNotFoundException{
    IO io = new IO();
    io.SaveProject(p);
    }
    
}
