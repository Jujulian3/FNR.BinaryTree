package view;

import java.util.Scanner;

import model.Tree;

public class Program {
	private boolean isRunning = true;
	private Scanner sc = new Scanner(System.in);
	private Tree tree = new Tree();

	public Program() {}
	
	private String validInput() {
		boolean isValid = true;	
		String letter = "";
		
		do {
			System.out.println("Digite uma letra:");		
			letter = sc.nextLine();
			
			if(letter.trim().length() > 1 || letter.isEmpty() || letter.toUpperCase().charAt(0) < 65 || letter.toUpperCase().charAt(0) > 90) {
				isValid = false;
				System.out.println("Dado inválido!\n");
			} 
		} while (!isValid);
		return letter.toUpperCase();
	}
	
	private void showChoices() {
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Inserir Nó");
		System.out.println("2 - Remover Nó");
		System.out.println("3 - Exibir Árvore");
		System.out.println("4 - Sair do programa");
		
		switch (sc.nextLine()) {
		case "1":
			System.out.println("INSERIR");
			char letterToAdd = validInput().charAt(0);
			tree.addNode(letterToAdd);
			System.out.println("Letra inserida: " + letterToAdd + "\n");
			break;
		case "2":
			System.out.println("REMOVER");
			char letterToRemove = validInput().charAt(0);
			tree.removeNode(letterToRemove);
			System.out.println("Letra removida: " + letterToRemove + "\n");
			break;
		case "3":
			System.out.println("EXIBIR");
			System.out.println(tree.showTree());
			break;
		case "4":
			System.out.println("SAIR");
			isRunning = false;
			break;

		default:
			System.out.println("Opção inválida\n");
			break;
		}
	}

	public void execute() {
		System.out.println("P R O G R A M A   D E   Á R V O R E   B I N Á R I A");		
		while(isRunning) { showChoices(); }		
		System.out.println("F I N A L I Z A D O");		
	}	
}
