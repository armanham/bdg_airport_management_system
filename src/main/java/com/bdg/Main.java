package com.bdg;

import com.bdg.db.DBConnectionManager;
import com.bdg.insert_to_db.Inserter;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection connection = DBConnectionManager.getConnection();


        Inserter inserter = new Inserter();
        //inserter.insertCompanyTable(connection);
        //inserter.insertAddressTable(connection);
        //inserter.insertPassengerTable(connection);
        //inserter.insertTripTable(connection);
        //inserter.insertPassInTripTable(connection);



        DBConnectionManager.closeConnection();
    }
}