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
	static int [][] virus;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};	
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(ans);
	}
	
	private static void dfs(int wall) {
		// 벽 세우기
		if(wall == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(wall+1);
					map[i][j] = 0;
				}
			}
		}
	}
	private static void bfs() {
		// 바이러스 퍼트리기
		Queue<Loc> q = new LinkedList<>();
		virus = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				virus[i][j] = map[i][j];
				if(virus[i][j] == 2) {
					q.add(new Loc(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				
				if(virus[nr][nc]==0) {
					virus[nr][nc] = 2;
					q.add(new Loc(nr, nc));
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus[i][j]==0) {
					cnt++;
				}
			}
		}
		
		ans = Math.max(ans, cnt);
	}
}
