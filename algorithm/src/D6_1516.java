import java.io.*;
import java.util.*;

public class D6_1516 {
	static int n, input;	
	static Queue<Integer> q;	//위상정렬용 큐
	static building[] blist;
	
	public static class building{
		int time;		//각 건물 1개의 건설시간
		int indegree;	//건물의 선행조건 개수
		int ans;		//선행건물 포함 최소 건설시간
		ArrayList<Integer> adjList;	//이 건물이 지어져야 지을 수 있는 건물 리스트
		
		public building() {
			this.time = 0;
			this.indegree = 0;
			this.ans = 0;
			this.adjList = new ArrayList<Integer>();
		}
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//1. 입력
		//1-1) n개의 건물정보 생성
		n = Integer.parseInt(br.readLine());
		blist = new building[n+1];
		for(int i=1;i<=n;i++) {
			blist[i] = new building();
		}
		
		//1-2) n개의 건물정보 입력
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			blist[i].time = Integer.parseInt(st.nextToken());
			
			input = Integer.parseInt(st.nextToken());
			while(input!=-1) {
				blist[i].indegree++;
				blist[input].adjList.add(i);
				input = Integer.parseInt(st.nextToken());
			}
		}

		//2.초기화 - 최초 공정들 queue에 넣기
		q = new ArrayDeque<Integer>();
		for(int i=1;i<=n;i++) {
			if(blist[i].indegree==0) {
				q.add(i);
			}
		}
		
		//3.반복문 돌기
		while(!q.isEmpty()) {
			//현재 단계 clear
			int startId = q.poll();
			blist[startId].ans += blist[startId].time;
			
			for(int targetId : blist[startId].adjList) {
				blist[targetId].indegree--;
				
				blist[targetId].ans = Math.max(blist[targetId].ans, blist[startId].ans);
				
				//2) 타겟의 indegree가 0이면 enqueue
				if(blist[targetId].indegree == 0) {
					q.add(targetId);
				}
			}
		}
		for(int i=1; i<=n; i++) {
			sb.append(blist[i].ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
