package db;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.sql.*;

public class DB {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            try{
                Properties properties = loadProperties();
                String url = properties.getProperty("url");
                connection = DriverManager.getConnection(url, properties);
            }catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fs);
            return properties;
        }catch (IOException e){
            throw new DBException(e.getMessage());
        }
    }

    public static void closeStatement(Statement statement){
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }
}
