package com.example.admin.investblacknow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2/18/2018.
 */

public class Contact implements Serializable{
    private String Name;
    private String Occupation;
    private String Image;
    private String Email;
    private String Password;
    private int Commission;
    private String ID;
    private boolean Paid;
    private List<String> ContactOptions = new ArrayList<>();

    public Contact(String name, String occupation, String image, String email, String password, int commission, String id, boolean paid, List<String> contactOptions){
        this.Name = name;
        this.Occupation = occupation;
        this.Image = image;
        this.Email = email;
        this.Password = password;
        this.Commission = commission;
        this.ID = id;
        this.Paid = paid;
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

    public String getEmail() {return Email;}

    public void setEmail(String email) {Email = email;}

    public String getPassword() {return Password;}

    public void setPassword(String password) {Password = password;}

    public int getCommission() {return Commission;}

    public void setCommission(int commission) {Commission = commission;}

    public String getID() {return ID;}

    public void setID(String ID) {this.ID = ID;}

    public boolean isPaid() {return Paid;}

    public void setPaid(boolean paid) {Paid = paid;}

    public String getImage() {return Image;}

    public void setImage(String image) {Image = image;}

    public List<String> getContactOptions() {return ContactOptions;}

    public void setContactOptions(List<String> contactOptions) {ContactOptions = contactOptions;}
}
