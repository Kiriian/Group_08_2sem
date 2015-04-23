/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Junes
 */
public class UserValidator {

    public String userValidator(
            String firstname,
            String lastname,
            String username,
            String password,
            String repeatPassword,
            int partnerID,
            int employeeID) throws InvalidDataException {
        try {
            if (firstname.isEmpty()) {
                throw new InvalidDataException("Firstname cannot be empty");

            }
            if (lastname.isEmpty()) {
                throw new InvalidDataException("Lastname cannot be empty");
            }
            if (username.isEmpty()) {
                throw new InvalidDataException("Username cannot be empty ");
            }
            if (password.isEmpty()) {
                throw new InvalidDataException("Password cannot be empty");
            }
            if (repeatPassword.isEmpty()) {
                throw new InvalidDataException("RepeatPassword cannot be empty");
            }
            String checkPartnerID = partnerID + "";
            if (checkPartnerID.isEmpty()) {
                throw new InvalidDataException("PartnerID cannot be empty");
            }
            String checkEmployeeID = employeeID + "";
            if (checkEmployeeID.isEmpty()) {
                throw new InvalidDataException("EmployeeID cannot be empty");
            }
            if (password.equals(repeatPassword)) {
                throw new InvalidDataException("Password and RepeatPassword is not the same");
            }
            if (partnerID != 0 && employeeID != 0) {
                throw new InvalidDataException(
                        "Enter partnerID only if the user is a partner else 0,"
                        + "Enter EmployeeID only if the user is a Dell Employee else 0");
            }
            if (partnerID == 0 && employeeID == 0) {
                throw new InvalidDataException(
                        "Enter partnerID only if the user is a partner else 0,"
                        + "Enter EmployeeID only if the user is a Dell Employee else 0");
            }

            return "";

        } catch (InvalidDataException ide) {
            throw ide;
        }

    }
}
