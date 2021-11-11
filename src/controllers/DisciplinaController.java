package controllers;

import java.util.List;
import java.util.Scanner;

import enums.ProdutosEnum;
import factories.Industria;
import models.Disciplina;
import repository.DisciplinaRepository;
import utils.MenuUtils;
import utils.Utils;

public class DisciplinaController {

	private DisciplinaRepository disciplinaRepository;
	
	public DisciplinaController() {
		this.disciplinaRepository = DisciplinaRepository.getInstance();
	}
	
	public void executeFluxoDaDisciplina(Scanner scanner) {
		String option = "";
		do {
			MenuUtils.mostreMenuDisciplina();
			option = scanner.next();
			
			switch (option) {
			case "1":
				Utils.clearConsole();
				executeFluxoCadastroDisciplina(scanner);
				break;
			case "2":
				Utils.clearConsole();
				executeFluxoListarDisciplinas();
				break;
			case "3":
				Utils.clearConsole();
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			
		} while (!option.equals("3"));
	}

	private void executeFluxoCadastroDisciplina(Scanner scanner) {
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
		
		Disciplina disciplina = (Disciplina) Industria.criaProduto(ProdutosEnum.DISCIPLINA, codigoProduto, nomeProduto, precoProduto);
		disciplina.setChTotal(chTotal);
		disciplina.setPctCumprido(pctCumprido);
		
		this.disciplinaRepository.create(disciplina);
		
	}

	private void executeFluxoListarDisciplinas() {
		List<Disciplina> disciplinas = this.disciplinaRepository.findAll();
		if(disciplinas.isEmpty()) {
			System.out.println("Ainda não há disciplinas cadastradas");
			return;
		}
		System.out.println("--- Disciplinas Cadastradas ---");
		System.out.println(disciplinas);
	}
	
}
