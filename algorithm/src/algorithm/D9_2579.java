package algorithm;

import java.io.*;
import java.util.*;

public class D9_2579 {
	static int n;
	static int[] step, dp;
	//dp[] : ���� ��ܿ��� ���� �� �ִ� �ִ�
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		step = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		//1. �ʱⰪ ����
		dp[1] = step[1];
		
		if(n==1) {
			System.out.println(dp[n]);
			return;
		}
		
		dp[2] = dp[1] + step[2];
		
		for(int i=3; i<=n; i++) {
			// 1ĭ �� ��, 2ĭ �� �� ������ �� ū �� ����
			dp[i] = Math.max(dp[i-3]+step[i-1]+step[i], dp[i-2]+step[i]);
		}
		//���
		System.out.println(dp[n]);
		br.close();		
	}
}
/* DP ��ȭ�� �����
   ����Ǽ� -> 1ĭ / 2ĭ (*3�� ������ ����)
	DP[1] = step[1]	
	DP[2] = DP[1] + step[2]	
	DP[3] = DP[1] + step[3]	
	DP[4] = max	(DP[1]+step[3]+step[4], DP[2]+step[4])
	DP[5] = max	(DP[2]+step[4]+step[5], DP[3]+step[5])
	DP[6] = max	(DP[3]+step[5]+step[6], DP[4]+step[6])
*/