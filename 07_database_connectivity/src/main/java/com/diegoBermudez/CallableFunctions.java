package com.diegoBermudez;

import java.sql.*;

public class CallableFunctions {
    public static void main(String[] args) throws SQLException {
        //create connection
        String url = "jdbc:Oracle:thin:@localhost:1521/ORCLPDB1";
        String user ="juan";
        String password = "Actuacion2";
        Connection conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(true);   //this is not neccesary in this case, but in transactions it may be, set it how we need it
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);  //in order to specify if we want the isolation level


        //create function call
        String sql = "{? = call calculate(?,?)";
        CallableStatement funct = conn.prepareCall(sql);
        funct.registerOutParameter(1, Types.INTEGER);   //Tells the driver what type it should expect to get as return, so that then we can retrieve it
        funct.setInt(2, 5);
        funct.setInt(3, 10);

        funct.executeUpdate();

        System.out.println("Result : " + funct.getString(1) );
        conn.close();
    }
}
