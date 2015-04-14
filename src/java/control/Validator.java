/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Jeanette
 */
public class Validator
{

    private String patternLetters = "[a-zA-Z]*";
    private String patternNumbers = "[0-9]*";

    public String validator(int project_budget, int partnerID, String startDate, String endDate, String activityDescription, String targetAudience, String objectiveResult, String firstname, String lastname, String phone) throws InvalidateDataException
    {
        System.err.println("fejl");

        if (project_budget == 0)
        {
            throw new InvalidateDataException("Budget cannot be empty and cannot contain letters");
        }
        if (partnerID == 0)
        {
            throw new InvalidateDataException("PartnerID cannot be empty and cannot contain letters");
        }
        if (activityDescription.equals(""))
        {
            throw new InvalidateDataException("Activity Description cannot be empty");
        }

        if (startDate.matches(patternLetters))
        {
            throw new InvalidateDataException("The date needs to be write in the format: yyyy-mm-dd");
        }

        if (endDate.matches(patternLetters))
        {
            throw new InvalidateDataException("The date needs to be write in the format: yyyy-mm-dd");
        }

        if (targetAudience.matches(patternNumbers))
        {
            throw new InvalidateDataException("Target audience cannot contain numbers");
        }

        if (targetAudience.equals(""))
        {
            throw new InvalidateDataException("Target audience cannot be empty");
        }

        if (objectiveResult.equals(""))
        {
            throw new InvalidateDataException("Objective and result cannot be empty");
        }
        if (firstname.equals(""))
        {
            throw new InvalidateDataException("Firstname cannot be empty");
        }
        if (lastname.equals(""))
        {
            throw new InvalidateDataException("Lastname cannot be empty");
        }
        if (phone.matches(patternLetters))
        {
            throw new InvalidateDataException("Phone cannot contain letters");
        }
        if (phone.equals(""))
        {
            throw new InvalidateDataException("Phone cannot be empty");
        }
        return "";
    }
}
