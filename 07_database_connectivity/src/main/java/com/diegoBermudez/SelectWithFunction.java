package com.diegoBermudez;

import java.sql.*;

public class SelectWithFunction {
    public static void main(String[] args) throws SQLException {
        //jdbc:oracle:thin:@[host]:[port]:[SID] or dbc:oracle:thin:@[host]:[port]/[service name]
        String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB1";
        String user = "juan";
        String password = "Actuacion2";
        Connection conn = DriverManager.getConnection(url, user, password);


        //create function call
        String sql = "{? = call get_books_function(?, ?)}";
        CallableStatement query = conn.prepareCall(sql);
        query.setInt(2, 3);
        query.setInt(3,6);
        query.registerOutParameter(1, Types.REF_CURSOR);
        query.execute();
        ResultSet result = (ResultSet) query.getObject(1);

        while(result.next()) {
            int id = result.getInt(1);
            System.out.println(result.getString(2));
            String titulo = result.getString("TITLE");
            System.out.println(result.getString("CATEGORY"));
            String category = result.getString(3);
            System.out.println("resumen: " + id + " " + titulo + " ->" + category + "\n");
        }
        conn.close();
    }
}