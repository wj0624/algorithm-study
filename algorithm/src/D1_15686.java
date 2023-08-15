import java.io.*;
import java.util.*;

public class D1_15686 {
	
	static class loc{
		int r, c;
		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, ans;
	static int[] dist;
	
	static int[][] map; //없어도 됨
	
	static ArrayList<loc> house;	//집의 위치
	static ArrayList<loc> chicken;	//치킨집 위치
	
	static boolean isComplete;
	private static final int INF = 999999999; //최소 계산시 현재가 최대로
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N][N];
		dist = new int[13];
		house = new ArrayList<loc>();
		chicken = new ArrayList<loc>();
	
		ans = 0;
		
		//0은 빈 칸, 1은 집, 2는 치킨집
		//입력
		for(int i=0;i<N;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j]==1) house.add(new loc(i,j));
				else if(map[i][j]==2) chicken.add(new loc(i,j));						
			}
		}
		ans = INF;
		dfs(0, chicken.size()-M);
		
		bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();
		return;
	}
	
	//현재 L번째 치킨집
	//폐업해야하는 치킨집 개수 rest
	static void dfs(int L, int rest) {
		//탈출 조건
		if(rest == 0) {
			int ret = getDist();
			ans = ret < ans ? ret : ans;
			return;
		}
		if(L > chicken.size()-1) return;
		
		int backup = chicken.get(L).r;
		//1.폐업 처리 (y좌표값 -1)
		chicken.get(L).r = -1;
		dfs(L+1, rest-1);
		chicken.get(L).r = backup;	//다시 부활(backtracking)
		
		//2.폐업하지 않고 넘어가기
		dfs(L+1, rest);
		return;
		
		
		
	}
	//치킨 거리 구하기
	static int getDist() {
		int tmp;
		int minChick;
		int sum = 0;
		for(int i=0; i<house.size();i++) {
			minChick = INF;
			loc curHouse = house.get(i);
			for(int j=0; j<chicken.size();j++) {
				loc curChick = chicken.get(j);
				//폐업한 치킨집 pass
				if(curChick.r==-1) continue;
				
				tmp = Math.abs(curHouse.r-curChick.r)+Math.abs(curHouse.c-curChick.c);
				
				if(tmp < minChick) minChick =tmp;
			}
			sum += minChick;
		}
		return sum;
	}
}
/*
 1.입력
 2.M개 제외 폐업 시켜보기
  - 폐업이 완료된 상황에서 치킨 거리를 세보기 **별도 method
 3.출력
 */
