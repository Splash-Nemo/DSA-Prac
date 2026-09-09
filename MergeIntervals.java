class Solution {
    public int[][] merge(int[][] intervals) {
        int n= intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> rec= new ArrayList<>();

        int[] curr= intervals[0];
        rec.add(curr);

        for(int i=1; i<n; i++){
            int currEnd= curr[1];
            int nextStart= intervals[i][0];
            int nextEnd= intervals[i][1];

            if(currEnd >= nextStart){
                curr[0]= Math.min(curr[0], nextStart);
                curr[1]= Math.max(nextEnd, curr[1]);
            }else{
                curr= intervals[i];
                rec.add(curr);
            }
        }

        int[][] ans= new int[rec.size()][2];
        int x= 0;

        for(int[] i: rec){
            ans[x++]= i;
        }

        return ans;
    }
}