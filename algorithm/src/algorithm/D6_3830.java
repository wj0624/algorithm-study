package algorithm;

import java.io.*;
import java.util.*;

//교수님은 기다리지 않는다
//브루트포스 --> 시간초과 ( 10만 * 10만 == 100억 )
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
			
			//종료조건 0이 두 개 주어진다.
			if(n==0 && m==0) {
				break;
			}
			
			//테스트케이스 시작
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
					//1)무게 차 구할 수 있는지
					//1-1) 구할 수 있다면
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
					//1-2) 구할 수 없다면
					else sb.append("UNKNOWN\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	//초기화
	static void init() {
		for(int i=1;i<=n;i++)
			parent[i] = i;
	}
	
	//Union 연산
	static void union(int a, int b, long w) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return;
		
		//parent를 변경하고, 무게 차이를 갱신
		weight[pb] = weight[a] - weight[b] + w;
		parent[pb] = pa;
	}
	
	//Find 연산
	static int find(int x) {
		//1. root인 경우 기존 union find 동일
		if(parent[x] == x) return x;
		
		//2. root가 아닌 경우 root와의 거리를 구해서 갱신
		//weight[i] = i와 parent[i]와의 거리
		//parent[i] 먼저 찾기
		int pid = find(parent[x]);
		weight[x] += weight[parent[x]];
		return parent[x] = pid;
	}
}
