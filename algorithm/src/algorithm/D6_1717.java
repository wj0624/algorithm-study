package algorithm;
import java.io.*;
import java.util.*;

public class D6_1717 {
	static int[] parent;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		init();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if(cmd == 0) {
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			else if(cmd == 1) {
				int a = find(Integer.parseInt(st.nextToken()));
				int b = find(Integer.parseInt(st.nextToken()));
				if (a==b)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();

	}
	
	static void init() {
		for(int i=0;i<n+1;i++)
			parent[i] = i;
	}
	
	static void union(int a, int b) {
		parent[find(a)] = parent[find(b)];
	}

	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

}