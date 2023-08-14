package algorithm;

import java.io.*;
import java.util.*;

public class D10_7519 {
	static int N, M, maxcost;
	static int[] mem, cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mem = new int[N+1];
		cost = new int[N+1];
		dp = new int[N+1][10001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		
		maxcost = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			maxcost += cost[i];
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=maxcost; j++) {
				if(j-cost[i]>=0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+mem[i]);
				}
				else {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				}
			}
		}
		
		for(int i=0; i<=maxcost; i++) {
			if(dp[N][i] >= M) {
				System.out.println(i);
				break;
			}
		}
		br.close();
	}
}
