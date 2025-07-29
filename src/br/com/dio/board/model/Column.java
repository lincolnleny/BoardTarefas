package br.com.dio.board.model;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private String name;
	private List<Task> tasks;

	public Column(String name) {
		this.name = name;
		this.tasks = new ArrayList<>();
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void removeTask(Task task) {
		tasks.remove(task);
	}

	public Task getTaskByIndex(int index) {
		return tasks.get(index);
	}

	public String getName() {
		return name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[" + name + "]\n");
		for (int i = 0; i < tasks.size(); i++) {
			sb.append(i).append(" - ").append(tasks.get(i)).append("\n");
		}
		return sb.toString();
	}
}
