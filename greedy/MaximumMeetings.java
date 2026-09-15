class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        
        int n= s.length;
        if(n==1) return new ArrayList<>(1);
        
        ArrayList<int[]> rec= new ArrayList<>();
        
        for(int i=0; i<n; i++) rec.add(new int[]{s[i],f[i],i+1});
        
        rec.sort(Comparator.comparingInt(a->a[1]));
        
        ArrayList<Integer> ans= new ArrayList<>();
        
        ans.add(rec.get(0)[2]);
        int ei= 0;
        
        for(int i=1; ei < n && i<n; i++){
            if(rec.get(i)[0] > rec.get(ei)[1]){
                ans.add(rec.get(i)[2]);
                ei=i;
            }
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}