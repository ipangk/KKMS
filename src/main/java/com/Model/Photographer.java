package com.Model;

/**
 *
 * @author irfan
 */
public class Photographer {
    private int phId;
    private String phName;
    private String phContact;
    private String phEmail;
    private String phUsername;
    private String phPass;
    private boolean phLogIn;
    
    public Photographer(){        
    }
    
    public Photographer(boolean phLogIn, int phId){
        this.phLogIn = phLogIn;
        this.phId = phId;
    }
    
    public Photographer(int phId, String phName, String phContact, String phEmail, String phUsername, String phPass){
        super();
        this.phId = phId;
        this.phName = phName;
        this.phContact = phContact;
        this.phEmail = phEmail;
        this.phUsername = phUsername;
        this.phPass = phPass;
    }
    
    public Photographer(int phId, String phName, String phContact, String phEmail, String phUsername, String phPass, boolean phLogIn){
        super();
        this.phId = phId;
        this.phName = phName;
        this.phContact = phContact;
        this.phEmail = phEmail;
        this.phUsername = phUsername;
        this.phPass = phPass;
        this.phLogIn = phLogIn;
    }
    
    public Photographer(int phId, String phName, String phContact, String phEmail, String phUsername ){
        super();
        this.phId = phId;
        this.phName = phName;
        this.phContact = phContact;
        this.phEmail = phEmail;
        this.phUsername = phUsername;
    }
    
    public Photographer(String phName, String phContact, String phEmail, String phUsername, String phPass){
        super();
        this.phName = phName;
        this.phContact = phContact;
        this.phEmail = phEmail;
        this.phUsername = phUsername;
        this.phPass = phPass;
    }
    
    public Photographer(String phUsername, String phPass){
        super();
        this.phUsername = phUsername;
        this.phPass = phPass;
    }

    public int getPhId() {
        return phId;
    }

    public void setPhId(int phId) {
        this.phId = phId;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName;
    }

    public String getPhContact() {
        return phContact;
    }

    public void setPhContact(String phContact) {
        this.phContact = phContact;
    }

    public String getPhEmail() {
        return phEmail;
    }

    public void setPhEmail(String phEmail) {
        this.phEmail = phEmail;
    }

    public String getPhUsername() {
        return phUsername;
    }

    public void setPhUsername(String phUsername) {
        this.phUsername = phUsername;
    }

    public String getPhPass() {
        return phPass;
    }

    public void setPhPass(String phPass) {
        this.phPass = phPass;
    }

    public boolean isPhLogIn() {
        return phLogIn;
    }

    public void setPhLogIn(boolean phLogIn) {
        this.phLogIn = phLogIn;
    }
    
    
}
