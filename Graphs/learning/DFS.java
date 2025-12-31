package Graphs.learning;

import java.util.ArrayList;

public class DFS {

    public  static  void  dfs(ArrayList<ArrayList<Integer>> adj , int Node , ArrayList<Integer> ans , boolean vis[]){
        vis[Node] = true;
        ans.add(Node);
        for(int i=0;i<adj.get(Node).size();i++){
            if(!vis[adj.get(Node).get(i)]) {
                dfs(adj, adj.get(Node).get(i), ans, vis);
            }
        }
    }
    public  static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) {

        int N = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 6);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 9);
        addEdge(adj, 7, 8);
        addEdge(adj, 5, 8);

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[N+1];
        int startingNode = 1;
        dfs(adj , startingNode , ans , vis);
        System.out.println("DFS of Graph is "+ans);
    }
}
