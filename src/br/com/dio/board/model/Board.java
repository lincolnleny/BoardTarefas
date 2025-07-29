package br.com.dio.board.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Column> columns;

	public Board() {
		this.columns = new ArrayList<>();
	}

	public void addColumn(Column column) {
		columns.add(column);
	}

	public List<Column> getColumns() {
		return columns;
	}

	public Column getColumnByName(String name) {
		for (Column col : columns) {
			if (col.getName().equalsIgnoreCase(name)) {
				return col;
			}
		}
		return null;
	}

	public void showBoard() {
		for (Column column : columns) {
			System.out.println(column);
		}
	}
}
