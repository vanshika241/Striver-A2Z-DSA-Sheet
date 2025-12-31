
package Graphs.learning;


public  class AdjacencyMatrixRep {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int adj[][] = new int[n+1][n+1];
        adj[1][2] = 1;
        adj[2][1] = 1;
        adj[1][3] = 1;
        adj[3][1] = 1;
        adj[3][4] = 1;
        adj[4][3] = 1;
        adj[2][4] = 1;
        adj[4][2] = 1;
        adj[2][5] = 1;
        adj[5][2] = 1;
        adj[4][5] = 1;
        adj[5][4] = 1;

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}