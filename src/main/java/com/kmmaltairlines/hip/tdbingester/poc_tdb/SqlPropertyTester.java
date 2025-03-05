package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlPropertyTester {

    @Autowired
    private SqlProperty sqlProperty;

    public void printDatabaseConfig() {
        // Stampa i valori configurati per vedere se sono letti correttamente
        System.out.println("JDBC URL: " + sqlProperty.getJdbcUrl());
        System.out.println("User: " + sqlProperty.getUser());
        System.out.println("Password: " + sqlProperty.getPassword());
        System.out.println("Driver: " + sqlProperty.getDriverClass());
    }
}
