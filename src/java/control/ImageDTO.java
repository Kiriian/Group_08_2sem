/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.InputStream;
import javax.servlet.http.Part;

/**
 *
 * @author Jeanette
 */
public class ImageDTO
{
    int imageID;
    int projectID;
    String contentType;
    InputStream inputStream;

    public ImageDTO(int imageID, int projectID, String contentType, InputStream inputStream)
    {
        this.imageID = imageID;
        this.projectID = projectID;
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    
    public int getImageID()
    {
        return imageID;
    }

    public void setImageID(int imageID)
    {
        this.imageID = imageID;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public InputStream getInputStream()
    {
        return inputStream;
    }

    public void setPart(InputStream inputStream)
    {
        this.inputStream = inputStream;
    }
    
    
}
