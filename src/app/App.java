package app;

import java.io.IOException;
import java.util.Scanner;

import repository.CursoRepository;
import repository.DisciplinaRepository;
import repository.LivroRepository;
import utils.MenuUtils;

public class App {
	
	private DisciplinaRepository disciplinaRepository = new DisciplinaRepository();
	private LivroRepository livroRepository = new LivroRepository();
	private CursoRepository cursoRepository = new CursoRepository();
	
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

	private static void executeFluxoCadastroLivro(Scanner scanner) {
		String nomeLivro;
		String codigoProduto;
		String isbn;
		
		System.out.println("Digite o nome do livro");
		nomeLivro = scanner.nextLine();
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.nextLine();
		System.out.println("Digite o ISBN do livro");
		isbn = scanner.nextLine();
		
		new Livro(nomeLivro, codigoProduto, isbn);
	}

	private static void executeFluxoListarLivros(Scanner scanner) {

	}
	
	private static void executeFluxoDaDisciplina(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuDisciplina();
			option = scanner.next();
			
			switch (option) {
			case "1":
				clearConsole();
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

	private void executeFluxoCadastroDisciplina(Scanner scanner) {

	}

	private void executeFluxoListarDisciplinas() {

	}
	
	private static void executeFluxoDoCurso(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuCurso();
			option = scanner.next();
			
			switch (option) {
			case "1":
				clearConsole();
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

}
