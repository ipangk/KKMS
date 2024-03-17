package com.Model;

/**
 *
 * @author irfan
 */
public class Admin {

    private int adminId;
    private String adminUsername;
    private String adminEmail;
    private String adminPass;
    private boolean adminLogIn;
    //private Portfolio portfolio;

    public Admin() {
    }
    
    public Admin(boolean adminLogIn, int adminId){
        this.adminLogIn = adminLogIn;
        this.adminId = adminId;
    }

    public Admin(String adminUsername, String adminPass) {
        super();
        this.adminUsername = adminUsername;
        this.adminPass = adminPass;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public boolean isAdminLogIn() {
        return adminLogIn;
    }

    public void setAdminLogIn(boolean adminLogIn) {
        this.adminLogIn = adminLogIn;
    }

   

}
