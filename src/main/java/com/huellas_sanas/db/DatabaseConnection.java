package com.huellas_sanas.db;

import com.huellas_sanas.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static volatile DatabaseConnection instance;
    private static final AppConfig config = AppConfig.getInstance();
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private DatabaseConnection () {

        try {

            Class.forName(config.getDriver());

        }catch (ClassNotFoundException err) {

            throw new RuntimeException("don't found JDBC driver:", err);

        }

    }

    public static DatabaseConnection getInstance() {

        if (instance == null){

            synchronized (DatabaseConnection.class){

                if (instance == null) instance = new DatabaseConnection();

            }

        }

        return instance;

    }

    public Connection getConnection () throws SQLException {

        if (threadLocal.get() != null && !threadLocal.get().isClosed()){

            return threadLocal.get();

        }

        Connection conn = DriverManager.getConnection(config.getDbUrl(), config.getUser(), config.getPass());
        threadLocal.set(conn);
        return conn;

    }

}
