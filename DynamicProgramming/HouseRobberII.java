// house robber 2
class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        else if(n==2) return Math.max(nums[0], nums[1]);

        int first= steal(nums, 0, n-1);
        int sec= steal(nums, 1, n);

        return Math.max(first, sec);
    }

    public int steal(int[] nums, int i, int n){

        int[] ans= new int[n];

        ans[i]= nums[i];
        ans[i+1]= Math.max(nums[i], nums[i+1]);

        for(i+=2; i<n; i++) ans[i]= Math.max(nums[i]+ans[i-2], ans[i-1]);

        return ans[n-1];
    }
}