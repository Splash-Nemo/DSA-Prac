package graphs;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] suc, int sn, int en) {
        double ans= 0;

        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        double[] cost= new double[n];
        Arrays.fill(cost, 0);

        cost[sn]= 1;

        for(int i=0; i<edges.length; i++){
            int u= edges[i][0];
            int v= edges[i][1];
            double w= suc[i];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>(
                (a,b) -> Double.compare(b.d, a.d)
        );

        pq.add(new Pair(sn, 1));

        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int node= p.node;
            double dis= p.d;

            if(dis<cost[node]) continue;

            for(Pair curr: adj.get(node)){
                int nd= curr.node;
                double td= (curr.d)*(dis);

                if(td > cost[nd]){
                    cost[nd]= td;
                    pq.add(new Pair(nd, td));
                }
            }
        }

        return cost[en];
    }
    class Pair{
        int node;
        double d;

        Pair(int node, double d){
            this.node= node;
            this.d= d;
        }
    }
}