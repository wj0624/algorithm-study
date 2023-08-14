package algorithm;
import java.io.*;
import java.util.*;

public class D5_1256 {
	
	static final int MAX = 1_000_000_000;
	static int n, m, k;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new long[n+1][m+1];

		for(int i=1; i<=n; i++) {
			dp[i][0] = 1;
		}
		for(int i=1; i<=m; i++) {
			dp[0][i] = 1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = Math.min(dp[i-1][j] + dp[i][j-1], MAX);
			}
		}
		
		//���� ���� (k��°�� ���� ���� ��)
		if(dp[n][m] < k) {
				System.out.println(-1);
				return;
		}
		
		int aCnt = n;
		int zCnt = m;
		
		for(int i=0; i<n+m; i++) {
			//a�� �� �������� ��
			if(aCnt==0) {
				//z ��� �� z�� ���� ����
				sb.append("z");
				zCnt--;
				continue;
			}
			//z�� �� �������� ��
			else if(zCnt==0) {
				//a ��� �� a�� ���� ����
				sb.append("a");
				aCnt--;
				continue;
			}
			
			//a�� �����ϴ� ������ k���� ũ�ų� ���ٸ� a�� �����ϰڳ�
			if(dp[aCnt-1][zCnt]>=k) {
				sb.append("a");
				aCnt--;
			}
			else { //�ƴϸ� z���� �����ϰڱ�
				k -= dp[aCnt-1][zCnt];
				sb.append("z");
				zCnt--;
			}
		}
		System.out.println(sb.toString());		
		br.close();		
	}
	
	
	//�޸��ʰ�
//	static void permutation(int cnt, String cur) {
//		kcnt++;
//		if(kcnt == k) return;
//		if(cnt == 0) {
//			dictionary.add(cur);
//			return;
//		}
//		for (int i=0; i<n+m; i++) {
//			if(!visited[i]) {
//				visited[i] = true;
//				permutation(cnt-1, cur+str[i]);
//				visited[i] = false;
//			}
//		}
//	}
	
}
