/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.IO;
import java.sql.SQLException;

/**
 *
 * @author Jeanette
 */
public class Controller
{
        IO io = new IO();
    public void CreateProject( ProjectDTO p) throws ClassNotFoundException, SQLException
    {
        io.SaveProject(p);
    }
}
