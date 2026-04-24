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

    public static void startTransaction () throws SQLException {

        if (threadLocal.get() == null || threadLocal.get().isClosed()){

            Connection conn = DriverManager.getConnection(config.getDbUrl(), config.getUser(), config.getPass());
            conn.setAutoCommit(false);
            threadLocal.set(conn);

        }

    }

    public static void commit () throws SQLException {

        Connection conn = threadLocal.get();

        if (conn != null){

            conn.commit();
            closeConnection();

        }

    }

    public static void rollback () {

        try {

            Connection conn = threadLocal.get();

            if (conn != null){

                conn.rollback();
                closeConnection();

            }

        }catch (SQLException err){

            System.err.println("Error in Rollback: " + err.getMessage());

        }

    }

    public static void closeConnection () throws SQLException{

        Connection conn = threadLocal.get();

        if (conn != null){

            conn.close();
            threadLocal.remove();

        }

    }

}
