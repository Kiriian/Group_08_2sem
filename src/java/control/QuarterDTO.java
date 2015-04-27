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
public class QuarterDTO {
    private String quarterName;
    private int quarterBudget;

    public QuarterDTO(String quarterName, int quarterBudget) {
        this.quarterName = quarterName;
        this.quarterBudget = quarterBudget;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public int getQuarterBudget() {
        return quarterBudget;
    }

    public void setQuarterBudget(int quarterBudget) {
        this.quarterBudget = quarterBudget;
    }
}
