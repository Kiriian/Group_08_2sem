/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Logger;

/**
 *
 * @author Junes
 */
public class UserDTO {
    int userID;
    String username;
    String password;
    int partnerID;
    int employeeID;
    String firstname;
    String lastname;
    String userType;

    public UserDTO(int userID, String username, String password, int partnerID, int employeeID, String firstname, String lastname, String userType)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.partnerID = partnerID;
        this.employeeID = employeeID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userType = userType;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    

    public UserDTO(String username, String password, int partnerID, int employeeID, String firstname, String lastname, String userType) {
        this.username = username;
        this.password = password;
        this.partnerID = partnerID;
        this.employeeID = employeeID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userType = userType;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}