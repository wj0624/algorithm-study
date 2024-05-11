import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int [] parent;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		tree = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1, 0);
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}
	}
	private static void dfs(int cur, int p) {
		if(tree[cur].size() == 1 && tree[cur].get(0) == p) {
			parent[cur] = p;
			return;
		}
		
		for(int i=0; i<tree[cur].size(); i++) {
			if(tree[cur].get(i)==p) continue;
			dfs(tree[cur].get(i), cur);
		}
		
		parent[cur] = p;
	}

}
