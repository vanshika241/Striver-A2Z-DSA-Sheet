package Graphs.problems;

import java.util.ArrayList;

public class UndirectedCycleDFS {

    public  boolean dfs(ArrayList<ArrayList<Integer>> adj , boolean vis[] , int node , int parent ){
        vis[node] = true;
        for(int i=0;i<adj.get(node).size();i++){
            if(!vis[adj.get(node).get(i)]){
               return dfs(adj , vis , adj.get(node).get(i) , node );
            }
            else if (adj.get(node).get(i) != parent){
                return  true;
            }
        }
        return false;
    }
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj , int N){
        boolean vis[] = new boolean[N+1];
        return  dfs(adj , vis , 1 , -1);
    }
}
