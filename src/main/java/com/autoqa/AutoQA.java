package com.autoqa;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AutoQA {
    public static void main(String[] args) {
        String usuario = "root";
        String password = "PONERCLAVE";
        String url = "jdbc:mysql://localhost:3306/crud";
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {
            connection = DriverManager.getConnection(url, usuario, password);

            //Obtener datos
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            //Insertar datos
            statement.execute("INSERT USERS(name, apellido) VALUES('Juan', 'Sarmiento');");
            statement.execute("INSERT USERS(name, apellido) VALUES('Marcos', 'Sarmiento');");

            //Actualizar datos
            statement.execute("UPDATE USERS SET name='Pedro' WHERE USERS.name='Juan';");
            resultSet = statement.executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            //Borrar datos
            statement.execute("DELETE FROM USERS;");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}