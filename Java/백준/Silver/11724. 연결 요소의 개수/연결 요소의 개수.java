import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static ArrayList[] list;
	static boolean [] visited;
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
 				dfs(i);
				cnt++;
			}
				
		}
		System.out.println(cnt);
	}
	
	private static void dfs(int id) {
		for(int i=0; i<list[id].size(); i++) {
			int next = (int) list[id].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
	}

}
