package algorithm;

import java.io.*;
import java.util.*;

//�������� ��ٸ��� �ʴ´�
//���Ʈ���� --> �ð��ʰ� ( 10�� * 10�� == 100�� )
public class D6_3830 {
	static int n, m, ans;
	//static ArrayList<Edge> EdgeList ;
	static int[] parent;
	static long[] weight;
	
//	static class Edge{
//		int stt, tgt, weight;
//
//		public Edge(int stt, int tgt, int weight) {
//			this.stt = stt;
//			this.tgt = tgt;
//			this.weight = weight;
//		}
//	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			weight = new long[n+1];
			//EdgeList = new ArrayList<>();
			
			init();
			
			//�������� 0�� �� �� �־�����.
			if(n==0 && m==0) {
				break;
			}
			
			//�׽�Ʈ���̽� ����
			for(int i=1; i<=m; i++) {
				String[] cmd = br.readLine().split(" ");
				int a = Integer.parseInt(cmd[1]);
				int b = Integer.parseInt(cmd[2]);
//				ans = 0;
				
				if(cmd[0].equals("!")) {
					int c = Integer.parseInt(cmd[3]);
					union(a, b, c);
				}
				
				else if(cmd[0].equals("?")) {
					//1)���� �� ���� �� �ִ���
					//1-1) ���� �� �ִٸ�
					if(find(a)==find(b)) {
						sb.append((weight[b] - weight[a])+"\n");
						
//						for(int j=0; j<EdgeList.size();j++) {
//							Edge cur = EdgeList.get(j);
//							if(cur.stt==a) {
//								if(cur.tgt==b) {
//									ans += cur.weight;
//									break;
//								}
//								a = cur.tgt;
//								ans += cur.weight;
//							}
//							
//							else if(cur.stt==b) {
//								if(cur.tgt==a) {
//									ans -= cur.weight;
//									break;
//								}
//								b = cur.tgt;
//								ans -= cur.weight;
//							}
//						}
//						sb.append(ans+"\n");
					}
					//1-2) ���� �� ���ٸ�
					else sb.append("UNKNOWN\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	//�ʱ�ȭ
	static void init() {
		for(int i=1;i<=n;i++)
			parent[i] = i;
	}
	
	//Union ����
	static void union(int a, int b, long w) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return;
		
		//parent�� �����ϰ�, ���� ���̸� ����
		weight[pb] = weight[a] - weight[b] + w;
		parent[pb] = pa;
	}
	
	//Find ����
	static int find(int x) {
		//1. root�� ��� ���� union find ����
		if(parent[x] == x) return x;
		
		//2. root�� �ƴ� ��� root���� �Ÿ��� ���ؼ� ����
		//weight[i] = i�� parent[i]���� �Ÿ�
		//parent[i] ���� ã��
		int pid = find(parent[x]);
		weight[x] += weight[parent[x]];
		return parent[x] = pid;
	}
}
