package com.diegoBermudez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DDL {
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


        //create action
        String sql = """
                    create table test(
                        id varchar(2),
                        password varchar2(8),
                        age number(2))""";
        Statement stmnt = conn.createStatement();
        boolean check = stmnt.execute(sql); //check returns true if the query returned something, in this case it doesn't

        //close connection
        conn.close();
    }
}

