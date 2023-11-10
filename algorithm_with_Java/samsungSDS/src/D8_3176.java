import java.io.*;
import java.util.*;

public class D8_3176 {
	static int N, K, M;
	static ArrayList[] tree;
	static int[][] parent;
	static int[] depth;
	
	//D - E 거리간 최소 or 최대 거리 저장 배열
	static int[][] minLen;
	static int[][] maxLen;
	static int min, max;
	
	static StringBuilder sb = new StringBuilder();
	
	static class Edge implements Comparable<Edge>{
		int tgt, length;

		public Edge(int tgt, int length) {
			this.tgt = tgt;
			this.length = length;
		}

		@Override
		public int compareTo(Edge arg0) {
			return this.length - arg0.length;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//0. 초기화
		tree = new ArrayList[N+1];
		depth = new int[N+1];
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<Edge>();
		}
		
		int a, b, c;
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			tree[a].add(new Edge(b,c));
			tree[b].add(new Edge(a,c));
			
		}
		
		//1. 2^M의 M 찾기
		M = -1;
		for(int i=1; i<=N; i*=2) {
			M++;
		}
				
		parent = new int[M+1][N+1];
		minLen = new int[N+1][N+1];
		maxLen = new int[N+1][N+1];
		
		dfs(1,1);
		
		fillParent();
		
		K = Integer.parseInt(br.readLine());
		
		int d, e;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			LCA(d, e);
			sb.append(min+" "+max+"\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void LCA(int x, int y) {
		min = Integer.MAX_VALUE;
		max = -1;
		
		if(depth[x] < depth[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		for(int i=M; i>=0; i--) {
			if(Math.pow(2, i) <= depth[x]-depth[y]) {
				min = Math.min(min, minLen[i][x]);
				max = Math.max(min, maxLen[i][x]);
				x = parent[i][x];
			}
		}

		if(x==y) return;
		
		for(int i=M; i>=0; i--) {
			if(parent[i][x]!=parent[i][y]) {		
				min = Math.min(min, Math.min(minLen[i][x], minLen[i][y]));
				max = Math.max(max, Math.max(maxLen[i][x], maxLen[i][y]));
				
				x = parent[i][x];
				y = parent[i][y];
			}
		}
		
		min = Math.min(min, Math.min(minLen[0][x], minLen[0][y]));
		max = Math.max(max, Math.max(maxLen[0][x], maxLen[0][y]));
		return;
	}
	
	static void fillParent() {
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
				
				minLen[i][j] = Math.min(minLen[i-1][j], minLen[i-1][parent[i-1][j]]);
				maxLen[i][j] = Math.max(maxLen[i-1][j], maxLen[i-1][parent[i-1][j]]);
			}
		}
	}
	
	static void dfs(int id, int cnt) {
		depth[id] = cnt;
		
		int len = tree[id].size();
		for(int i=0;i<len;i++) {
			Edge next = (Edge) tree[id].get(i);
			
			if(depth[next.tgt]==0) {
				parent[0][next.tgt] = id;
				dfs(next.tgt, cnt+1);
				
				//부모까지의 거리 저장
				minLen[0][next.tgt] = next.length;
				maxLen[0][next.tgt] = next.length;
			}
		}
		return;
	}
	

}
