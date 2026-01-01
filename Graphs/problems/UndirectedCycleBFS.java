package Graphs.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class UndirectedCycleBFS {
    public  boolean detectCycle(ArrayList<ArrayList<Integer>> adj  , int N){
        Queue<int[]> q  = new ArrayDeque<>();
        q.add(new int[]{1 , -1});
        boolean vis[] = new boolean[N+1];
        while (!q.isEmpty()){
            int curr[] = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int i =0;i<adj.get(node).size();i++){
                if(!vis[adj.get(node).get(i)]){
                    vis[adj.get(node).get(i)] = true;
                    q.add(new int[]{adj.get(node).get(i) , node});
                }
                else{
                    if(adj.get(node).get(i) != parent){
                        return  true;
                    }
                }
            }
        }
        return  false;
    }
}
