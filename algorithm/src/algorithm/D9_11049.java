package algorithm;

import java.io.*;
import java.util.*;

public class D9_11049 {
	static int n;
	static int[][] arr, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			for (int j=0; j<n; j++) {
				dp[i][j] = (i==j) ? 0 : Integer.MAX_VALUE;
			}
		}
		
		//인접행렬과의 연산 횟수 (A*B)
		for(int i=0; i<n-1; i++) {
			dp[i][i+1] = arr[i][0] * arr[i][1] * arr[i+1][1];
		}
		
		//k : 간격, i : 시작지점, j : 중간지점
		for(int k=1; k<n; k++) {
			for(int i=0; i+k<n; i++) {
				for(int j=i; j<i+k; j++) {
					dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j]+dp[j+1][i+k]+arr[i][0]*arr[j][1]*arr[i+k][1]);
				}
			}
		}
		
		System.out.println(dp[0][n-1]);
		br.close();
	}
	
}
