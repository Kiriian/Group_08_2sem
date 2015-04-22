/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pernille
 */
public class LogInDBCheck
{

    public static boolean validateCheckLogin(String username, String password) throws ClassNotFoundException, SQLException
    {
        try (Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW))
        {
            Class.forName(DB.DRIVER);
            String checkLogin = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

            PreparedStatement statement = connection.prepareStatement(checkLogin);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
           
                if (rs.next())
                {
                    return true;
                }
            
        } catch (SQLException sqle)
        {
            System.err.println(sqle);
        }
        return false;
    }

}
