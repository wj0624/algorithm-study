import java.io.*;
import java.util.*;

public class P1039{
	static int M, K, ans;
	static String N;
	static int[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = st.nextToken();
		K = Integer.parseInt(st.nextToken());
		M = N.length();
		visit = new int[K+1][1000001];
		System.out.println(dfs(N, 0));
		br.close();
	}
	static int dfs(String str, int depth) {
		int num = Integer.parseInt(str);
		//K번만큼 연산 수행했으면 return
		if(depth==K) return num;
		
		int ret = visit[depth][num];
		if(ret != 0) return ret;	//방문한적 있으면 기록된 값을 return
		
		ret = -1;	//처음 방문한 경우
		for(int i=0; i<M-1; i++) {
			for(int j=i+1; j<M; j++) {
				if(i==0 && str.charAt(j)=='0') continue;	//숫자는 0으로 시작할 수 없음
				String tmp = swap(str, i, j);
				int max = dfs(tmp, depth+1);
				ret = Math.max(max, ret);
			}
		}
		visit[depth][num] = ret;
		return ret;
	}
	
	static String swap(String tmp, int i, int j) {
		char[] charArray = tmp.toCharArray();
		char a = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = a;
		return String.valueOf(charArray);
	}
}
