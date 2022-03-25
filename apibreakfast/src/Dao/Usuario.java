package com.breakfast.apibreakfast;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import  java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Usuario {

    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String Breakfast;

    public Usuario() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Usuario objUsuario) {
        try {
            String sql;
            if (String.valueOf(objUsuario.getId()).isEmpty()) {
                sql = "INSERT INTO usuario(nome,cpf,Breakfast) VALUES(?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objUsuario.getNome());
                stmt.setString(2, objUsuario.getCpf());
                stmt.setString(3, objUsuario.getbreakfast())
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE usuario SET nome = ?, cpf = ?, Breakfast = ? WHERE usuario.id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(5, objUsuario.getId());
                stmt.setString(1, objUsuario.getNome());
                stmt.setString(2, objUsuario.getCpf());
                stmt.setString(3, objUsuario.getbreakfast());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList buscar(Usuario objUsuario) {
        try {
            String sql = "";
            if (!objUsuario.getNome().isEmpty()) {
                sql = "SELECT * FROM usuario WHERE nome LIKE '%" + objUsuario.getNome() + "%' ";

            } else if (!objUsuario.getCpf().isEmpty()) {
                sql = "SELECT * FROM usuario WHERE cpf LIKE '%" + objUsuario.getCpf() + "%' ";
            
            } else if (!objUsuario.getbreakfast().isEmpty()) {
            	sql = "SELECT* FROM usuario WHERE Breakfast Like'%" + objUsuario.getbreakfast() +"%'";
            }
            
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("breakfast"),
                   
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }

    }

    public void deletar(Usuario objUsuario) {
        try {
            String sql;
            if (!String.valueOf(objUsuario.getId()).isEmpty()) {
                sql = "DELETE FROM usuario WHERE usuario.id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objUsuario.getId());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList listarTodos() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("Breakfast"),
                   
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro no ArrayList");
            return null;
        }
    }

    public static void testarConexao() throws SQLException {
        try (Connection objConnection = new ConnectionFactory().getConnection()) {
            JOptionPane.showMessageDialog(null, "Realizada com sucesso! ");
        }
    }

