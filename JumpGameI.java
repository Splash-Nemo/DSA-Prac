class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;

        if(nums[0]==0 && n!=1) return false;

        if(n==1) return true;

        int max=0;

        for(int i=0; i<n; i++){ 
            if(i>max) return false;

            max= Math.max(max, nums[i]+i);
            if(max>=n-1) return true;
        }

        return false;
    }
}