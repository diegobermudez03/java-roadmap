package com.diegoBermudez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMLPreparedStatement {
    public static void main(String[] args) throws SQLException {

        //PREPAREDSTATEMENT IS DIFFERENT THAN STATEMENT BECAUSE, IT'S PRE COMPILED, SO IT HAS BETTER PERFORMANCE SINCE IT DOESN'T HAVE TO BE
        //COMPILED EACH TIME, IT'S STORE TO REUSE, ALSO, IT'S MADE TO INSERT PARAMETERS WITH PLACEHOLDERS ?, SO THAT WE PREVENT THE SQL
        //INJECTION BY NOT BUILDING MANUALLY THE STRING WITH THE USER INPUT, IT'S A DYNAMIC STATEMENT

        //create connection
        String url = "jdbc:Oracle:thin:@localhost:1521/ORCLPDB1";
        String user ="juan";
        String password = "Actuacion2";
        Connection conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(false);   //this is not neccesary in this case, but in transactions it may be, set it how we need it
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);  //in order to specify if we want the isolation level


        //create insert
        try{
            String sql = "insert into test values (?, ?, ?)";
            PreparedStatement stmnt = conn.prepareStatement(sql);
            String passwrd = "Actuacio";
            int id = 1;
            int age = 20;
            stmnt.setInt(1, id);
            stmnt.setString(2, passwrd);
            stmnt.setInt(3, age);
            int rows = stmnt.executeUpdate();      //executeupdate is used with DML queries, it return the number of rows affected
            conn.commit();
            System.out.println(rows + "  rows affected");

        }catch(SQLException e){
            e.printStackTrace();
            conn.rollback();    //in this example there is no real need to disable the autocommit sicne it's a single operation, but it's in order for the example
        }finally {
            conn.close();
        }
    }
}
