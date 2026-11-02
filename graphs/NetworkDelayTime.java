package graphs;

class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj= new ArrayList<>();

        for(int i=1; i<=100; i++){
            adj.add(new ArrayList<>());
        }

        int[] dis= new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[src]= 0;

        PriorityQueue<Pair> pq= new PriorityQueue<>(
                (a,b) -> Integer.compare(a.d,b.d)
        );

        pq.add(new Pair(src, dis[src]));

        for(int i=0; i<times.length; i++){
            int u= times[i][0];
            int v= times[i][1];
            int w= times[i][2];

            adj.get(u).add(new Pair(v,w));
        }

        int ans= -1;

        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int node= p.node;
            int d= p.d;

            if(d> dis[node]) continue;

            for(Pair curr: adj.get(node)){
                int v= curr.node;
                int td= curr.d + d;

                if(dis[v] > td){
                    dis[v]= td;
                    pq.add(new Pair(v,td));
                }
            }
        }

        for(int i=1; i<dis.length; i++){
            ans= Math.max(ans, dis[i]);
        }

        if(ans==Integer.MAX_VALUE) return -1;

        return ans;
    }

    class Pair{
        int node, d;
        Pair(int node, int d){
            this.node= node;
            this.d= d;
        }
    }
}