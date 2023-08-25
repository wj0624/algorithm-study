import java.io.*;
import java.util.*;

public class day9 {
	//원래 위치, 상, 하, 좌, 우
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	static int N, K, max;
	static char[][] map;	//원래 주어진 지도
	static int[][] score;	//점수 기록
	static Queue<loc> bomb;	//폭탄 떨어질 곳의 좌표
	static class loc{
		int y, x;
		public loc(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		max = 0;
		map = new char[N][N];
		score = new int[N][N];
		bomb = new ArrayDeque<>();
		for(int i=0; i<N; i++){
			String str = br.readLine();
			str = str.replace(" ", "");
			for(int j=0; j<N; j++){
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			bomb.add(new loc(y, x));
		}
		bfs();
		System.out.println(max);
		br.close();		
	}
	static void bfs(){
		while(!bomb.isEmpty()) {
			loc cur = bomb.poll();
			for(int i=0; i<5; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;
				
				if(ny<0||nx<0||ny>=N||nx>=N||map[ny][nx]=='#') continue;
				if(map[ny][nx] == '0') {
					score[ny][nx] += 1;
					max = Math.max(max, score[ny][nx]);
				}
				else if(map[ny][nx]=='@') {
					score[ny][nx] += 2;
					max = Math.max(max, score[ny][nx]);
				}
			}
		}
	}
}