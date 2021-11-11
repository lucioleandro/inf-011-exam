package controllers;

import java.util.List;
import java.util.Scanner;

import enums.ProdutosEnum;
import factories.Industria;
import models.Livro;
import repository.LivroRepository;
import utils.MenuUtils;
import utils.Utils;

public class LivroController {
	
	private LivroRepository repository;
	
	public LivroController() {
		this.repository = LivroRepository.getInstance();
	}

	public void executeFluxoDoLivro(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuLivro();
			option = scanner.next();
			
			switch (option) {
			case "1":
				Utils.clearConsole();
				executeFluxoCadastroLivro(scanner);
				break;
			case "2":
				Utils.clearConsole();
				executeFluxoListarLivros();
				break;
			case "3":
				Utils.clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}

	private void executeFluxoCadastroLivro(Scanner scanner) {
		String codigoProduto;
		String nomeProduto;
		double precoProduto;
		String isbn;
		
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.next();
		System.out.println("Digite o nome do produto");
		nomeProduto = scanner.next();
		System.out.println("Digite o Preço do produto");
		precoProduto = scanner.nextDouble();
		System.out.println("Digite o ISBN do livro");
		isbn = scanner.next();
		
		Livro livro = (Livro) Industria.criaProduto(ProdutosEnum.LIVRO, codigoProduto, nomeProduto, precoProduto);
		livro.setIsbn(isbn);
		
		this.repository.create(livro);
		
	}

	private void executeFluxoListarLivros() {
		List<Livro> list = this.repository.findAll();
		if(list.isEmpty()) {
			System.out.println("Ainda não há livros cadastrados");
		}
		System.out.println("--- Livros Cadastrados ---");
		System.out.println(list);
	}

}
