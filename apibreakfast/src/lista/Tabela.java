package com.breakfast.apibreakfast;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import  java.sql.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTabela;

public class Tabela extends AbstractTabela {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public Tabela(ArrayList lin, String[] col) {
        this.linhas = lin;
        this.colunas = col;
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    
    public Object getValueAt(int numLinhas, int numColunas) {

        Object[] linha = (Object[]) getLinhas().get(numLinhas);

        return linha[numColunas];
    }
    

}