package com.DAO;

import com.Model.Admin;
import com.Model.Customer;
import com.Model.Photographer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author irfan
 */
public class LoginUserDAO {

    Connection connection = null;
    private final String jdbcURL = "jdbc:mysql://localhost:3306/kkms";
    private final String username = "root";
    private final String password = "";

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (custName, custContact, custEmail, custUsername, custPass) VALUES"
            + "(?, ?, ?, ? ,?);";
    private static final String LOGIN_ADMIN = "SELECT AdminId, AdminName, AdminPass FROM admin";
    private static final String LOGIN_PH = "SELECT phId, phName, phContact, phEmail, phUsername, phPass FROM photographer";
    private static final String LOGIN_CUST = "SELECT custId, custUsername, custPass FROM customer";
    private static final String CHECK_CUST = "SELECT custUsername FROM customer";

    public LoginUserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public Customer checkCust(String custUsername) throws SQLException{
        boolean approve;
        Customer cust = null;
        try (Connection connection = getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_CUST);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String custName = rs.getString("custUsername");
                System.out.println(custUsername +" (1 True)");
                // Check if the entered credentials match the current admin
                if (custUsername.equals(custName)) {
                    approve = false;
                    cust = new Customer(approve,custName);
                    System.out.println(custUsername +" (2 False)");
                    break;  // Exit the loop if credentials are correct
                }else{
                    approve = true;
                    cust = new Customer(approve,custName);
                    System.out.println(custUsername +" (3 True)");
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } // The try-with-resources will automatically close the connection and statement
        
        return cust;
    }

    public void insertCust(Customer cust) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement
                = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, cust.getCustName());
            preparedStatement.setString(2, cust.getCustContact());
            preparedStatement.setString(3, cust.getCustEmail());
            preparedStatement.setString(4, cust.getCustUsername());
            preparedStatement.setString(5, cust.getCustPass());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        
    }

    public Admin loginAdmin(String username, String password) throws SQLException {
        Admin admin = null;
        boolean approve = false;

        try (Connection connection = getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_ADMIN);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String adminName = rs.getString("AdminName");
                String adminPass = rs.getString("AdminPass");
                // Check if the entered credentials match the current admin
                if (username.equals(adminName) && password.equals(adminPass)) {
                    approve = true;
                    int adminId = rs.getInt("AdminId");
                    admin = new Admin(approve,adminId);
                    break;  // Exit the loop if credentials are correct
                }
                else if(!(username.equals(adminName)) || !(password.equals(adminPass))){
                    admin = new Admin(approve = false,0);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } // The try-with-resources will automatically close the connection and statement
        
        return admin;
    }
    
    public Photographer loginPh(String username, String password) throws SQLException {
        Photographer ph = null;        
        boolean approve = false;
        
        try (Connection connection = getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_PH);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String phUsername = rs.getString("phUsername");
                String phPass = rs.getString("phPass");
                // Check if the entered credentials match the current admin
                if (username.equals(phUsername) && password.equals(phPass)) {
                    approve = true;
                    int phId = rs.getInt("phId");
                    String phName = rs.getString("phName");
                    String phEmail = rs.getString("phEmail");
                    String phContact = rs.getString("phContact");
                    ph = new Photographer(phId, phName, phContact, phEmail, phUsername, phPass,approve);
                    break;  // Exit the loop if credentials are correct
                }
                else if(!(username.equals(phUsername)) || !(password.equals(phPass))){
                    ph = new Photographer(0, "-", "-", "-", phUsername, phPass,approve = false);
                }
                
            }
        } catch (SQLException e) {
            printSQLException(e);
        } // The try-with-resources will automatically close the connection and statement
        
        return ph;
    }
    
    public Customer loginCust(String username, String password) throws SQLException {
        Customer cust = null;
        boolean approve = false;

        try (Connection connection = getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_CUST);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String custName = rs.getString("custUsername");
                String custPass = rs.getString("custPass");
                // Check if the entered credentials match the current admin
                if (username.equals(custName) && password.equals(custPass)) {
                    approve = true;
                    int custId = rs.getInt("custId");
                    cust = new Customer(approve,custId);
                    break;  // Exit the loop if credentials are correct
                }
                else if(!(username.equals(custName)) || !(password.equals(custPass))){
                    cust = new Customer(approve = false,0);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } // The try-with-resources will automatically close the connection and statement
        
        return cust;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState:" + ((SQLException) e).getSQLState());
                System.err.println("Error Code:" + ((SQLException) e).getErrorCode());
                System.err.println("Message:" + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
            }
        }
    }
}
