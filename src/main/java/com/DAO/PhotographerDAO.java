package com.DAO;

import com.Model.Photographer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irfan
 */
public class PhotographerDAO {
    
    Connection connection = null;
    private final String jdbcURL = "jdbc:mysql://localhost:3306/kkms";
    private final String username = "root";
    private final String password = "";
    
    private static final String INSERT_PH = "INSERT INTO photographer (phName, phContact, phEmail, phUsername, phPass) VALUES (?,?,?,?,?);";
    private static final String SELECT_PH_ID = "SELECT phName, phContact, phEmail, phUsername FROM photographer WHERE phId = ?";
    private static final String SELECT_ALL_PH ="SELECT phId, phName, phContact, phEmail, phUsername FROM photographer";
    private static final String UPDATE_PH = "UPDATE photographer SET phName = ?, phContact = ?, phEmail = ?, phUsername = ? WHERE phId = ?";
    private static final String UPDATE_PH_PH = "UPDATE photographer SET phName = ?, phContact = ?, phEmail = ?, phUsername = ?, phPass = ? WHERE phId = ?";
    private static final String DELETE_PH = "DELETE FROM photographer WHERE phId = ?";
    public PhotographerDAO() {
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
    
    public void insertPh(Photographer ph) throws SQLException {
        System.out.println(INSERT_PH);
        //try with resources statement will autoclose the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PH)) {
            preparedStatement.setString(1, ph.getPhName());
            preparedStatement.setString(2, ph.getPhContact());
            preparedStatement.setString(3, ph.getPhEmail());
            preparedStatement.setString(4, ph.getPhUsername());
            preparedStatement.setString(5, ph.getPhContact());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Photographer selectPh(int phId) {
        Photographer ph = null;
        //Step 1: Establishing a connection
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PH_ID);) {
            preparedStatement.setInt(1, phId);
            System.out.println(preparedStatement);
            //Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //Step 4: Process the ResultSet object
            while (rs.next()) {
                String phName = rs.getString("phName");
                String phContact = rs.getString("phContact");
                String phEmail = rs.getString("phEmail");
                String phUsername = rs.getString("phUsername");
                ph = new Photographer(phId, phName, phContact, phEmail, phUsername);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ph;
    }
    
    public List<Photographer> selectAllPh() {
        //using try-with-resources to avoid closing resurces(boiler plate code)
        List<Photographer> ph = new ArrayList<>();
        //Step 1: Establishing a connection
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PH);) {
            System.out.println(preparedStatement);
            //Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //Step 4: process the resultset object
            while (rs.next()) {
                int phId = rs.getInt("phId");
                String phName = rs.getString("phName");                
                String phContact = rs.getString("phContact");
                String phEmail = rs.getString("phEmail");
                String phUsername = rs.getString("phUsername");
                ph.add(new Photographer(phId, phName, phContact, phEmail, phUsername));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ph;
    }
    
    public boolean updatePh(Photographer ph) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement statement = connection.prepareStatement(UPDATE_PH);) {
            statement.setString(1, ph.getPhName());
            statement.setString(2, ph.getPhContact());
            statement.setString(3, ph.getPhEmail());
            statement.setString(4, ph.getPhUsername());
            statement.setInt(5, ph.getPhId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean updatePhPh(Photographer ph) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement statement = connection.prepareStatement(UPDATE_PH_PH);) {
            statement.setString(1, ph.getPhName());
            statement.setString(2, ph.getPhContact());
            statement.setString(3, ph.getPhEmail());
            statement.setString(4, ph.getPhUsername());
            statement.setString(5, ph.getPhPass());
            statement.setInt(6, ph.getPhId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean deletePh(int phId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); //Step 2: Create a statement using connecton object
                 PreparedStatement statement = connection.prepareStatement(DELETE_PH);) {
            statement.setInt(1, phId);
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
