package graphs;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        int row= flights.length;
        int col= 3;

        //col 0->k will be for stops
        int[][] w= new int[n][k+2];
        for(int i=0; i<n; i++) Arrays.fill(w[i], Integer.MAX_VALUE);

        w[src][0]= 0;

        for(int i=0; i<row; i++){
            int u= flights[i][0];
            int v= flights[i][1];
            int c= flights[i][2];

            adj.get(u).add(new int[]{v,c});
        }

        PriorityQueue<Triplet> pq= new PriorityQueue<>(
                (a,b) -> Integer.compare(a.cost, b.cost)
        );

        pq.add(new Triplet(src,0,0));

        while(!pq.isEmpty()){
            Triplet t= pq.poll();
            int node= t.node;
            int cost= t.cost;
            int stop= t.stop;

            if(stop>k) continue;

            for(int[] curr:adj.get(node)){
                int neighbour= curr[0];
                int tc= curr[1]+cost;
                int newStop= stop+1;

                if(newStop < w[0].length && w[neighbour][newStop]>tc){
                    w[neighbour][newStop]= tc;
                    pq.add(new Triplet(neighbour, tc, stop+1));
                }
            }
        }

        int ans= Integer.MAX_VALUE;
        for(int i=0; i<w[dest].length; i++){
            ans= Math.min(ans, w[dest][i]);
        }

        if(ans== Integer.MAX_VALUE) return -1;

        return ans;
    }

    class Triplet{
        int node, cost, stop;

        Triplet(int node, int cost, int stop){
            this.node= node;
            this.cost= cost;
            this.stop= stop;
        }
    }
}