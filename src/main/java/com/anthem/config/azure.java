package com.anthem.config;

import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class azure {

    @Bean
    public DefaultAzureCredential defaultAzureCredential() {
        return new DefaultAzureCredentialBuilder().build();
    }

    @Bean
public SQLServerDataSource dataSource(DefaultAzureCredential credential) {
    SQLServerDataSource dataSource = new SQLServerDataSource();
    dataSource.setServerName("<your-server-name>.database.windows.net");
    dataSource.setDatabaseName("<your-database-name>");
    dataSource.setAuthentication("ActiveDirectoryMSI");
    dataSource.setAccessToken(credential.getToken(new TokenRequestContext()).block().getToken());
    return dataSource;
}
}