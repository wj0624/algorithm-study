package algorithm;
import java.io.*;
import java.util.*;

public class D5_5568 {

	static int n, k;
	static String[] arr;
	static boolean[] visited;
	static HashSet<String> ans = new HashSet<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		arr = new String[n+1];
		visited = new boolean[n+1];
		
		
		for(int i=0; i<n; i++) {
			arr[i]=br.readLine();
		}
		permutation(0, "");
		
		System.out.println(ans.size());
		
		br.close();
	}
	
	
	static void permutation(int cnt, String cur) {
		if (cnt == k) {
			ans.add(cur);
			return;
		}
		for (int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permutation(cnt+1, cur+arr[i]);
				visited[i] = false;
			}
		}
	}

}
