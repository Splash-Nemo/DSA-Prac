package graphs;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n= points.length;

        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int x1= points[i][0];
                int x2= points[j][0];

                int y1= points[i][1];
                int y2= points[j][1];

                int w= Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.get(i).add(new int[]{j,w});
                adj.get(j).add(new int[]{i,w});
            }
        }

        boolean[] vis= new boolean[n];
        int sum= 0;

        PriorityQueue<Triplet> pq= new PriorityQueue<>(
                (a,b) -> Integer.compare(a.weight, b.weight)
        );

        pq.add(new Triplet(0,-1,0));

        while(!pq.isEmpty()){
            Triplet t= pq.poll();
            int node= t.node, parent= t.parent, weight= t.weight;

            if(vis[node]) continue;

            sum+= weight;

            for(int[] curr : adj.get(node)){
                int neigh= curr[0];
                int we= curr[1];

                if(!vis[neigh]){
                    pq.add(new Triplet(neigh, node, we));
                }
            }

            vis[node]= true;
        }

        return sum;
    }

    class Triplet{
        int node, parent, weight;

        Triplet(int node, int parent, int weight){
            this.node= node;
            this.parent= parent;
            this.weight= weight;
        }
    }
}
