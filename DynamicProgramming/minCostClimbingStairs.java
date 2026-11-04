class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] ans= new int[cost.length+1];
        ans[0]= cost[0];
        ans[1]= cost[1];

        int n= cost.length;

        for(int i=2; i<n; i++){
            ans[i]= cost[i] + Math.min(ans[i-2], ans[i-1]);
        }

        ans[n]= Math.min(ans[n-1], ans[n-2]);

        return ans[n];
    }
}