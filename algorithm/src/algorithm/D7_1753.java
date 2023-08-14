package algorithm;

import java.io.*;
import java.util.*;

public class D7_1753 {
	static final int MAXVAL = Integer.MAX_VALUE;
	static int V, E, K;
	static ArrayList[] edgeList;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static long[] dist;
	
	static class Edge implements Comparable<Edge> {
		int tgt;
		long weight;

		public Edge(int tgt, long weight) {
			this.tgt = tgt;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge arg0) {
			return (int) (this.weight - arg0.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//시작점
		K = Integer.parseInt(br.readLine());
		
		//0. 초기화
		dist = new long[V+1];
		edgeList = new ArrayList[V+1];
		
		for(int i=1;i<=V;i++) {
			edgeList[i] = new ArrayList<Edge>();
		}
		for(int i=1; i<=V; i++) {
			dist[i] = MAXVAL;
		}
		
		//1. 입력
		int u, v, w;
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			edgeList[u].add(new Edge(v, w));
		}
		
		//2. Diijkstra 알고리즘
		//1)출발지 PQ에 넣고 시작
		pq.add(new Edge(K, 0));		
		dist[K] = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			//2) 더 큰 가중치일 경우 패스
			if(cur.weight > dist[cur.tgt]) {
				continue;
			}
			
			//3) 현재 위치에 연결된 간선 탐색
			int len = edgeList[cur.tgt].size();
			for(int i=0; i<len; i++) {
				Edge next = (Edge) edgeList[cur.tgt].get(i);
				
				//4) cost가 더 작을 때만 갱신하고 PQ에 넣기
				if(dist[next.tgt] > cur.weight + next.weight) {
					dist[next.tgt] = cur.weight + next.weight;
					pq.add(new Edge(next.tgt, dist[next.tgt]));
				}
			}
		}
		
		//3. 출력
		for(int i=1;i<=V;i++) {
			if(dist[i]==MAXVAL) {
				sb.append("INF\n");
			}
			else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
