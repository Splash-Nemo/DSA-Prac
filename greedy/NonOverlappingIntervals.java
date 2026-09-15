class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n= intervals.length;

        int count= 0;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));

        int[] curr= {intervals[0][0], intervals[0][1]};

        for(int i=1; i<n; i++){
            if(curr[1]>intervals[i][0]) count+=1;
            else{
                curr[0]= intervals[i][0];
                curr[1]= intervals[i][1];
            }
        }

        return count;
    }
}