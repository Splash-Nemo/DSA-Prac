package graphs.Learning;
import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();

        int[][] graph= new int[n+1][n+1];
        
        for(int i=0; i<m; i++){
            int u= sc.nextInt();
            int v= sc.nextInt();

            graph[u][v]= 1;
            graph[v][u]= 1;
        }

        sc.close();
    }
}
