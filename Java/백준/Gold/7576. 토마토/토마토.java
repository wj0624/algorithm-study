import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [][] box;
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	static class Loc {
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Queue<Loc> tomato = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==1) {
					tomato.add(new Loc(i,j));
				}
			}
		}
		
		System.out.println(bfs());
	}
	private static int bfs() {
		while(!tomato.isEmpty()) {
			Loc cur = tomato.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(box[nr][nc]==0) {
					tomato.add(new Loc(nr,nc));
					box[nr][nc] = box[cur.r][cur.c]+1;
				}
			}
		}
		
		int ans = Integer.MIN_VALUE;
		if(checkZero()) {
			return -1;
		}
		else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(ans<box[i][j]) {
						ans = box[i][j];
					}
				}
			}
			return ans-1;
		}
	}
	private static boolean checkZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==0) {
					return true;
				}
			}
		}
		return false;
	}

}
