import java.io.*;
import java.util.*;
public class Main {
	static int N, ret=0;
	static int [][] graph;
	static int [][] check;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		check = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			for(int j=0; j<N; j++) {
				if(graph[i][j]==1&&!visited[j]) {
					dfs(i, j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(check[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void dfs(int s, int e) {
		visited[e] = true;
		check[s][e] = 1;
		
		for(int i=0; i<N; i++) {
			if(graph[e][i]==1&&!visited[i]) {
				dfs(s, i);
			}
		}
	}

}
