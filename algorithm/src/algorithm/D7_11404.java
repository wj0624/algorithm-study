package algorithm;

import java.io.*;
import java.util.*;

public class D7_11404 {
	//MAX�� ������ ��������.
	static final int MAX_COST = 100_000_001;
	static int n, m;
	static int[][] cost;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int a, b, c;
		
		//0. �ʱ�ȭ
		//�ʱ⿡�� ���� ���Ѵٰ� ����(MAX_COST)
		//������� �������� ���� ���, ����� 0;
		cost = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				cost[i][j] = (i == j) ? 0 : MAX_COST;
			}
		}
		
		//1. �Է�
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			//�� ���� ����� ������  update
			cost[a][b] = Math.min(cost[a][b], c);
		}
		
		//2. �÷��̵�
		//������ �鷯�� �� �� ����� �� ������ update
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		
		//3. ���
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				//���� ����� ���� ��
				if(cost[i][j]==MAX_COST) {
					sb.append(0+" ");
				}
				else {
					sb.append(cost[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}