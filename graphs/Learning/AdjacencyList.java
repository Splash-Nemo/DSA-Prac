package graphs.Learning;
import java.util.*;

public class AdjacencyList {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();

        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u= sc.nextInt();
            int v= sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        sc.close();
    }
}
