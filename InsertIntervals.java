class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rec= new ArrayList<>();

        int i=0, n= intervals.length;
        for(; i<n; i++){
            if(intervals[i][1]<newInterval[0]) rec.add(new int[]{intervals[i][0],intervals[i][1]});
            else break;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
            i+=1;
        }

        rec.add(new int[]{newInterval[0], newInterval[1]});

        while(i<n){
            rec.add(new int[]{intervals[i][0], intervals[i][1]});
            i+=1;
        }
        
        int[][] ans= new int[rec.size()][2];
        int x= 0;

        for(int[] j: rec){
            ans[x]= j;
            x+=1;
        }

        return ans;
    }
}

/*
    1. Add intervals where start time is less than the new interval's start time. 

    2. Then, merge all intervals that overlap with the new interval:-
        check if the current interval's start time is less than or equal to the new interval's end time. If it is, update the new interval's start and end times to be the minimum and maximum of the two intervals, respectively

    3. Finally, add the remaining intervals to the result 
*/