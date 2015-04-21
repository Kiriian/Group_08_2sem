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
public class PartnerDTO
{
    private int partnerID;
    private String country;
    private String partnerName;
    private String partnerType;

    public PartnerDTO(String country, String partnerName, String partnerType)
    {
        this.country = country;
        this.partnerName = partnerName;
        this.partnerType = partnerType;
    }

        
    public PartnerDTO(int partnerID, String country, String partnerName, String partnerType)
    {
        this.partnerID = partnerID;
        this.country = country;
        this.partnerName = partnerName;
        this.partnerType = partnerType;
    }

    public int getPartnerID()
    {
        return partnerID;
    }

    public void setPartnerID(int partnerID)
    {
        this.partnerID = partnerID;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getPartnerName()
    {
        return partnerName;
    }

    public void setPartnerName(String partnerName)
    {
        this.partnerName = partnerName;
    }

    public String getPartnerType()
    {
        return partnerType;
    }

    public void setPartnerType(String partnerType)
    {
        this.partnerType = partnerType;
    }

    @Override
    public String toString()
    {
        return "PartnerDTO{" + "partnerID=" + partnerID + ", country=" + country + ", partnerName=" + partnerName + ", partnerType=" + partnerType + '}';
    }
    
    
}
