class Solution {
    int minCost(int[] height) {
        // code here
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);

        int ans= solve(height, 0, height.length, dp);
        return ans;
    }

    int solve(int[] arr, int i, int n, int[] dp){
        if(i>=n-1) return 0;
        if(dp[i]!=-1) return dp[i];

        int a= Integer.MAX_VALUE, b= Integer.MAX_VALUE;

        if(i<n-1)
            a= Math.abs(arr[i] - arr[i+1]) + solve(arr, i+1, n, dp);

        if(i<n-2)
            b= Math.abs(arr[i] - arr[i+2]) + solve(arr, i+2, n, dp);

        dp[i]= Math.min(a,b);

        return Math.min(a,b);
    }
}