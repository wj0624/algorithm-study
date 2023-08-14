package algorithm;

import java.io.*;
import java.util.*;

public class D9_1932 {
	static int n;
	static int[][] map, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		//첫번째 열 초기화
		for(int i=1; i<n; i++) {
			dp[i][0] = dp[i-1][0]+map[i][0];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<=i; j++) {
				//왼쪽 대각선 위 혹은 바로 위의 값 비교해서 더해주기
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+map[i][j];
			}
		}
		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][n-1]);
		br.close();
	}

}
