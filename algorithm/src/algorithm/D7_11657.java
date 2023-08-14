package algorithm;

import java.io.*;
import java.util.*;

public class D7_11657 {
	static final int MAX_TIME = Integer.MAX_VALUE;
	static Edge[] edgeList;
	static long[] time;
	static int n, m;
	static boolean flag = false; //���� ����Ŭ ������ �÷���
	
	static class Edge{
		int stt, tgt, cost;

		public Edge(int stt, int tgt, int cost) {
			this.stt = stt;
			this.tgt = tgt;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//0. �ʱ�ȭ
		edgeList = new Edge[m+1];
		time = new long[n+1];
		
		time[1] = 0;
		for(int i=2;i<=n;i++) {
			time[i] = MAX_TIME;
		}
		
		int a, b, c;
		
		//1. �Է�
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			edgeList[i] = (new Edge(a, b, c));
		}
		
		//2. �븸����
		//1) N-1�� Ȯ��
		for(int i=1; i<n; i++) {
			for(int j=1; j<=m; j++) {
				Edge now = edgeList[j];
				if(time[now.stt]==MAX_TIME) {
						continue;
				}
				
				time[now.tgt] = Math.min(time[now.tgt], time[now.stt] + now.cost);
			}
		}
		//2) ���� ����Ŭ �������� Ȯ��
		for(int j=1; j<=m; j++) {
			Edge now = edgeList[j];
			if(time[now.stt]==MAX_TIME) {
					continue;
			}
			//������ �߻��Ѵٸ� ���� ����Ŭ�� ����
			if(time[now.stt] + now.cost < time[now.tgt]){
				flag = true;
				break;
			}
		}
		
		//���� ������ �����ٸ� -1 ����ϰ� ���α׷� ����
		if(flag) {
			System.out.println(-1);
			return;
		}
		
		//3. ���
		for(int i=2;i<=n;i++) {
			if(time[i]==MAX_TIME) {
				sb.append(-1+"\n");
			}
			else {
				sb.append(time[i]+"\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
