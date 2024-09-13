package br.com.empresta.emprestaItem.model.emprestimo;

import br.com.empresta.emprestaItem.model.livro.Livro;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CadastraLivros {
    @Getter
    List<Livro> listaItens = new ArrayList<>();
    SistemaEmprestimo sistemaEmprestimo = new SistemaEmprestimo();

    public void cadastrarLivro(Livro livro) {
        listaItens.add(livro);
        System.out.println("Livro cadastrado com sucesso! " + livro.getNome());
    }

    public void listarItens() {
        for (Livro livro : listaItens) {
            System.out.println("Nome: " + livro.getNome() +
                    "\n descrição: " + livro.getDescricao() +
                    "\n categoria: " + livro.getCategoria() +
                    "\n quantidade: " + livro.getQtdDisponivel() +
                    "\n =====================================");
        }
    }

}
