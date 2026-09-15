class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int n= bt.length;
        
        if(n==1) return 0;
        
        int[] tat= new int[n];
        tat[0]= bt[0];
        
        for(int i=1; i<n; i++) tat[i]= bt[i]+tat[i-1];
        
        int wt= 0;
        
        for(int i=0; i<n; i++){
            wt+= tat[i]-bt[i];
        }
        
        return wt/n;
    }
}
