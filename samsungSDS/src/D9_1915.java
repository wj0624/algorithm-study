import java.io.*;
import java.util.*;

public class D9_1915 {
	static int n, m, ans;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		dp = new int[n+1][m+1];	// i, j에서 만들 수 있는 가장 큰 정사각형의 한변의 길이
		
		//입력
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			for(int j=1; j<=m; j++) {
				dp[i][j] = arr[i][j] = input.charAt(j-1) - '0';
			}
		}
	
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				//정사각형의 변이 될 수 있는 경우
				if(arr[i][j]==1) {
					dp[i][j] = sol(i, j);
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		//넓이 출력(가능한 최대 변 크기의 제곱
		System.out.println(ans*ans);
		br.close();
	}
	static int sol(int r, int c) {
		int ldup = dp[r-1][c-1];
		int left = dp[r][c-1];
		int up = dp[r-1][c];
		
		//왼쪽 대각선 위, 왼쪽, 위 하나라도 0이면 크기가 1인 정사각형
		if(ldup==0||left==0||up==0) return 1;
		
		//3개 중 정사각형 존재하면 그 최솟값 + 1
		return Math.min(Math.min(ldup, left), up)+1;
	}
}
