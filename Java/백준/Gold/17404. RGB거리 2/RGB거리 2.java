import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int [][] map, dp;
	static int MAX = 1000*1000+1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][3];
		dp = new int[N+1][3];
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = MAX;
		// 첫번째 집이 R일때, G일때, B일때 각각 계산 => 3번 반복
		for(int first=0; first<3; first++) {
			for(int i=0; i<3; i++) {
				// 첫번째 집 색깔 선택
				if(i==first) dp[1][i] = map[1][i];
				// 나머지 집은 선택되지 않게 MAX 값으로 초기화
				else dp[1][i] = MAX;
			}
			
			// 두번째 집부터 칠하기 시작
			for(int i=2; i<=N; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
			}
			
			// 첫번째 집과 같은 색을 제외한 가장 작은 수 선택
			for(int i=0; i<3; i++) {
				if(i!=first && ans>dp[N][i]) {
					ans = dp[N][i];	// 답 갱신
				}
			}
		}
		
		System.out.println(ans);
	}

}
