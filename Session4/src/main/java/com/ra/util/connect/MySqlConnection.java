package com.ra.util.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
        private Connection connection;
        public MySqlConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_user", "root", "ngoduy");
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        public Connection getConnection() {
            return this.connection;
        }
}
