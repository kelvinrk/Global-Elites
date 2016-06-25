package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class WordSearch {
	private static boolean[][] visited;
	public static void main(String[] args) {
		char[][] board = new char[][]{
		                              {'A', 'B', 'C', 'E'},
		                              {'S', 'F', 'C', 'S'},
		                              {'A', 'D', 'E', 'E'}
		};
		String word = "AFCCES";
		find(board, word);
	}
	private static void find(char[][] board, String word) {
		if (word.length() == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		visited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				List<Point> res = new ArrayList<Point>();
				if (search(board, word, 0, i, j, res)) {
					Collections.reverse(res);
					for(Point each : res)
						System.out.println(board[each.x][each.y]);
				}
			}
		}
	}
	private static boolean search(char[][] board, String word, int index,
		int i, int j, List<Point> res) {
		if (index == word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		if (visited[i][j])
			return false;
		if (word.charAt(index) != board[i][j])
			return false;
		visited[i][j] = true;
		if (search(board, word, index + 1, i - 1, j - 1, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		if (search(board, word, index + 1, i - 1, j, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		if (search(board, word, index + 1, i - 1, j + 1, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		if (search(board, word, index + 1, i, j + 1, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		if (search(board, word, index + 1, i + 1, j + 1, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		if (search(board, word, index + 1, i + 1, j, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		if (search(board, word, index + 1, i + 1, j - 1, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		if (search(board, word, index + 1, i, j - 1, res)) {
			Point point = new Point(i, j);
			res.add(point);
			return true;
		}
		visited[i][j] = false;
		return false;
	}
}
