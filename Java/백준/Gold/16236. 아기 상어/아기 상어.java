import java.io.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

class Info {
	int r, c, dist;
	public Info(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
}

public class Main {
	
	static int N, size, time, fishCount = 0;
	static int sr, sc;
	static int [][] map; //공간 상태
	static ArrayList<Info> fishes;
	
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,-1,0,1};	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		size = 2; //초기 크기 2
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//아기상어 위치 저장
				if(map[i][j]==9) {
					sr = i;
					sc = j;
					map[i][j] = 0;
				}
			}
		}
		
		time = 0;
		bfs();
		System.out.println(time);
	
	}
	
	static void bfs() {
		
		while(true) { 
			fishes = new ArrayList<Info>(); //먹을 수 있는 물고기 정보
			
			Queue<Info> q = new LinkedList<>();
			boolean visited[][] = new boolean[N][N]; //방문 표시
			
			q.add(new Info(sr, sc, 0)); //q에 상어 위치 삽입, 거리 갱신
			visited[sr][sc] = true; //방문처리
			
			
			while(!q.isEmpty()) { //bfs 수행
				Info shark = q.poll();
				
				for(int i=0; i<4; i++) {
					int nr = shark.r + dr[i];
					int nc = shark.c + dc[i];
						
					//map 범위 안에 있는지, 방문 했는지
					if(nr<0||nr>=N||nc<0||nc>=N||visited[nr][nc]) continue;
					
					//먹이를 찾은 경우(0보다 크고 상어 크기보다 작음)
					if(map[nr][nc]>0 && map[nr][nc]<size) {
						//상어 위치 갱신
						q.add(new Info(nr, nc, shark.dist+1));
						//먹이 리스트에 삽입
						fishes.add(new Info(nr, nc, shark.dist+1));
						//방문 표시
						visited[nr][nc] = true;
					}
						
					//먹을 수는 없지만 지나갈 수 있는 경우(0 이거나 상어의 크기와 같은 경우)
					else if(map[nr][nc]==0 || map[nr][nc]==size) {
							q.add(new Info(nr, nc, shark.dist+1));
							visited[nr][nc] = true;
					}
				}
			}
			
			//더 이상 먹을 수 있는 물고기가 없는 경우
			if(fishes.size() == 0) {
				return;
			}
			
			//먹을 물고기가 있는 경우
			Info eatFish = fishes.get(0);
			for(int i=1; i<fishes.size(); i++) {
				// 거리 최소인 물고기로 갱신
				if(eatFish.dist > fishes.get(i).dist) {
					eatFish = fishes.get(i);
				}
				// 거리가 같은 경우
				if(eatFish.dist == fishes.get(i).dist) {
					//제일 위에 있는 물고기
					if(eatFish.r > fishes.get(i).r) {
						eatFish = fishes.get(i);
					}
				}
			}
			
			time += eatFish.dist; //먹은 물고기 거리를 결과에 추가
			fishCount++; //먹었으니까 카운트 증가
			map[eatFish.r][eatFish.c] = 0; //먹은 자리 빈칸으로
			
			//자신의 크기와 같은 수의 물고리를 먹으면 크기 1증가
			if(size == fishCount) {
				size++;
				fishCount = 0; //크기 증가했으니까 다시 count 0
			}
			
			//상어 위치 갱신
			sr = eatFish.r;
			sc = eatFish.c;
		}
	}
}
