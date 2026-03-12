package test;

import util.DBConnection;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("KẾT NỐI THÀNH CÔNG 🎉");
        } else {
            System.out.println("KẾT NỐI THẤT BẠI ❌");
        }
    }
}