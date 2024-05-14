package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 5/14/2024
 */
public class PathWithMaximumGold {

    int[][] visited;

    public int getMaximumGold(int[][] grid) {
        int maxCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited = new int[grid.length][grid[0].length];

                if (grid[i][j] != 0) {
                    maxCount = Math.max(maxCount, floodfill(grid, i, j));
                }
            }
        }

        return maxCount;
    }

    private int floodfill(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        visited[i][j] = 1;

        int maxCount = grid[i][j];
        if (i + 1 < grid.length && visited[i + 1][j] == 0 && grid[i + 1][j] != 0) {
            maxCount = Math.max(maxCount, grid[i][j] + floodfill(grid, i + 1, j));
        }
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && grid[i - 1][j] != 0) {
            maxCount = Math.max(maxCount, grid[i][j] + floodfill(grid, i - 1, j));
        }
        if (j + 1 < grid[0].length && visited[i][j + 1] == 0 && grid[i][j + 1] != 0) {
            maxCount = Math.max(maxCount, grid[i][j] + floodfill(grid, i, j + 1));
        }
        if (j - 1 >= 0 && j - 1 < grid[0].length && visited[i][j - 1] == 0 && grid[i][j - 1] != 0) {
            maxCount = Math.max(maxCount, grid[i][j] + floodfill(grid, i, j - 1));
        }

        visited[i][j] = 0;
        return maxCount;
    }
}
