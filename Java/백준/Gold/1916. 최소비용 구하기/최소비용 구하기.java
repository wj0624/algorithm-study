import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList[] list;
	static class Node implements Comparable<Node> {
		int e, w;
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		// 무한대로 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		// 단방향 인접 리스트 구현
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int stt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[stt].add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(s, e));
	}
	
	static int dijkstra(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(!visited[cur.e]) {
				visited[cur.e] = true;
				
				for(int i=0; i<list[cur.e].size(); i++) {
					Node n = (Node) list[cur.e].get(i);
					// 다음 목적지가 방문을 안한 곳이고, 거리가 현재 거리보다 클 때 
					if(!visited[n.e] && dist[n.e] > dist[cur.e] + n.w) {
						dist[n.e] = dist[cur.e] + n.w;	// 최단비용으로 갱신
						pq.add(new Node(n.e, dist[n.e]));
					}
				}
			}
		}
		return dist[e];
	}
}
