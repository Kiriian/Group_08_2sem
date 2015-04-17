package control;

import java.io.Serializable;


/**
 *
 * @author Jeanette
 */
public class ProjectDTO implements Serializable
{
    private String status;
    private String startDate;
    private String endDate;
    private String currency;
    private String activityDescription;
    private String comments;
    private String targetAudience;
    private String objectiveResult;
    private int partnerID;
    private String firstname;
    private String lastname;
    private String phone;
    private int projectBudget;
    private int cost;
    private String requiredPOE;
    private int employeeID;
    private int projectID;
    private String quarter;

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public void setActivityDescription(String activityDescription)
    {
        this.activityDescription = activityDescription;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public void setTargetAudience(String targetAudience)
    {
        this.targetAudience = targetAudience;
    }

    public void setObjectiveResult(String objectiveResult)
    {
        this.objectiveResult = objectiveResult;
    }

    public void setPartnerID(int partnerID)
    {
        this.partnerID = partnerID;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setProjectBudget(int projectBudget)
    {
        this.projectBudget = projectBudget;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    public void setRequiredPOE(String requiredPOE)
    {
        this.requiredPOE = requiredPOE;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public void setProjectID(int projectID)
    {
        this.projectID = projectID;
    }

    public void setQuarter(String quarter)
    {
        this.quarter = quarter;
    }

    public ProjectDTO(String status, String startDate, String endDate, String currency, String activityDescription, String comments, String targetAudience, String objectiveResult, int partnerID, String firstname, String lastname, String phone, int projectBudget)
    {
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.activityDescription = activityDescription;
        this.comments = comments;
        this.targetAudience = targetAudience;
        this.objectiveResult = objectiveResult;
        this.partnerID = partnerID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.projectBudget = projectBudget;
    }

    public ProjectDTO(String status, String startDate, String endDate, String currency, String activityDescription, String comments, String targetAudience, String objectiveResult, int partnerID, int projectBudget, int cost, String requiredPOE, int employeeID, int projectID, String quarter)
    {
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.activityDescription = activityDescription;
        this.comments = comments;
        this.targetAudience = targetAudience;
        this.objectiveResult = objectiveResult;
        this.partnerID = partnerID;
        this.projectBudget = projectBudget;
        this.cost = cost;
        this.requiredPOE = requiredPOE;
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.quarter = quarter;
    }

    public int getCost()
    {
        return cost;
    }

    public String getRequiredPOE()
    {
        return requiredPOE;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public int getProjectID()
    {
        return projectID;
    }

    public String getQuarter()
    {
        return quarter;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public String getCurrency()
    {
        return currency;
    }

    public String getActivityDescription()
    {
        return activityDescription;
    }

    public String getComments()
    {
        return comments;
    }

    public String getTargetAudience()
    {
        return targetAudience;
    }

    public String getObjectiveResult()
    {
        return objectiveResult;
    }

    public int getPartnerID()
    {
        return partnerID;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getPhone()
    {
        return phone;
    }

    public int getProjectBudget()
    {
        return projectBudget;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        return "ProjectDTO{" + "status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + ", currency=" + currency + ", activityDescription=" + activityDescription + ", comments=" + comments + ", targetAudience=" + targetAudience + ", objectiveResult=" + objectiveResult + ", partnerID=" + partnerID + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", projectBudget=" + projectBudget + ", cost=" + cost + ", requiredPOE=" + requiredPOE + ", employeeID=" + employeeID + ", projectID=" + projectID + ", quarter=" + quarter + '}';
    }

}
