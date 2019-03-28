package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    private static final String DB_DRIVER = getPropertyValue("db.driver");
    private static final String DB_URL = getPropertyValue("db.host");
    private static final String DB_USERNAME = getPropertyValue("db.login");
    private static final String DB_PASSWORD = getPropertyValue("db.password");


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME,
                    DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static String getPropertyValue(String property) {
        String value = null;
        Properties properties = new Properties();

        try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("database.properties")) {

            properties.load(inputStream);

            value = properties.getProperty(property);

        } catch (IOException e) {
            System.err.println("Properties file does not exist.");
        }

        return value;
    }
}
