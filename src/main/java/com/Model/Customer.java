package com.Model;

/**
 *
 * @author irfan
 */
public class Customer {
    private int custId;
    private String custName;
    private String custContact;
    private String custEmail;
    private String custUsername;
    private String custPass;
    private boolean custLogIn;
    
    public Customer(){        
    }
    
    public Customer(boolean custLogIn, int custId){
        this.custLogIn = custLogIn;
        this.custId = custId;
    }
    
    public Customer(boolean custLogIn, String custUsername){
        this.custLogIn = custLogIn;
        this.custUsername = custUsername;
    }
    
    public Customer(String custUsername){
        super();
        this.custUsername = custUsername;
    }
    
    public Customer(String custUsername, String custPass){
        super();
        this.custUsername = custUsername;
        this.custPass = custPass;
    }
    
    public Customer(int custId, String custName, String custContact, String custEmail, String custUsername ){
        super();
        this.custId = custId;
        this.custName = custName;
        this.custContact = custContact;
        this.custEmail = custEmail;
        this.custUsername = custUsername;
    }
    
    public Customer(String custName, String custContact, String custEmail, String custUsername, String custPass ){
        super();
        this.custName = custName;
        this.custContact = custContact;
        this.custEmail = custEmail;
        this.custUsername = custUsername;
        this.custPass = custPass;
    }
    
    public Customer(int custId, String custName, String custContact, String custEmail, String custUsername, String custPass ){
        super();
        this.custId = custId;
        this.custName = custName;
        this.custContact = custContact;
        this.custEmail = custEmail;
        this.custUsername = custUsername;
        this.custPass = custPass;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    public String getCustPass() {
        return custPass;
    }

    public void setCustPass(String custPass) {
        this.custPass = custPass;
    }

    public boolean isCustLogIn() {
        return custLogIn;
    }

    public void setCustLogIn(boolean custLogIn) {
        this.custLogIn = custLogIn;
    }


    
    
}
