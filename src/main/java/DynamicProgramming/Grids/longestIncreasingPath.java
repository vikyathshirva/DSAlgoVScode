package DynamicProgramming.Grids;
import java.util.Arrays;


public class longestIncreasingPath {
    public int longestIncreasingPath(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][]dp = new int[rows][cols];
        for(int[] dpr : dp) Arrays.fill(dpr,-1);
        for(int row = 0;row<rows;row++) {
            for(int col=0;col<cols;col++) {
                if(dp[row][col] == -1) {
                    dfsmat(mat, dp, rows, cols,  row, col, -1);
                }
            }
        }

        int max = Integer.MAX_VALUE;
        for(int[] dpr: dp) {
            for(int dpi : dpr) max = Math.max(max, dpi);
        }

        return max;
    }


    public int dfsmat(int[][] mat, int[][] dp, int rows, int cols, int row, int col, int parent) {

        if(row >= rows || col >= cols || row < 0 || col < 0 || mat[row][col] <= parent) return 0;

        parent = mat[row][col];
        if(dp[row][col] != -1) return dp[row][col];

        int left = dfsmat(mat, dp, rows, cols, row, col-1, parent);
        int right = dfsmat(mat, dp, rows, cols, row, col+1, parent);
        int down = dfsmat(mat, dp, rows+1, cols, row, col, parent);
        int up = dfsmat(mat, dp, rows-1, cols, row, col-1, parent);
        dp[row][col] = 1 + Math.max(Math.max(left, right), Math.max(up, down));

        return dp[row][col];
    }
    
}
