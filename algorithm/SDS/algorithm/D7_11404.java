package algorithm;

import java.io.*;
import java.util.*;

public class D7_11404 {
	//MAX값 설정에 유의하자.
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
		
		//0. 초기화
		//초기에는 가지 못한다고 가정(MAX_COST)
		//출발지랑 도착지랑 같은 경우, 비용은 0;
		cost = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				cost[i][j] = (i == j) ? 0 : MAX_COST;
			}
		}
		
		//1. 입력
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			//더 작은 비용의 값으로  update
			cost[a][b] = Math.min(cost[a][b], c);
		}
		
		//2. 플로이드
		//경유지 들러서 갈 때 비용이 더 작으면 update
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		
		//3. 출력
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				//가는 방법이 없을 때
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