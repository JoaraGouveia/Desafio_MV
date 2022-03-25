package com.breakfast.apibreakfast;

public class Usuario {

    private String id;
    private String nome;
    private String cpf;
    private String Breakfast;
    private String[] colunas = new String[]{"ID", "NOME", "CPF", "BREAKFAST"};

    public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String nome) {
        this.nome = nome;

    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setId(String Breakfast) {
        this.Breakfast = Breakfast;
    }

   
    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] Colunas) {
        this.colunas = Colunas;
    }

}
