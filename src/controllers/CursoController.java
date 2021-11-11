package controllers;

import java.util.List;
import java.util.Scanner;

import enums.ProdutosEnum;
import factories.Industria;
import models.Curso;
import models.Disciplina;
import models.Livro;
import repository.CursoRepository;
import repository.DisciplinaRepository;
import repository.LivroRepository;
import utils.MenuUtils;
import utils.Utils;

public class CursoController {
	
	private CursoRepository repository;
	private LivroRepository livroRepository;
	private DisciplinaRepository disciplinaRepository;
	
	public CursoController() {
		this.repository = new CursoRepository();
		this.livroRepository = LivroRepository.getInstance();
		this.disciplinaRepository = DisciplinaRepository.getInstance();
	}
	
	public void executeFluxoDoCurso(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuCurso();
			option = scanner.next();
			
			switch (option) {
			case "1":
				Utils.clearConsole();
				executeFluxoCadastroCurso(scanner);
				break;
			case "2":
				Utils.clearConsole();
				executeFluxoListarCurso();
				break;
			case "3":
				Utils.clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}
	
	private void executeFluxoCadastroCurso(Scanner scanner) {
		String codigoProduto;
		String nomeProduto;
		double precoProduto;
		
		System.out.println("Digite o código do produto");
		codigoProduto = scanner.next();
		System.out.println("Digite o nome do produto");
		nomeProduto = scanner.next();
		System.out.println("Digite o Preço do produto");
		precoProduto = scanner.nextDouble();
		
		Curso curso = (Curso) Industria.criaProduto(ProdutosEnum.CUSRO, codigoProduto, nomeProduto, precoProduto);
		
		executeFluxoAdicionarElementosCurso(scanner, curso);
		
		this.repository.criaERegistraPrototipo(curso);
	}
	
	private void executeFluxoAdicionarElementosCurso(Scanner scanner, Curso curso) {
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
				Utils.clearConsole();
				System.out.println(this.livroRepository.findAll());
				System.out.println("Digite o código de um dos livros acima para adicioná-lo");
				String codigoLivro = scanner.next();
				Livro livro = this.livroRepository.findByCodigo(codigoLivro);
				curso.addLivro(livro);
				break;
			case "2":
				Utils.clearConsole();
				System.out.println(this.disciplinaRepository.findAll());
				System.out.println("Digite o código de uma das disciplinas acima para adicioná-la");
				String codigoDisciplina = scanner.next();
				Disciplina disciplina = this.disciplinaRepository.findByCodigo(codigoDisciplina);
				curso.addDisciplina(disciplina);
				break;
			case "3":
				Utils.clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}
	
	private void executeFluxoListarCurso() {
		List<Curso> cursos = this.repository.findAll();
		if(cursos.isEmpty()) {
			System.out.println("Ainda não há cursos cadastrados");
			return;
		}
		System.out.println(cursos);
	}

}
