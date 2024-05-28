import java.io.*;
import java.util.*;
public class Main {
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}
	private static void bfs(int r, int c) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(r,c));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(visited[nr][nc] || map[nr][nc]==0) continue;
				
				q.add(new Loc(nr, nc));
				map[nr][nc] = map[cur.r][cur.c]+1;
				visited[nr][nc] = true;
			}
		}
	}

}
