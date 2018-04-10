package com.cice.database;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/prueba", "root", "root");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM prueba";
            String ins = "INSERT INTO prueba VALUES ( null, 'nombrePrueba')";
            /*
            for (int i = 0; i < 100; i++) {
                statement.executeUpdate(ins);
            }*/
            ResultSet resultado = statement.executeQuery(sql);
            resultado.first();
            String id = resultado.getString("id");
            System.out.println(id);
            String nombre = resultado.getString("nombre");
            System.out.println(id +" - " + nombre);
            while (resultado.next()){
                System.out.println("id " + resultado.getString(1));
                System.out.println("Nombre " + resultado.getString(2));
            }
            statement.close();
            connection.close();
            resultado.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
