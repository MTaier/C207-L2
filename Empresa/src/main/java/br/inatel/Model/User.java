package br.inatel.Model;

public class User {
    private int id;
    private String nome;
    private String cpf;
    private int projeto;

    public User(String nome, String cpf, int projeto) {
        this.nome = nome;
        this.cpf = cpf;
        this.projeto = projeto;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getProjeto() {
        return projeto;
    }
}
