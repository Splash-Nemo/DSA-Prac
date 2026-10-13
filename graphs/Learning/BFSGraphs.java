package graphs.Learning;

import java.util.*;

public class BFSGraphs{
    public static void main(String[] args){
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<9; i++) list.add(new ArrayList<>());

        list.add(1, Arrays.asList(2,3));
        list.add(2, Arrays.asList(5,6));
        list.add(3, Arrays.asList(7));
        list.add(4, Arrays.asList(1,7));
        list.add(5, Arrays.asList(2));
        list.add(6, Arrays.asList(2));
        list.add(7, Arrays.asList(8));
        list.add(8, Arrays.asList(7));

        boolean[] vis= new boolean[9];
        BFS(4, vis, list);
    }

    public static void BFS(int node, boolean[] vis, List<List<Integer>> list){
        vis[node]= true;
        Queue<Integer> queue= new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int k= queue.poll();
            System.out.print(k+" ");

            for(int n:list.get(k)){
                if(!vis[n]){
                    vis[n]= true;
                    queue.add(n);
                }
            }
        }
    }
}