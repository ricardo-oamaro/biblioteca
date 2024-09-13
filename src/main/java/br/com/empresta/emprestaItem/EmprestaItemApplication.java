package br.com.empresta.emprestaItem;

import br.com.empresta.emprestaItem.model.emprestimo.CadastraLivros;
import br.com.empresta.emprestaItem.model.emprestimo.SistemaEmprestimo;
import br.com.empresta.emprestaItem.model.livro.Livro;
import br.com.empresta.emprestaItem.model.usuario.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmprestaItemApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmprestaItemApplication.class, args);


		Usuario usuario1 = new Usuario("João", "12345678900");
		Usuario usuario2 = new Usuario("Maria", "98765432100");
		Usuario usuario3 = new Usuario("José", "12343212300");

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);



		SistemaEmprestimo sistema = new SistemaEmprestimo();
		CadastraLivros cadastraLivros = new CadastraLivros();


		cadastraLivros.cadastrarLivro(new Livro("Java", "Programming", "Java for Dummies", 3));
		cadastraLivros.cadastrarLivro(new Livro("PHP", "Programming", "PHP baby steps", 5));
		cadastraLivros.cadastrarLivro(new Livro("C#", "Programming", "C# advanced", 2));
		cadastraLivros.cadastrarLivro(new Livro("Vidas Secas", "Literatura", "Literatura Brasileira", 2));
		cadastraLivros.cadastrarLivro(new Livro("Abaco", "Matematica", "Primeiros passos na matemática", 1));

		for(Livro livro : cadastraLivros.getListaItens()) {
			sistema.adicionarItem(livro.getNome());
		}

		for(Usuario usuario : usuarios) {
			sistema.adicionarUsuario(usuario);
		}

		Scanner scanner = new Scanner(System.in);

		System.out.println("Gostaria de cadastrar um livro? [Y/n]");
		String resposta = scanner.nextLine();

		while (resposta.equalsIgnoreCase("Y")) {
			System.out.println("Digite o nome do livro: ");
			String nome = scanner.nextLine();
			System.out.println("Digite a categoria do livro: ");
			String categoria = scanner.nextLine();
			System.out.println("Digite a descrição do livro: ");
			String descricao = scanner.nextLine();
			System.out.println("Digite a quantidade disponível do livro: ");
			int qtdDisponivel = scanner.nextInt();
			scanner.nextLine();
			cadastraLivros.cadastrarLivro(new Livro(nome, categoria, descricao, qtdDisponivel));
			System.out.println("Gostaria de cadastrar um outro livro? [Y/n]");
			resposta = scanner.nextLine();
		}

		cadastraLivros.listarItens();
		usuario1.mostrarUsuario(usuario1);
		usuario2.mostrarUsuario(usuario2);
		usuario3.mostrarUsuario(usuario3);

		System.out.println(sistema.realizarEmprestimo(usuario1.getNome(), "Java"));
		System.out.println(sistema.realizarEmprestimo(usuario1.getNome(), "PHP"));
		System.out.println(sistema.realizarEmprestimo(usuario1.getNome(), "C#"));

		System.out.println(sistema.realizarDevolucao(usuario1.getNome(), "Java"));

		sistema.listarItensDisponiveis();
		sistema.listarItensEmprestados();
		sistema.listarUsuarios();
	}


}
