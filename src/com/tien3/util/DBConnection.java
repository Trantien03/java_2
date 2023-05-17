package com.tien3.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBConnection{

    public static Connection getConnection() throws Exception{
        try {

            // 1. Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // 2. Create connection
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=task", "sa", "88888888");

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
