
package control;

/**
 *
 * @author Pernille
 */
public class EmployeeDTO
{
    int employeeID;
    String firstname;
    String lastname;
    String country;
    String employeeType;

    public EmployeeDTO(String firstname, String lastname, String country, String employeeType)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.employeeType = employeeType;
    }

    public EmployeeDTO(int employeeID, String firstname, String lastname, String country, String employeeType) {
        this.employeeID = employeeID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.employeeType = employeeType;
    }
    
    

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getEmployeeType()
    {
        return employeeType;
    }

    public void setEmployeeType(String employeeType)
    {
        this.employeeType = employeeType;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
