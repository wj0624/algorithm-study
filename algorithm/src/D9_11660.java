import java.io.*;
import java.util.*;

public class D9_11660 {
	static int n, m, ans;
	static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		

		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				//각 행별로 누적합 구하기
				dp[i][j] = dp[i][j-1] + arr[i][j];
			}
		}
		
		int x1, y1, x2, y2;
		for(int i=0; i<m; i++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
	
			for(int j=x1; j<=x2; j++) {
				ans += dp[j][y2] - dp[j][y1-1];
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
//DP 점화식 구하기
/* ex1) (2,2) (3,4)
     ans = DP[2][4]-DP[2][1] + DP[3][4]-DP[3][1]
   ex2) (3,4) (3,4)
     ans = DP[3][4]-DP[3][3];
   ex3) (1,1) (4,4)
     ans = DP[1][4]-DP[1][0] + DP[2][4]-DP[2][0] + DP[3][4]-DP[3][0] + DP[4][4]-DP[4][0]
*/
