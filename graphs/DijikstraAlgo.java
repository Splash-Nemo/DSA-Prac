package graphs;

class Solution {
    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj,
                                       int src) {
        // code here
        int n= adj.size();

        PriorityQueue<int[]> pq= new PriorityQueue<>(
                (a,b) -> Integer.compare(a[0],b[0])
        );

        ArrayList<Integer> d= new ArrayList<>();
        for(int i=0; i<n; i++) d.add(Integer.MAX_VALUE);

        d.set(src, 0);
        pq.add(new int[]{0,src});

        while(!pq.isEmpty()){
            int[] curr= pq.poll();

            int dis= curr[0];
            int node= curr[1];

            if(dis>d.get(node)) continue;

            for(ArrayList<Integer> k: adj.get(node)){
                int v= k.get(0); // node
                int w= k.get(1); // weight

                if(d.get(v) > w+dis){
                    d.set(v, w+dis);
                    pq.add(new int[]{d.get(v), v});
                }
            }
        }

        return d;
    }
}
