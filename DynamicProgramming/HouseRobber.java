class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp= new int[n];

        Arrays.fill(dp, -1);

        return amt(nums,0,dp);
    }

    public int amt(int[] nums, int i, int[] dp){
        if(i>=nums.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int take= nums[i] + amt(nums, i+2, dp);
        int skip= amt(nums,i+1,dp);

        return dp[i]= Math.max(take, skip);
    }

    /*
        int n= nums.length;
        if(n==1) return nums[0];

        nums[1]= Math.max(nums[1], nums[0]);
        for(int i=2; i<n; i++) nums[i]= Math.max(nums[i-1], nums[i]+nums[i-2]);

        return nums[n-1];
    */

    /* 
        int n= nums.length;
        if(n==1) return nums[0];


        int[] ans= new int[n];

        ans[0]= nums[0];
        ans[1]= Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++) ans[i]= Math.max(nums[i]+ans[i-2], ans[i-1]);

        return ans[n-1];
    */
}