package com.diegoBermudez;

import java.sql.*;

public class SQLCallableStatement {
    public static void main(String[] args) throws SQLException {
        //create connection
        String url = "jdbc:Oracle:thin:@localhost:1521/ORCLPDB1";
        String user ="juan";
        String password = "Actuacion2";
        Connection conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(true);   //this is not neccesary in this case, but in transactions it may be, set it how we need it
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);  //in order to specify if we want the isolation level


        //PROCEDURES
        String procedure = "{call doSomething(?,?)}";
        CallableStatement calling = conn.prepareCall(procedure);
        calling.setInt(1, 10);
        calling.setString(2, "hola");
        calling.executeQuery();     //it doesn't neccesarily need to return a result set, but it can, and we can check what it returned

        conn.close();

    }
}
