package com.charles.elites.bloomberg;

/**
 * Created by Kelvin.R.K on 7/5/2016.
 * 0 1 2 3 4
 * 0 3 0 1 7
 * 0 3 0 1 7
 * 0 3 3 1 7
 * <p>
 * Given (2, 1) return 10.
 */
public class MatrixLength {
    static boolean[][] visited;

    static int xMin, yMin, xMax, yMax;

    static int length = 0;

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 3, 4}, {0, 3, 0, 1, 7}, {0, 3, 0, 1, 7}, {0, 3, 3, 1, 7},};
        System.out.println(getLength(matrix, 2, 1));
    }

    private static int getLength(int[][] matrix, int x, int y) {
        if(matrix == null || x >= matrix.length || y >= matrix[0].length)
            return 0;
        int target = matrix[x][y];
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new boolean[m][n];
        xMin = x;
        xMax = x;
        yMin = y;
        yMax = y;
        update();
        bfs(matrix, x, y, target);
        return length;
    }

    private static boolean bfs(int[][] matrix, int x, int y, int target) {
        if(x >= matrix.length || y >= matrix[0].length)
            return false;
        if(visited[x][y])
            return false;
        if(matrix[x][y] != target)
            return false;
        xMax = Math.max(xMax, x);
        xMin = Math.min(xMin, x);
        yMax = Math.max(yMax, y);
        yMin  = Math.min(yMin, y);
        update();
        visited[x][y] = true;
        boolean res = bfs(matrix, x + 1, y, target) || bfs(matrix, x - 1, y, target)
                || bfs(matrix, x, y + 1, target) || bfs(matrix, x, y - 1, target);
        visited[x][y] = false;
        return res;
    }

    private static void update() {
        int len = ((xMax - xMin + 1) + (yMax - yMin + 1)) * 2;
        length = Math.max(length, len);
    }

}
