package com.diegoBermudez;

import java.sql.*;

public class BatchProcessing {
    public static void main(String[] args) throws SQLException {

        //BATCH PROCESSING IS TO PROCCESS VARIOUS OPERATIONS IN A SINGLE CALL, HOWEVER, THE QUERIES CAN BE DIFFERENT ONLY USING
        //STATEMENT, NOT USING PREPAREDSTATEMENT, AND IF WE NEED USER INPUT, WE ALREADY KNOW THAT STATMENT IS NOR SECURE, SO
        //INN THAT CASE, WE MUST HANDLE THE TRANSACTION'S OPERATIONS MANUALLY


        //create connection
        String url = "jdbc:Oracle:thin:@localhost:1521/ORCLPDB1";
        String user ="juan";
        String password = "Actuacion2";
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);  //in order to specify if we want the isolation level

            String sql1 = "INSERT INTO BOOKS(book_id, title, category) values(15,'libro1','SCI-FI')";
            String sql2 = "INSERT INTO BOOKS(book_id, title, category) values(16,'libro2','SCI-FI')";
            String sql3 = "INSERT INTO BOOKS(book_id, title, category) values(17,'libro3','SCI-FI')";
            Statement stmnt = conn.createStatement();
            stmnt.addBatch(sql1);
            stmnt.addBatch(sql2);
            stmnt.addBatch(sql3);

            int[] rowsAffectedPerQuery = stmnt.executeBatch();
            for (int n : rowsAffectedPerQuery) {
                if (n > 0) continue;
                else {
                    conn.rollback(); //if one query didn't affect any row, it didn't work
                }
            }
            conn.commit();


            System.out.println("------------------------------------------");
            //with prepared statements
            sql1 = "INSERT INTO BOOKS(book_id, title, category) values(?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql1);
            stm.setInt(1, 20);
            stm.setString(2, "libro4");
            stm.setString(3, "SCI-FI");
            stm.addBatch(); //adds this parameters to the batch

            stm.setInt(1, 21);
            stm.setString(2, "5");
            stm.setString(3, "SCI-FI");
            stm.addBatch(); //adds these parameters to the batch

            int[] rowsAffected = stm.executeBatch();
            for (int n : rowsAffected) {
                if (n > 0) continue;
                else {
                    conn.rollback(); //if one query didn't affect any row, it didn't work
                }
            }
            conn.commit();
        }
    }
}
