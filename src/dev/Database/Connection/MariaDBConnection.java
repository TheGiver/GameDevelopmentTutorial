package dev.Database.Connection;

import java.sql.*;

public class MariaDBConnection {

    /* Defining needed attributes for setting up the connection */
    private final String DB_URL = "jdbc:mariadb://fa32.host.cs.st-andrews.ac.uk/fa32_GUI";
    private final String USERNAME = "fa32";
    private final String PASSWORD = "DF3600Dpx4.UcK";

    /* Informing the user that connection is being established */
    private final String CONNECTING_MESSAGE = "CONNECTING TO DATABASE";
    private final String CONNECTION_ESTABLISHED_MESSAGE = "Connection established";

    /* List of error messages to be printed to the user/system */
    private final String SQL_EXCEPTION_ERROR_MESSAGE = "SQL Exception: ";
    private final String MESSAGE_SEPARATOR = "---------------------------------------- \n";
    private final String CONNECTION_ERROR_MESSAGE = "Connection Error: Failure to Connect to Database";

    //****************************************************************************************************************//

    public Connection establishConnection() {
        Connection databaseConnection = null;

        try {
            System.out.println(CONNECTING_MESSAGE);

            //Trying to establish a connection with mariadb
            databaseConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            //to be printed to system stderr
            System.err.println(SQL_EXCEPTION_ERROR_MESSAGE + e.getMessage());
            System.err.println(MESSAGE_SEPARATOR);

            //to be printed to user
            System.out.println(CONNECTION_ERROR_MESSAGE);
        }

        System.out.println(CONNECTION_ESTABLISHED_MESSAGE);
        return databaseConnection;
    }


}
