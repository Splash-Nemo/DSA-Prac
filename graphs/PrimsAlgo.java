package graphs;

class Solution {
    public int primMST(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // code here
        //adj.get(i).add(new ArrayList<>())
        int n= adj.size();
        int src= 0;

        boolean[] vis= new boolean[n];

        PriorityQueue<Triplet> pq= new PriorityQueue<>(
                (a,b) -> Integer.compare(a.weight, b.weight)
        );

        pq.add(new Triplet(0,-1,0));
        int sum= 0;

        while(!pq.isEmpty()){
            Triplet t= pq.poll();
            int node= t.node, parent= t.parent, weight= t.weight;

            if(vis[node]) continue;

            sum+= weight;

            for(List<Integer> curr: adj.get(node)){
                int neigh= curr.get(0);
                int w= curr.get(1);

                if(!vis[neigh]){
                    pq.add(new Triplet(neigh, node, w));
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
