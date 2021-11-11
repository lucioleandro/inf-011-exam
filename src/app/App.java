package app;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import enums.ProdutosEnum;
import factories.FabricaCurso;
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
		Livro livro1 = new Livro("789", "Algoritmos do Corman", 100.0);
		livro1.setIsbn("hauahuah-hauahuaha");
		Livro livro2 = new Livro("789", "Padrões de projeto", 100.0);
		livro2.setIsbn("hauahuah-tyrtrtrtr");
		App.livroRepository.create(livro1);
		App.livroRepository.create(livro2);
		
		Disciplina disciplina1 = new Disciplina("555", "Padrões de Projetos", 50.0);
		disciplina1.setChTotal(90);
		disciplina1.setPctCumprido(0);
		Disciplina disciplina2 = new Disciplina("667", "Orientação a Objetos", 60.0);
		disciplina2.setChTotal(60);
		disciplina2.setPctCumprido(0);
		
		App.disciplinaRepository.create(disciplina1);
		App.disciplinaRepository.create(disciplina2);
		
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
	
	private static Produto criaProduto(ProdutosEnum tipo, String nome, String codigo, double preco) {
		if(ProdutosEnum.LIVRO.equals(tipo)) {
			return new FabricaLivro().criaProduto(codigo,nome, preco);
		} 
		else if(ProdutosEnum.DISCIPLINA.equals(tipo)) {
			return new FabricaDisciplina().criaProduto(codigo, nome, preco);
		}
		else {
			return new FabricaCurso().criaProduto(codigo, nome, preco);
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
		
		Livro livro = (Livro) criaProduto(ProdutosEnum.LIVRO, codigoProduto, nomeProduto, precoProduto);
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
		String nomeProduto;
		double precoProduto;
		int chTotal;
		double pctCumprido;
		
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.next();
		System.out.println("Digite o nome do produto");
		nomeProduto = scanner.next();
		System.out.println("Digite o Preço do produto");
		precoProduto = scanner.nextDouble();
		System.out.println("Digite a carga horária da disciplna");
		chTotal = scanner.nextInt();
		System.out.println("Digite a porcentagem cumprida");
		pctCumprido = scanner.nextDouble();
		
		Disciplina disciplina = (Disciplina) criaProduto(ProdutosEnum.DISCIPLINA, codigoProduto, nomeProduto, precoProduto);
		disciplina.setChTotal(chTotal);
		disciplina.setPctCumprido(chTotal);
		
		App.disciplinaRepository.create(disciplina);
		
	}

	private static void executeFluxoListarDisciplinas() {
		List<Disciplina> disciplinas = App.disciplinaRepository.findAll();
		if(disciplinas.isEmpty()) {
			System.out.println("Ainda não há disciplinas cadastradas");
			return;
		}
		System.out.println("--- Disciplinas Cadastradas ---");
		System.out.println(disciplinas);
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
				executeFluxoListarCurso();
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
		String nomeProduto;
		double precoProduto;
		
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.next();
		System.out.println("Digite o nome do produto");
		nomeProduto = scanner.next();
		System.out.println("Digite o Preço do produto");
		precoProduto = scanner.nextDouble();
		
		Curso curso = (Curso) criaProduto(ProdutosEnum.CUSRO, codigoProduto, nomeProduto, precoProduto);
		
		executeFluxoAdicionarElementosCurso(scanner, curso);
		
		App.cursoRepository.criaERegistraPrototipo(curso);
	}
	
	private static void executeFluxoAdicionarElementosCurso(Scanner scanner, Curso curso) {
		String option = "";
		do {
			System.out.println("=======================================");
			System.out.println("Adicone Livros e Disciplinas ao Curso");
			System.out.println("=======================================");
			System.out.println();
			System.out.println("Digite 1 para adicionar um livro");
			System.out.println("Digite 2 para adicionar uma disciplina");
			System.out.println("Digite 3 para voltar para tela principal");
			System.out.println();
			option = scanner.next();
			
			switch (option) {
			case "1":
				clearConsole();
				System.out.println(App.livroRepository.findAll());
				System.out.println("Digite o código de um dos livros acima para adicioná-lo");
				String codigoLivro = scanner.next();
				Livro livro = App.livroRepository.findByCodigo(codigoLivro);
				curso.addLivro(livro);
				break;
			case "2":
				clearConsole();
				System.out.println(App.disciplinaRepository.findAll());
				System.out.println("Digite o código de uma das disciplinas acima para adicioná-la");
				String codigoDisciplina = scanner.next();
				Disciplina disciplina = App.disciplinaRepository.findByCodigo(codigoDisciplina);
				curso.addDisciplina(disciplina);
				break;
			case "3":
				clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}
	
	private static void executeFluxoListarCurso() {
		List<Curso> cursos = App.cursoRepository.findAll();
		if(cursos.isEmpty()) {
			System.out.println("Ainda não há cursos cadastrados");
			return;
		}
		System.out.println(cursos);
	}

}
