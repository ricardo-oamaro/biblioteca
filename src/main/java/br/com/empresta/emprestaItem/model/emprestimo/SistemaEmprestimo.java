package br.com.empresta.emprestaItem.model.emprestimo;

import br.com.empresta.emprestaItem.model.livro.Livro;
import br.com.empresta.emprestaItem.model.usuario.Usuario;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SistemaEmprestimo {
    private Map<String, Boolean> itensDisponiveis = new HashMap<>();
    private Map<String, Set<String>> usuariosEmprestimos = new HashMap<>();
    private Map<String, String> usuarios = new HashMap<>();

    public void adicionarItem(String livro) {
        itensDisponiveis.put(livro, true);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNome(), usuario.getCpf());
    }

    public String realizarEmprestimo(String usuario, String livro) {

        if(usuariosEmprestimos.containsKey(usuario) && usuariosEmprestimos.get(usuario).contains(livro)) {
            return "Usuário já possui este item emprestado";
        }

        if(!itensDisponiveis.containsKey(livro) || !itensDisponiveis.get(livro)) {
            return "Item não disponível para empréstimo";
        }

        itensDisponiveis.put(livro, false);
        usuariosEmprestimos.putIfAbsent(usuario, new HashSet<>());
        usuariosEmprestimos.get(usuario).add(livro);

        return "Empréstimo realizado com sucesso";
    }

    public String realizarDevolucao(String usuario, String livro) {
        if (!itensDisponiveis.containsKey(livro)) {
            return "Item não pertence à biblioteca";
        }

        if (!usuariosEmprestimos.containsKey(usuario) || !usuariosEmprestimos.get(usuario).contains(livro)) {
            return "Usuário não possui este item emprestado";
        }

        usuariosEmprestimos.get(usuario).remove(livro);
        itensDisponiveis.put(livro, true);

        return "Devolução realizada com sucesso";
    }

    public void listarItensDisponiveis() {
        System.out.println("=========== Livros disponíveis para emprestimo ===========");
        for (String item : itensDisponiveis.keySet()) {
            if (itensDisponiveis.get(item)) {
                System.out.println(item);
            }
        }
        System.out.println("===========================================================");
    }

    public void listarItensEmprestados() {
        System.out.println("=========== Livros emprestados ===========");
        for (String usuario : usuariosEmprestimos.keySet()) {
            System.out.println("Usuário: " + usuario);
            for (String item : usuariosEmprestimos.get(usuario)) {
                System.out.println(item);
            }
        }
        System.out.println("==========================================");
    }

    public void listarUsuarios() {
        System.out.println("=========== Usuários cadastrados ===========");
        for (String usuario : usuarios.keySet()) {
            System.out.println("Nome: " + usuario + " - CPF: " + usuarios.get(usuario));
        }
        System.out.println("==========================================");
    }


}
