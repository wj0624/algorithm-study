package algorithm;

import java.io.*;
import java.util.*;

public class P1062 {
	
	static int N, K;
	static int ans = 0;
	static boolean[] visit;
	static String[] words;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//예외처리
		if(K<5) {
			System.out.println(0);
			br.close();
			return;
		}
		else if(K==26){
			System.out.println(N);
			br.close();
			return;
		}
		
		words = new String[N];
		String in;
		for(int i=0; i<N; i++) {
			in = br.readLine();
			words[i] = in.substring(4, in.length()-4);
		}
		
		visit = new boolean[26];
		visit['a'-'a'] = true;
		visit['n'-'a'] = true;
		visit['t'-'a'] = true;
		visit['i'-'a'] = true;
		visit['c'-'a'] = true;
		
		dfs(1,0);
		
		System.out.println(ans);
	}


	static void dfs(int id, int len) {
		if(len == K-5) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				boolean read = true;
				for(int j=0; j<words[i].length(); j++) {
					if(visit[words[i].charAt(j)-'a']==false) {
						read = false;
						break;
					}
				}
				if(read) cnt++;
				
			}
			ans = Math.max(ans, cnt);
			return;
		}
	
		
		for(int i=id; i<26; i++) {
			if(visit[i]==false) {
				visit[i] = true;
				dfs(i, len+1);
				visit[i] = false;
			}
		}
	}

}
