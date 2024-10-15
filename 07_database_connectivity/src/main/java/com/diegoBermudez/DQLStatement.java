package com.diegoBermudez;

import java.sql.*;

public class DQLStatement {

    public static void main(String[] args) throws SQLException {

        //STATEMENT IS A NOT PRECOMPILED SQL STATMENT, IS USED FOR STATIC QUERIES, IT HAS TO BE COMPILED INTO A QUERY EVERY TIME
        //AND IF WE TRY TO USE IT WITH PARAMETERS, LIKE BUILDING MANUALLLY THE STRING, MAY LEAD TO SQL INJECTION

        //create connection
        String url = "jdbc:Oracle:thin:@localhost:1521/ORCLPDB1";
        String user ="juan";
        String password = "Actuacion2";
        Connection conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(true);   //this is not neccesary in this case, but in transactions it may be, set it how we need it
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);  //in order to specify if we want the isolation level


        //create statement and execute query
        String sql = "select * from books";
        Statement stmnt = conn.createStatement();
        ResultSet rst = stmnt.executeQuery(sql);    //execute query is used for select statments
        String title;
        int id;
        while(rst.next()){
            title = rst.getString("TITLE"); //using column name
            id = rst.getInt(1); //using column index
            System.out.println(id + " " + title);
        }

        //close connection
        conn.close();


    }
}
