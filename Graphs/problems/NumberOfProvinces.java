package Graphs.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfProvinces {

    public  static  int cntProvinces(int[][] isConnected){
        int cnt = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                //dfs(isConnected , vis , i);
                bfs(isConnected , vis , i);
            }
        }
        return  cnt;
    }

    private static void dfs(int[][] isConnected, boolean[] vis, int Node) {
        vis[Node] = true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[Node][j] == 1 && !vis[j]){
                dfs(isConnected , vis ,j);

            }
        }
    }

    public  static  void  bfs(int[][] isConnected , boolean[] vis , int Node){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(Node);
        while (!q.isEmpty()){
            int curr = q.poll();
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[curr][j] == 1 && !vis[j]){
                    vis[j] = true;
                    q.add(j);
                }
            }
        }

    }

}
