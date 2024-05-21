import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [][] A;	// 입력 배열
	static int ans = -1;	// 정답
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		
		// 입력
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				A[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) { // 행 시작 부분 지정
			for(int j=0; j<M; j++) { // 열 시작 부분 지정
				solve(i, j);
			}
		}
		
		System.out.println(ans);
	}
	
	private static void solve(int r, int c) {
		for(int i=-N; i<N; i++) {	// 행 공차
			for(int j=-M; j<M; j++)	{	// 열 공차
				//움직이지 않은 경우
				if(i==0 && j==0) continue; 
				
				int nr = r;
				int nc = c;
				
				int now = 0; // 만들어질 제곱수
				
				while(nr>=0&&nr<N&&nc>=0&&nc<M) {
					// 제곱수 생성
					now *= 10;
					now += A[nr][nc];
					
					// 제곱수 판별
					if(Math.pow((int)Math.sqrt(now), 2) == now) {
						ans = Math.max(ans, now);
					}
					
					nr += i;
					nc += j;
				}
			}
		}
	}
}
