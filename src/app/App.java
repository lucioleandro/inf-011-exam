package app;

import java.io.IOException;
import java.util.Scanner;

import controllers.CursoController;
import controllers.DisciplinaController;
import controllers.LivroController;
import utils.MenuUtils;
import utils.Utils;

public class App {
	
	private static LivroController livroController = new LivroController();
	private static DisciplinaController disciplinaController = new DisciplinaController();
	private static CursoController cursoController = new CursoController();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		String option = "";
		do {
			MenuUtils.mostreMenuPrincipal();
			option = scanner.next();
			
			switch (option) {
			case "1":
				Utils.clearConsole();
				disciplinaController.executeFluxoDaDisciplina(scanner);
				break;
			case "2":
				Utils.clearConsole();
				livroController.executeFluxoDoLivro(scanner);
				break;
			case "3":
				Utils.clearConsole();
				cursoController.executeFluxoDoCurso(scanner);
			default:
				System.out.println("Opção não aceita, tente novamente");
				break;
			}
			Utils.clearConsole();
		} while (!option.equals("0"));
		
		scanner.close();
	}
	

}
