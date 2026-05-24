package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
        	String url = "jdbc:sqlserver://localhost:1433;"
        	        + "databaseName=QLSinhVien;"
        	        + "integratedSecurity=true;"
        	        + "encrypt=true;"
        	        + "trustServerCertificate=true;";

        	Connection conn = DriverManager.getConnection(url);
        	
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}