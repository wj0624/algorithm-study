package algorithm;

import java.io.*;
import java.util.*;

//줄 세우기
public class D6_2252 {
	static int n, m, cnt;
	
	static int[] indegree;			//indegree 배열
	static ArrayList[] edgeList;	//간선정보 배열 (queue에서 poll할 때 간선 잘라주는 용도이므로 출발지에
									//edgeList[3] = 3번에서 출발, 도착점을 ArrayList 관리
	static ArrayDeque<Integer> queue;	//위상정렬용 Queue(Indegree가 0인 경우 queue에 추가)
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//0. 입력조건 초기화
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		indegree = new int[n+1];

		edgeList = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			edgeList[i] = new ArrayList<Integer>();
		}
		queue = new ArrayDeque<Integer>();
		//1.입력 받으면서 작은 녀석에 간선 배열을 넣고 큰 녀석에 indegree 추가시킴
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int startId = Integer.parseInt(st.nextToken());
			int targetId = Integer.parseInt(st.nextToken());
			
			//1)출발지점에서 끊어줄 준비
			edgeList[startId].add(targetId);
			//2)도착지점 indegree +1
			indegree[targetId]++;
		}
		
		//2.초기화 - 최초 공정들 queue에 넣기
		for(int i=1;i<=n;i++) {
			if(indegree[i]==0) queue.add(i);
		}
		
		//3.위상정렬
		while(!queue.isEmpty()) {
			//현재 단계 clear
			int startId = queue.poll();
			sb.append(startId+" ");
			
			for(int i=0; i<edgeList[startId].size(); i++) {
				int targetId = (int) edgeList[startId].get(i);
				//1) 타겟에 내가 끝났음을 알림
				indegree[targetId]--;
				//2) 타겟의 indegree가 0이면 enqueue
				if(indegree[targetId] == 0) {
					queue.add(targetId);
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

}