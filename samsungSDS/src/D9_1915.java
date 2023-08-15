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
		dp = new int[n+1][m+1];	// i, j���� ���� �� �ִ� ���� ū ���簢���� �Ѻ��� ����
		
		//�Է�
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			for(int j=1; j<=m; j++) {
				dp[i][j] = arr[i][j] = input.charAt(j-1) - '0';
			}
		}
	
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				//���簢���� ���� �� �� �ִ� ���
				if(arr[i][j]==1) {
					dp[i][j] = sol(i, j);
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		//���� ���(������ �ִ� �� ũ���� ����
		System.out.println(ans*ans);
		br.close();
	}
	static int sol(int r, int c) {
		int ldup = dp[r-1][c-1];
		int left = dp[r][c-1];
		int up = dp[r-1][c];
		
		//���� �밢�� ��, ����, �� �ϳ��� 0�̸� ũ�Ⱑ 1�� ���簢��
		if(ldup==0||left==0||up==0) return 1;
		
		//3�� �� ���簢�� �����ϸ� �� �ּڰ� + 1
		return Math.min(Math.min(ldup, left), up)+1;
	}
}
