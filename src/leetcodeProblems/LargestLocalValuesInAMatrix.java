package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 2024.0.0
 */
public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid.length - 1; j++) {
                ans[i - 1][j - 1] = calculateMax(grid, i, j);
            }
        }

        return ans;
    }

    private int calculateMax(int[][] grid, int x, int y) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                maxValue = Math.max(maxValue, grid[i][j]);
            }
        }

        return maxValue;
    }
}
