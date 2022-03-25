package com.breakfast.apibreakfast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conect {

    public Conect getConect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/Usuario", "root", "");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}