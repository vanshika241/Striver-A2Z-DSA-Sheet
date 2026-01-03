package Graphs.problems;

import java.util.ArrayList;
import java.util.HashSet;

public class DistinctIslands {

    int[][] directions = {
            {-1, 0} , {1, 0} , {0,1} , {0,-1}
    };
    void dfs(int[][] grid , boolean[][] vis , int n , int m , int i , int j , int baseRow , int baseCol ,  ArrayList<ArrayList<Integer>> values){
        vis[i][j] = true;
        for(int d[] : directions){
            int nx = d[0]+i;
            int ny  = d[1]+j;
            if ( nx>=0 && ny>=0 && nx<n && ny <m && !vis[nx][ny] && grid[nx][ny] == 1){
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(nx-baseRow);
                curr.add(ny-baseCol);
                values.add(curr);
                dfs(grid , vis , n , m , nx , ny ,baseRow , baseCol, values);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        HashSet<ArrayList<ArrayList<Integer>>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (!vis[i][j] && grid[i][j] == 1){
                    ArrayList<ArrayList<Integer>> values = new ArrayList<>();
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add(0);
                    curr.add(0);
                    values.add(curr);
                    dfs(grid , vis , n, m , i , j , i , j , values );
                    if (!set.contains(values)){
                        set.add(values);
                        cnt++;
                    }

                }
            }
        }
        return  cnt;

    }
}
