package algorithm;

import java.io.*;
import java.util.*;

public class D8_11438 {
	static int N, M, K;
	static ArrayList[] tree;
	static int[][] parent;
	static int[] depth;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//0. 초기화
		tree = new ArrayList[N+1];
		depth = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		//1. 입력
		int a, b;
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		//2. 2^K에서 K를 알아내기
		//K는 N보다 작거나 같은 2의 제곱수
		int x = N;
		for(K=0;x>1;K++) {
			x/=2;
		}
		//System.out.println(K);
		parent = new int[K+1][N+1];
		
		//3. DFS - depth 확인, 첫번째 부모(parent[0][V]) 기록
		dfs(1,1);	//루트 노드부터 시작
		
		//4. fillParent - 2^K번째 부모 기록
		for(int i=1; i<=K; i++) {
			for(int j=1; j<=N; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sb.append(LCA(a, b)+"\n");
		}
		
		//3. 출력
		System.out.println(sb);
		br.close();
	}

	static int LCA(int A, int B) {
		//a, b 정점 간 깊이 차이 확인
		if(depth[A] < depth[B]) {
			int tmp = A;
			A = B;
			B = tmp;
		}
		
		for(int i=K; i>=0; i--) {
			if(Math.pow(2,i) <= depth[A] - depth[B]) {
					A = parent[i][A];
			}
		}
		
		if(A == B) return A;
		
		for(int j=K; j>=0; j--) {
			if(parent[j][A]!=parent[j][B]) {
				A = parent[j][A];
				B = parent[j][B];
			}
		}
		return parent[0][A];
	}
	
	static void dfs(int id, int cnt) {
		//1)현재 정점 depth 기록
		depth[id] = cnt;
		
		//2)자식들의 depth 기록
		int len = tree[id].size();
		for(int i=0;i<len;i++) {
			int child = (int) tree[id].get(i);
			//아직  depth 모르면 미방문 노드
			if(depth[child]==0) {
				parent[0][child] = id;
				dfs(child, cnt+1);
			}
		}
		return;
	}
}
