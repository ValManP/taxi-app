package edu.unn.taxi.impl.controller;

import edu.unn.taxi.impl.utils.spring.SpringTestConfiguration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringTestConfiguration.class})
public class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @Autowired
    private SpringTestConfiguration context;

    @BeforeClass
    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");

        //initDatabase();
    }

    private static void initDatabase() throws SQLException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
            statement.execute("select 1 from dual");
            connection.commit();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:mem:users", "unn", "");
    }

    @Test
    public void testCreateOrder() {
        // Arrange

        // Act

        // Assert
    }
}