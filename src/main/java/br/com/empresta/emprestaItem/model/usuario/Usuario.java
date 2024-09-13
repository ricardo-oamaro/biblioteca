package br.com.empresta.emprestaItem.model.usuario;

public class Usuario {

    private String nome;
    private String cpf;


    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void mostrarUsuario(Usuario usuario) {
        System.out.println("========= Usuário Cadastrado =========");
        System.out.println("Nome: " + this.nome + "\nCPF: " + this.cpf);
    }
}
