package algorithm;

import java.io.*;
import java.util.*;

public class P3055{
	static int R, C, time;
	static char[][] map;
	static char[][] visit;
	
	static Queue<loc> go;
	static Queue<loc> water;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	static class loc{
		int y, x;

		public loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new char [R][C];
		
		go = new ArrayDeque<>();
		water = new ArrayDeque<>();
		
		String in;
		for(int i=0; i<R; i++) {
			in = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = in.charAt(j);
				if(map[i][j]=='*') {
					visit[i][j] = 'x';
					water.add(new loc(i,j));
				}
				else if(map[i][j]=='X') {
					visit[i][j] = 'x';
				}
				else if(map[i][j]=='D') {
					visit[i][j] = 'g';
				}
				else if(map[i][j]=='S') {
					visit[i][j] = 'x';
					map[i][j] = '.';
					go.add(new loc(i,j));
				}
				else if(map[i][j]=='.') {
					visit[i][j] = 'o';
				}
			}
		}
		
		bfs();
		
		if(time==-1) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(time);
		}
		
		br.close();
	}
	
	static void bfs() {
		for(time=1; ;time++) {
			//¹°
			int wsize = water.size();
			for(int i=0; i<wsize; i++) {
				loc cur = water.poll();
				
				for(int j=0; j<4; j++) {
					int nr = cur.y + dr[j];
					int nc = cur.x + dc[j];
					
					if(nr<0||nc<0||nr>=R||nc>=C) {
						continue;
					}
					
					if(map[nr][nc]=='.') {
						map[nr][nc] = '*';
						water.add(new loc(nr, nc));
					}
				}
			}
			
			int gsize = go.size();
			if(gsize == 0) {
				time = -1;
				return;
			}
			
			for(int i=0; i<gsize; i++) {
				loc cur = go.poll();
				
				for(int j=0; j<4; j++) {
					int nr = cur.y + dr[j];
					int nc = cur.x + dc[j];
					
					if(nr<0||nc<0||nr>=R||nc>=C) {
						continue;
					}
					
					if(map[nr][nc]=='D') {
						return;
					}
					else if(map[nr][nc]=='.' && visit[nr][nc]=='o') {
						visit[nr][nc] = 'x';
						go.add(new loc(nr, nc));
					}
				}
			}
		}
	}
}