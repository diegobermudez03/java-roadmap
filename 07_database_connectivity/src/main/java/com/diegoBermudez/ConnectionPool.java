package com.diegoBermudez;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    public static void main(String[] args) throws SQLException {
        //Hikari also accepts configuration through file
        HikariConfig prop = new HikariConfig();
        prop.setJdbcUrl("jdbc:Oracle:thin:@localhost:1521/ORCLPDB1");
        prop.setUsername("juan");
        prop.setPassword("Actuacion2");
        prop.setMaximumPoolSize(10);
        prop.setMaximumPoolSize(10000); //in miliseconds
        prop.setConnectionTimeout(3000);

        HikariDataSource ds = new HikariDataSource(prop);

        try(Connection con = ds.getConnection()){
            System.out.println("Connection succesfully made");
            //athe operation
        }finally{
            ds.close();
        }

    }
}
