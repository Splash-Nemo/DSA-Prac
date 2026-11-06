class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m || i < n; i++) {

            if (i < n)
                dp[0][i] = matrix[0][i];

            if (i < m)
                dp[i][0] = matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if(matrix[i][j]==0) continue;

                if (matrix[i-1][j] == 1 && matrix[i][j-1] == 1 && matrix[i][j] == 1 && matrix[i - 1][j - 1] == 1)
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                else
                    dp[i][j] = matrix[i][j];
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0)
                    ans += dp[i][j];
                // System.out.print(dp[i][j] + " ");
            }

            // System.out.println();
        }

        return ans;
    }
}