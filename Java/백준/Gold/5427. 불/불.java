import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	static int w, h;
	static class Loc {
		int r, c, t;
		public Loc(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	static Queue<Loc> sg;	// 상근이
	static Queue<Loc> fire;	// 불
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			// 1. 입력 및 초기화
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new char[h][w];
			sg = new ArrayDeque<>();
			fire = new ArrayDeque<>();
			
			// 2. 지도 초기화
			for(int i=0; i<h; i++) {
				String str = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						fire.add(new Loc(i, j, 0));
					}
					else if(map[i][j] == '@') {
						sg.add(new Loc(i, j, 0));
					}
				}
			}
			
			// 3. 빌딩 탈출(bfs) 및 답 저장
			sb.append(bfs()+'\n');
		}
		
		// 4. 정답 출력
		System.out.println(sb.toString());
	}
	static String bfs() {		
		while(!sg.isEmpty()) {
			// 불 번지기
			int fireSize = fire.size();
			for(int f=0; f<fireSize; f++) {
				Loc curF = fire.poll();
				for(int i=0; i<4; i++) {
					int nr = dr[i] + curF.r;
					int nc = dc[i] + curF.c;
					
					if(nr<0 || nr>=h || nc<0 || nc>=w) continue;
					if(map[nr][nc] == '.' || map[nr][nc] == '@') {
						map[nr][nc] = '*';
						fire.add(new Loc(nr, nc, 0));
					}
				}
			}
			
			// 상근이 이동
			int sgSize = sg.size();
			for(int s=0; s<sgSize; s++) {
				Loc curSG = sg.poll();
				for(int i=0; i<4; i++) {
					int nr = dr[i] + curSG.r;
					int nc = dc[i] + curSG.c;
					
					// 탈출
					if(nr<0 || nr>=h || nc<0 || nc>=w) {
						return String.valueOf(curSG.t+1);
					}
					
					if(map[nr][nc] == '.') {
						map[nr][nc] = '@';	// 이동 표시
						sg.add(new Loc(nr, nc, curSG.t+1));
					}
				}
			}
		}
		return "IMPOSSIBLE";
	}
}