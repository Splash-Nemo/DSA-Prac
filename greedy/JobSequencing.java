package greedy;
class Solution {
    public ArrayList<Integer> jobSequencing(int[] d, int[] p) {
        // code here
        
        int maxD= 0;
        for(int i:d) maxD= Math.max(i,maxD);
        
        int count= 0, maxProfit= 0;
        
        List<int[]> rec= new ArrayList<>();
        int n= d.length;
        
        for(int i=0; i<n; i++) rec.add(new int[]{d[i], p[i]});
        
        rec.sort(Comparator.comparingInt((int[] a) -> a[1]).reversed());
        
        int[] slots= new int[maxD+1];
        
        for(int i=0; i<rec.size(); i++){
            int deadline= rec.get(i)[0];
            int profit= rec.get(i)[1];
            
            int j=deadline;
            while(j>0){
                if(slots[j]==0){
                    slots[j]=1;
                    count+=1;
                    maxProfit+=profit;
                    break;
                }
                
                j-=1;
            }
        }
        
        
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(count);
        ans.add(maxProfit);
        
        return ans;
    }
}