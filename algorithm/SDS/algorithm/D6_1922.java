package algorithm;

import java.io.*;
import java.util.*;

//네트워크 연결
public class D6_1922 {
	static int n, m, edgeCnt, ans;
	static PriorityQueue<Edge> EdgeList = new PriorityQueue<>();
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int stt, tgt, cost;

		public Edge(int stt, int tgt, int cost) {
			this.stt = stt;
			this.tgt = tgt;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge arg0) {
			if(this.cost>arg0.cost)
				return 1;
			return -1;
		}
		
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
	
		StringTokenizer st;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			EdgeList.add(new Edge(a, b, c));
		}
		
		edgeCnt = 0;
		ans = 0;
		
		parent = new int[n+1];
		init();
		
		while(!EdgeList.isEmpty()) {
			//탈출조건
			if(edgeCnt == n-1) break;
			
			// start, target, cost
			Edge cur = EdgeList.poll();
			
			//1) 이미 연결되어 있다면, 연결 x
			if(find(cur.stt) == find(cur.tgt)) 
				continue;
			
			//2) 연결 되어 있지 않다면 연결
			union(cur.stt, cur.tgt);
			ans += cur.cost;
			edgeCnt++;
		}
		System.out.println(ans);
		br.close();
			
	}
	// 초기화 - 자기 자신으로 초기화
	static void init() {
		for(int i=1; i<n; i++)
				parent[i] = i;
	}
	// union - 찾아서 부모를 변경
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parent[pa] = pb;
	}
	// find - 조상의 id를 return하는 함수
	static int find(int x) {
		//예외조건 (초기 상태인가)
		if(parent[x]==x) return x;
		//값을 찾자 - 조상을 하나로 만들어줌
		return parent[x] = find(parent[x]);
	}
}
