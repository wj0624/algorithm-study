import java.io.*;
import java.util.*;
class Solution {
    static int[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;
    static class Loc {
        int r, c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        visited[0][0] = 1;
        return bfs(maps);
    }
    static int bfs(int[][] maps){
        Queue<Loc> q = new ArrayDeque<>();
        q.add(new Loc(0, 0));
        while(!q.isEmpty()){
            Loc cur = q.poll();
            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0||nr>=n||nc<0||nc>=m) continue;
                if(visited[nr][nc]==0&&maps[nr][nc]==1){
                    q.add(new Loc(nr, nc));
                    visited[nr][nc] = visited[cur.r][cur.c]+1;
                }
            }
        }
        return (visited[n-1][m-1] == 0) ? -1 : visited[n-1][m-1];
    }
}