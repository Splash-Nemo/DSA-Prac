package greedy;
class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        if(n==1 || n==0 || nums[0]==0) return 0;

        int jumps= 0, curr= 0, max= 0;
        for(int i=0; i<n-1; i++){
            max= Math.max(max, nums[i]+i);

            if(i==curr){
                jumps+=1;
                curr= max;
            }
        }

        return jumps;
    }
}