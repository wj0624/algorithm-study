import java.io.*;
import java.util.*;
public class Main {
	static int L, R, C;
	static char[][][] map;
	static boolean[][][] visited;
	static class Loc{
		int l, r, c, time;
		public Loc(int l, int r, int c, int time) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	// 동, 서, 남, 북
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dl = {0, 0, 0, 0, -1, 1};
	static int ans;
	static Queue<Loc> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.isEmpty()) continue;
			StringTokenizer st = new StringTokenizer(s);
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0&&R==0&&C==0) break;
			
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			q = new LinkedList<>();
			ans=-1;
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					s = br.readLine();
					if(s.isEmpty()) {
						j--;
						continue;
					}
					for(int k=0; k<C; k++) {
						map[i][j][k] = s.charAt(k);
						if(map[i][j][k]=='S') {
							q.add(new Loc(i, j, k, 0));
							visited[i][j][k] = true;
						}
						else if(map[i][j][k] == '#') {
							visited[i][j][k] = true;	// 지나갈 수 없는 칸이므로 방문처리
						}
					}
				}
			}
			
			bfs();
			if(ans==-1) {
				System.out.println("Trapped!");
			}
			else {
				System.out.println("Escaped in "+ans+" minute(s).");
			}
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			if(map[cur.l][cur.r][cur.c]=='E') {
				ans = cur.time;
				return;
			}
			for(int i=0; i<6; i++) {
				int nl = cur.l + dl[i];
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nr>=R||nc<0||nc>=C||nl<0||nl>=L) continue;
				
				if(!visited[nl][nr][nc]) {
					visited[nl][nr][nc] = true;
					q.add(new Loc(nl, nr, nc, cur.time+1));
				}
			}
		}
	}
}