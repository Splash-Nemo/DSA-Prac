package greedy;
class Solution {
    public ArrayList<Integer> jobSequencing(int[] d, int[] p) {
        
         int n = d.length;
         List<int[]> rec = new ArrayList<>();
         int maxD = 0;

         for (int i = 0; i < n; i++) {
             rec.add(new int[]{d[i], p[i]});
             maxD = Math.max(maxD, d[i]);
         }

         rec.sort((a, b) -> Integer.compare(b[0], a[0]));

         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

         int count = 0;
         int maxProfit = 0;
         int j = 0;

         for (int slot = maxD; slot > 0; slot--) {

             while (j < n && rec.get(j)[0] >= slot) {
                 maxHeap.add(rec.get(j)[1]);
                 j++;
             }

             if (!maxHeap.isEmpty()) {
                 maxProfit += maxHeap.poll();
                 count++;
             }
         }

         ArrayList<Integer> ans = new ArrayList<>();
         ans.add(count);
         ans.add(maxProfit);
         
         return ans;
     }
 }
