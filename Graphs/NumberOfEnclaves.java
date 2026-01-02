package Graphs.problems;

public class NumberOfEnclaves {
    int[][] directions = {
            {-1, 0} , {1, 0} , {0,1} , {0,-1}
    };

    public  void  dfs(int[][] grid , int x , int y , boolean[][]  vis , int n , int m  ){
        vis[x][y] = true;
        for (int d[]:directions){
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx >=0 && ny>=0 && nx<n && ny<m && !vis[nx][ny] && grid[nx][ny] == 1){
                dfs(grid , nx , ny , vis , n , m);
            }
        }
    }
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                dfs(grid, 0, j, vis, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                dfs(grid, i, 0, vis, n, m);
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[n - 1][j] == 1  && !vis[n - 1][j]) {
                dfs(grid, n - 1, j, vis, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(grid, i, m - 1, vis, n, m);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    cnt++;
                }
            }

        }
        return  cnt;
    }
}
