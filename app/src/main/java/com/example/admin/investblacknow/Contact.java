package com.example.admin.investblacknow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2/18/2018.
 */

public class Contact implements Serializable{
    String Name;
    String Occupation;
    String Image;
    List<String> ContactOptions = new ArrayList<>();

    public Contact(String name, String occupation, String image, List<String> contactOptions){
        this.Name = name;
        this.Occupation = occupation;
        this.Image = image;
        this.ContactOptions = contactOptions;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOccupation() {return Occupation;}

    public void setOccupation(String occupation) {Occupation = occupation;}

    public String getImage() {return Image;}

    public void setImage(String image) {Image = image;}

    public List<String> getContactOptions() {return ContactOptions;}

    public void setContactOptions(List<String> contactOptions) {ContactOptions = contactOptions;}
}
