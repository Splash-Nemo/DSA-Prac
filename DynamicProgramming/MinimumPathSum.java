class Solution {
    public int minPathSum(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;

        int[][] dp = new int[row][col];

        dp[0][0] = arr[0][0];

        // First row
        for (int i = 1; i < col; i++) {
            dp[0][i] = arr[0][i] + dp[0][i - 1];
        }

        // First column
        for (int i = 1; i < row; i++) {
            dp[i][0] = arr[i][0] + dp[i - 1][0];
        }

        // Remaining cells
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[row - 1][col - 1];
    }
}