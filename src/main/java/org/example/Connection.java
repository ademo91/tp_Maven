package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    com.sun.jdi.connect.spi.Connection con = (com.sun.jdi.connect.spi.Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/gestion_stock", "root", "");

    public Connection() throws SQLException {
    }
}
