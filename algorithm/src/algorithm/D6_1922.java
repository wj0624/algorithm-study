package algorithm;

import java.io.*;
import java.util.*;

//��Ʈ��ũ ����
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
			//Ż������
			if(edgeCnt == n-1) break;
			
			// start, target, cost
			Edge cur = EdgeList.poll();
			
			//1) �̹� ����Ǿ� �ִٸ�, ���� x
			if(find(cur.stt) == find(cur.tgt)) 
				continue;
			
			//2) ���� �Ǿ� ���� �ʴٸ� ����
			union(cur.stt, cur.tgt);
			ans += cur.cost;
			edgeCnt++;
		}
		System.out.println(ans);
		br.close();
			
	}
	// �ʱ�ȭ - �ڱ� �ڽ����� �ʱ�ȭ
	static void init() {
		for(int i=1; i<n; i++)
				parent[i] = i;
	}
	// union - ã�Ƽ� �θ� ����
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parent[pa] = pb;
	}
	// find - ������ id�� return�ϴ� �Լ�
	static int find(int x) {
		//�������� (�ʱ� �����ΰ�)
		if(parent[x]==x) return x;
		//���� ã�� - ������ �ϳ��� �������
		return parent[x] = find(parent[x]);
	}
}
