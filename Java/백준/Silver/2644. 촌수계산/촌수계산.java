import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int s, e;
	static int ans = -1;
	static boolean [] visited;
	static ArrayList[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(s, 0);
		
		System.out.println(ans);
	}
	private static void dfs(int st, int cnt) {
		if(st == e) {
			ans = cnt;
			return;
		}
		
		visited[st] = true;
		for(int i=0; i<list[st].size(); i++) {
			int next = (int) list[st].get(i);
			if(!visited[next]) {
				dfs(next, cnt+1);
			}
		}
	}
}
