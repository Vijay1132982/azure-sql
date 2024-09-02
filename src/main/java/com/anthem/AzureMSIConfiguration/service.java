// src/main/java/com/anthem/service/DatabaseService.java
package com.anthem.AzureMSIConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class service {

    private final DataSource dataSource;

    @Autowired
    public service(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void queryDatabase() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table_name")) {

            while (resultSet.next()) {
                // Process the result set
                System.out.println("Column Value: " + resultSet.getString("your_column_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}