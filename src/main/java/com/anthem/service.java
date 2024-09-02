package com.anthem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
    public class service {

                public static void main(String[] args) {
                    //String connectionUrl = "jdbc:sqlserver://27x-slvr-azure-sql.database.windows.net:1433;database=enrollDB;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;Authentication=ActiveDirectoryIntegrated;";
                    //String connectionUrl="Server=tcp:appdevserver9000.database.windows.net,1433;Database=appdb";
                    String connectionUrl
                    ="jdbc:sqlserver://27x-slvr-azure-sql.database.windows.net:1433;database=enrollDB;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;Authentication=ActiveDirectoryIntegrated";

                    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT TOP 1 * FROM [dbo].[Employees]");

                        if (resultSet.next()) {
                            Long id = resultSet.getLong("id");
                            String name = resultSet.getString("name");
                            String email = resultSet.getString("email");

                            System.out.println("ID: " + id);
                            System.out.println("Name: " + name);
                            System.out.println("Email: " + email);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }



