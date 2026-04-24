package com.huellas_sanas.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AppConfig {

    private static AppConfig instance;
    private final Properties dbProps = new Properties();

    private AppConfig () {

        load("db.properties", dbProps);

    }

    public static AppConfig getInstance() {

        if (instance == null){

            synchronized (AppConfig.class){

                if (instance == null) instance = new AppConfig();

            }

        }

        return instance;

    }

    private void load (String fieldnames, Properties target){

        try(InputStream is = getClass().getClassLoader().getResourceAsStream(fieldnames)){

            if (is == null) throw new RuntimeException("Don't found file" + fieldnames);

        }catch (IOException err) {

            throw new RuntimeException("Error to connect with" + fieldnames, err);

        }

    }

    public String getDbUrl () {

        return dbProps.getProperty("db.url");

    }

    public String getUser () {

        return dbProps.getProperty("db.user");

    }

    public String getPass () {

        return dbProps.getProperty("db.pass");

    }

    public String getDriver () {

        return  dbProps.getProperty("db.driver");

    }



}
