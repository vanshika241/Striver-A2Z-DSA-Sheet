package Graphs.learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public  class BFS {

    public  static  ArrayList<Integer>  bfs(ArrayList<ArrayList<Integer>> adj , int N){
        boolean[] vis = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        ArrayList<Integer> ansList = new ArrayList<>();
        vis[1] = true;
        while (!q.isEmpty()){
            int curr = q.poll();
            ansList.add(curr);
            for(int i=0;i<adj.get(curr).size();i++){
                if(!vis[adj.get(curr).get(i)]){
                    vis[adj.get(curr).get(i)] = true;
                    q.add(adj.get(curr).get(i));
                }
            }
        }
        return ansList;
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

        System.out.println("BFS of Graph is "+bfs(adj , N));
    }
}