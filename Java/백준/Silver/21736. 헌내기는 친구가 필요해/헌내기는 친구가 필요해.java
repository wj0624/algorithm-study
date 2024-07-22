import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static boolean [][] visited;
	static char [][] map;
	static int ans = 0;
	static Queue<Loc> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char [N][M];
		visited = new boolean [N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='I') {
					q.add(new Loc(i, j));
					visited[i][j] = true;
				}
				else if(map[i][j]=='X') {
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		System.out.println(ans > 0 ? ans : "TT");
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nr>=N||nc<0||nc>=M||visited[nr][nc]) continue;
				
				if(map[nr][nc] == 'P') {
					ans++;
				}
				
				visited[nr][nc] = true;
				q.add(new Loc(nr, nc));
			}
		}
	}

}
