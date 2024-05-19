import java.io.*;
import java.util.*;
public class Main {
	// 큐에 담을 노드 클래스
	static class Node implements Comparable<Node> {
		int s, e, w; // s: 시작점, e: 끝점, w: 가중치
		
		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		// 가중치에 따라 오름차순 정렬
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	static int V, E, ans=0;
	static int[] parent; // 각 노드의 부모를 담고 있는 배열
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V+1];
		
		// 부모는 자기 자신으로 초기화
		for(int i=1; i<=V; i++) parent[i]=i;
		
		//간선 정보 입력
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(a, b, c));
		}
		
		findMst();
		
		System.out.println(ans);
	}
	
	private static void findMst() {
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			// 시작점과 끝점의 부모 찾기
			int ps = find(n.s);
			int pe = find(n.e);
			// 부모가 다르다면(연결되어 있지 않다면)
			if(ps!=pe) {
				union(ps, pe);	// 연결
				ans += n.w;	// 가중치 더하기
			}
		}
	}

	// UNION-FIND
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		parent[px] = py;
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
}
