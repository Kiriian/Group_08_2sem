/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.InputStream;

/**
 *
 * @author Jeanette
 */
public class ClaimDTO {
    int claimImageID;
    int projectID;
    String contentType;
    InputStream inputStream;

    public ClaimDTO(int claimImageID, int projectID, String contentType, InputStream inputStream) {
        this.claimImageID = claimImageID;
        this.projectID = projectID;
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    public int getClaimImageID() {
        return claimImageID;
    }

    public void setClaimImageID(int claimImageID) {
        this.claimImageID = claimImageID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
