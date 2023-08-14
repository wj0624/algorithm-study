package algorithm;

import java.io.*;
import java.util.*;

public class D7_11266 {
	static int V, E, order;
	static ArrayList[] adjList;	//그래프
	static int[] visited;	//방문 순서 배열
	static boolean[] isCV;	//단절점인지 확인

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
	
		adjList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int stt, tgt;
		//그래프 입력받기
		for(int i=1;i<=E;i++) {
			st = new StringTokenizer(br.readLine());
			stt = Integer.parseInt(st.nextToken());
			tgt = Integer.parseInt(st.nextToken());
			
			//양방향 연결
			adjList[stt].add(tgt);
			adjList[tgt].add(stt);
		}
		
//		for(int i=1;i<=V;i++) {
//			System.out.println(adjList[i]);
//		}
		
		visited = new int[V+1];
		isCV = new boolean[V+1];
		
		order = 1;
		//방문하지 않은 정점을 시작으로 dfs 탐색 수행
		for(int i=1; i<=V; i++) {
			if(visited[i]==0) {
				dfs(i, 0, true);
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=V; i++) {
			if(isCV[i]) {
				cnt++;
				sb.append(i+" ");
			}
		}
		
		System.out.println(cnt+"\n"+sb.toString());
		br.close();

	}
	
	static int dfs(int id, int parent, boolean isRoot) {
		//1. 방문 순서 기록 후 자식과 비교 준비
		visited[id] = order;
		order++;
		
		//ret : 함수가 return하면서 방문했던 최소 order를 리턴
		//      역전 현상 발생하는지 확인
		int ret = visited[id];
		//root 자식 확인용
		int childCnt = 0;
		
		//2. 자식 DFS - 인접정점을 모두 확인
		int len = adjList[id].size();
		for(int i=0; i<len; i++) {
			int next = (int) adjList[id].get(i);
			
			//왔던길 돌아가기 방지
			if(next == parent) continue;
			
			//2-1. 자식 최초 방문했을 경우
			if(visited[next] == 0) {
				childCnt++;
				
				//자식 정점 중 방문순서가 빠른 값(함수 안 비교)
				int lowOrder = dfs(next, id, false);
				
				//ret > order, cycle이 없다 => 단절점
				//ret < order, cycle 있다 => 단절점 아님
				//ret == order, cycle의 출발점 => 단절점
				if(!isRoot && lowOrder>=visited[id]) {
					isCV[id] = true;
				}
				//노드 간 비교
				ret = Math.min(ret, lowOrder);
			}
			//2-2. 자식을 이미 방문한 경우
			else {
				ret = Math.min(ret, visited[next]);
			}
		}
		
		//3. 루트 정점인 경우 자식 개수가 2개 이상이면 단절점
		if(isRoot && childCnt >=2) {
			isCV[id] = true;
		}
		return ret;
	}
}
