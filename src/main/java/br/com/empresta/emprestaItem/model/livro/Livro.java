package br.com.empresta.emprestaItem.model.livro;

public class Livro implements Item{

    private String nome;
    private String categoria;
    private String descricao;
    private int qtdDisponivel;


    public Livro(String nome, String categoria, String descricao, int qtdDisponivel) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.qtdDisponivel = qtdDisponivel;
    }

    public Livro() {
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }


    @Override
    public void emprestar() {

    }

    @Override
    public void devolver() {

    }
}
