package br.com.dio.board.application;

import br.com.dio.board.model.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Board board = new Board();

		board.addColumn(new Column("To Do"));
		board.addColumn(new Column("Doing"));
		board.addColumn(new Column("Done"));

		int option;
		do {
			System.out.println("\n===== MENU BOARD =====");
			System.out.println("1. Criar nova tarefa");
			System.out.println("2. Ver Board");
			System.out.println("3. Mover tarefa");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();
			scanner.nextLine(); // limpar buffer

			switch (option) {
				case 1:
					System.out.print("Título da tarefa: ");
					String title = scanner.nextLine();
					System.out.print("Descrição da tarefa: ");
					String desc = scanner.nextLine();
					Task task = new Task(title, desc);
					board.getColumnByName("To Do").addTask(task);
					System.out.println("Tarefa adicionada à coluna 'To Do'.");
					break;

				case 2:
					board.showBoard();
					break;

				case 3:
					System.out.print("Qual a coluna de origem: To Do, Doing ou Done: ");
					String from = scanner.nextLine();
					System.out.print("Qual a coluna de destino: To Do, Doing ou Done: ");
					String to = scanner.nextLine();

					Column colFrom = board.getColumnByName(from);
					Column colTo = board.getColumnByName(to);

					if (colFrom == null || colTo == null) {
						System.out.println("Coluna inválida.");
						break;
					}

					System.out.println("Tarefas na coluna " + from + ":");
					System.out.println(colFrom);

					System.out.print("Digite o índice da tarefa a mover: ");
					int idx = scanner.nextInt();
					scanner.nextLine(); // limpar buffer

					if (idx < 0 || idx >= colFrom.getTasks().size()) {
						System.out.println("Índice inválido.");
						break;
					}

					Task movingTask = colFrom.getTaskByIndex(idx);
					colFrom.removeTask(movingTask);
					colTo.addTask(movingTask);
					System.out.println("Tarefa movida com sucesso.");
					break;

				case 0:
					System.out.println("Saindo...");
					break;

				default:
					System.out.println("Opção inválida.");
			}

		} while (option != 0);

		scanner.close();
	}
}
