package algorithm;
import java.io.*;
import java.util.*;

// 위치 class
class location{
	int y, x;
	// Alt + Shift + s
	public location(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}

public class D1_3055 {
	
	private static final String FAIL = "KAKTUS";
	
	static int R, C;
	static int time;
	
	//up, down, left, right
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	
	static char [][] map;
	static char [][] visit;
	
	static Queue<location> water; //물 위치
	static Queue<location> loc; //고슴도치 위치
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); //공백 단위 끊기
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		map = new char[R][C];
		visit = new char[R][C];
		
		String str; //input용 임시변수
		
		loc = new LinkedList<location>();
		water = new LinkedList<location>();
		
		
		for(int i=0; i<R; i++) {
			str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					visit[i][j] = 'x'; //물이 있는 곳은 방문할 수 없으므로 x 처리
					water.offer(new location(i, j)); //물의 위치 큐에 넣기
				}
				else if(map[i][j] == 'D') visit[i][j] = 'g';
				else if(map[i][j] == 'X') visit[i][j] = 'x';
				else if(map[i][j] == '.') visit[i][j] = 'p';
				else {//map[i][j] == 'S'
					//고슴도치 현재 위치는 이동. 홍수를 위한 빈칸 처리
					map[i][j] = '.';
					visit[i][j] = 'x';
					loc.offer(new location(i,j)); //고슴도치 위치 큐에 넣기
				}
			}
		}
		bfs();
		if(time==-1) bw.write(FAIL);
		else bw.write(String.valueOf(time));
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(){
		for(time=1; ;time++) {
		
			//1) 물 BFS
			int wSize = water.size();
			for (int i=0; i<wSize; i++) {
				location cur = water.poll(); //큐 정점
				
				//사방으로
				for(int j=0;j<=3;j++) {
					int nr = cur.y + dr[j];
					int nc = cur.x + dc[j];
					
					//지도 범위 초과시
					if(nr<0||nc<0||nr>=R||nc>=C) continue;
					
					if(map[nr][nc]=='.') {
						map[nr][nc] = '*';
						water.offer(new location(nr,nc));
					}
				}
			}
				
			//2) 고슴도치 BFS
			int lSize = loc.size();
			if(lSize==0) {
				time = -1;
				return;
			}
			for(int i=0; i<lSize; i++) {
				location cur = loc.poll(); //큐 정점
				
				//사방으로
				for(int j=0;j<=3;j++) {
					int nr = cur.y + dr[j];
					int nc = cur.x + dc[j];
					
					//지도 범위 초과시
					if(nr<0||nc<0||nr>=R||nc>=C) continue;
					
					if(map[nr][nc]=='D') return;
					if(map[nr][nc]=='.' && visit[nr][nc] == 'p') {
						visit[nr][nc] = 'x';
						loc.offer(new location(nr,nc));
					}
				}
			}
		}
	}
}
/*
1.좌표 클래스 만들기
2.로직
 (1)최초 정점 Queue에 넣는다
 (2)Queue가 빌때까지
  While(!queue.isEmpty()){

*/