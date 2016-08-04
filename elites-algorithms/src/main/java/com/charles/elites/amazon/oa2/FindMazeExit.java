package com.charles.elites.amazon.oa2;

public class FindMazeExit {

	static boolean[][] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] maze = new int[6][6];
		maze[0] = new int[] { 1, 1, 0, 0, 0, 0 };
		maze[1] = new int[] { 0, 1, 0, 0, 0, 0 };
		maze[2] = new int[] { 0, 1, 0, 1, 0, 1 };
		maze[3] = new int[] { 1, 1, 1, 1, 0, 1 };
		maze[4] = new int[] { 0, 1, 0, 1, 0, 1 };
		maze[5] = new int[] { 0, 1, 0, 1, 1, 1 };
		
		System.out.println(canExit(maze, 0, 0, 5, 5));

	}

	public static boolean canExit(int[][] maze, int startI, int startJ, int exitI, int exitJ) {
		if(maze == null || maze.length == 0 || maze[0].length == 0)
            return false;
		int m = maze.length;
		int n = maze[0].length;
		visited = new boolean[m][n];
		
		if(reachExit(startI, startJ, maze, exitI, exitJ))
			return true;
		
		return false;
	}
	
	private static boolean reachExit(int i, int j, int[][] maze, int exitI, int exitJ) {
		if(i == exitI && j == exitJ)
			return true;
		if(i < 0 || i >= maze.length || j < 0 || j >= maze[0].length)
			return false;
		if(visited[i][j])
			return false;
		if(maze[i][j] != 1)
			return false;
		visited[i][j] = true;
		boolean res = reachExit(i - 1, j, maze, exitI, exitJ) || reachExit(i + 1, j, maze, exitI, exitJ) 
				|| reachExit(i, j - 1, maze, exitI, exitJ) ||reachExit(i, j + 1, maze, exitI, exitJ);
		visited[i][j] = false;
		return res;
	}
	
	private static class Point {
		int x, y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 223;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) 
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}


