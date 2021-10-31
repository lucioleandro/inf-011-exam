package app;

import java.io.IOException;
import java.util.Scanner;

import enums.ProdutosEnum;
import factories.FabricaDisciplina;
import factories.FabricaLivro;
import models.Curso;
import models.Disciplina;
import models.Livro;
import models.Produto;
import repository.CursoRepository;
import repository.DisciplinaRepository;
import repository.LivroRepository;
import utils.MenuUtils;

public class App {
	
	private static DisciplinaRepository disciplinaRepository = new DisciplinaRepository();
	private static LivroRepository livroRepository = new LivroRepository();
	private static CursoRepository cursoRepository = new CursoRepository();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scanner = new Scanner(System.in);
		String option = "";
		do {
			MenuUtils.mostreMenuPrincipal();
			option = scanner.next();
			
			switch (option) {
			case "1":
				clearConsole();
				executeFluxoDaDisciplina(scanner);
				break;
			case "2":
				clearConsole();
				executeFluxoDoLivro(scanner);
				break;
			case "3":
				clearConsole();
				executeFluxoDoCurso(scanner);
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			clearConsole();
		} while (!option.equals("0"));
		
		scanner.close();
	}
	
	private static Produto criaProduto(ProdutosEnum tipo, String codigo, double preco) {
		if(ProdutosEnum.LIVRO.equals(tipo)) {
			return new FabricaLivro().criaProduto(codigo, preco);
		} 
		else if(ProdutosEnum.DISCIPLINA.equals(tipo.DISCIPLINA)) {
			return new FabricaDisciplina().criaProduto(codigo, preco);
		}
		else {
			return null;
		}
	}
	
	private static void clearConsole() {
		System.out.println("\033[H\033[2J");
		System.out.flush();;
	}
	
	private static void executeFluxoDoLivro(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuLivro();
			option = scanner.next();
			
			switch (option) {
			case "1":
				clearConsole();
				executeFluxoCadastroLivro(scanner);
				break;
			case "2":
				clearConsole();
				executeFluxoListarLivros(scanner);
				break;
			case "3":
				clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}

	private static void executeFluxoCadastroLivro(Scanner scanner) {
		String codigoProduto;
		double precoProduto;
		String isbn;
		
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.next();
		System.out.println("Digite o Preço do produto");
		precoProduto = scanner.nextDouble();
		System.out.println("Digite o ISBN do livro");
		isbn = scanner.next();
		
		Livro livro = (Livro) criaProduto(ProdutosEnum.LIVRO, codigoProduto, precoProduto);
		livro.setIsbn(isbn);
		
		App.livroRepository.create(livro);
		
	}

	private static void executeFluxoListarLivros(Scanner scanner) {
		System.out.println(App.livroRepository.findAll());
	}
	
	private static void executeFluxoDaDisciplina(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuDisciplina();
			option = scanner.next();
			
			switch (option) {
			case "1":
				clearConsole();
				executeFluxoCadastroDisciplina(scanner);
				break;
			case "2":
				clearConsole();
				executeFluxoListarDisciplinas();
				break;
			case "3":
				clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}

	private static void executeFluxoCadastroDisciplina(Scanner scanner) {
		String codigoProduto;
		double precoProduto;
		int chTotal;
		double pctCumprido;
		
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.next();
		System.out.println("Digite o Preço do produto");
		precoProduto = scanner.nextDouble();
		System.out.println("Digite a carga horária da disciplna");
		chTotal = scanner.nextInt();
		System.out.println("Digite a porcentagem cumprida");
		pctCumprido = scanner.nextDouble();
		
		Disciplina disciplina = (Disciplina) criaProduto(ProdutosEnum.DISCIPLINA, codigoProduto, precoProduto);
		disciplina.setChTotal(chTotal);
		disciplina.setPctCumprido(chTotal);
		
		App.disciplinaRepository.create(disciplina);
		
	}

	private static void executeFluxoListarDisciplinas() {
		System.out.println(App.disciplinaRepository.findAll());
	}
	
	private static void executeFluxoDoCurso(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuCurso();
			option = scanner.next();
			
			switch (option) {
			case "1":
				clearConsole();
				executeFluxoCadastroCurso(scanner);
				break;
			case "2":
				clearConsole();
				break;
			case "3":
				clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}
	
	private static void executeFluxoCadastroCurso(Scanner scanner) {
		String codigoProduto;
		double precoProduto;
		
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.next();
		System.out.println("Digite o Preço do produto");
		precoProduto = scanner.nextDouble();
		System.out.println("Digite a carga horária da disciplna");
		
		Curso curso = (Curso) criaProduto(ProdutosEnum.CUSRO, codigoProduto, precoProduto);
		
		App.cursoRepository.create(curso);
	}
	
	private static void executeFluxoListarCurso() {
		System.out.println(App.cursoRepository.findAll());
	}

}
