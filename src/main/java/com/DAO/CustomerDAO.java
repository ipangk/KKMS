package com.DAO;

import com.Model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author irfan
 */
public class CustomerDAO {
    Connection connection = null;
    private final String jdbcURL = "jdbc:mysql://localhost:3306/kkms";
    private final String username = "root";
    private final String password = "";
    
    private static final String SELECT_CUST_ID = "SELECT custName, custContact, custEmail, custUsername FROM customer WHERE custId = ?";
    private static final String UPDATE_CUST = "UPDATE customer SET custName = ?, custContact = ?, custEmail = ?, custUsername = ?, custPass = ? WHERE custId = ?";
    private static final String DELETE_CUST = "DELETE FROM customer WHERE custId = ?";
    
    public CustomerDAO() {
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
    
    public Customer selectCust(int custId) {
        Customer cust = null;
        //Step 1: Establishing a connection
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUST_ID);) {
            preparedStatement.setInt(1, custId);
            System.out.println(preparedStatement);
            //Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //Step 4: Process the ResultSet object
            while (rs.next()) {
                String custName = rs.getString("custName");
                String custContact = rs.getString("custContact");
                String custEmail = rs.getString("custEmail");
                String custUsername = rs.getString("custUsername");
                cust = new Customer(custId, custName, custContact, custEmail, custUsername);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return cust;
    }
    
    public boolean updateCust(Customer cust) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement statement = connection.prepareStatement(UPDATE_CUST);) {
            statement.setString(1, cust.getCustName());
            statement.setString(2, cust.getCustContact());
            statement.setString(3, cust.getCustEmail());
            statement.setString(4, cust.getCustUsername());
            statement.setString(5, cust.getCustPass());
            statement.setInt(6, cust.getCustId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean deleteCust(int custId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement statement = connection.prepareStatement(DELETE_CUST);) {
            statement.setInt(1, custId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }        
    
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
