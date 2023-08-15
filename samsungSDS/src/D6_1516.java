import java.io.*;
import java.util.*;

public class D6_1516 {
	static int n, input;	
	static Queue<Integer> q;	//�������Ŀ� ť
	static building[] blist;
	
	public static class building{
		int time;		//�� �ǹ� 1���� �Ǽ��ð�
		int indegree;	//�ǹ��� �������� ����
		int ans;		//����ǹ� ���� �ּ� �Ǽ��ð�
		ArrayList<Integer> adjList;	//�� �ǹ��� �������� ���� �� �ִ� �ǹ� ����Ʈ
		
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
		
		//1. �Է�
		//1-1) n���� �ǹ����� ����
		n = Integer.parseInt(br.readLine());
		blist = new building[n+1];
		for(int i=1;i<=n;i++) {
			blist[i] = new building();
		}
		
		//1-2) n���� �ǹ����� �Է�
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

		//2.�ʱ�ȭ - ���� ������ queue�� �ֱ�
		q = new ArrayDeque<Integer>();
		for(int i=1;i<=n;i++) {
			if(blist[i].indegree==0) {
				q.add(i);
			}
		}
		
		//3.�ݺ��� ����
		while(!q.isEmpty()) {
			//���� �ܰ� clear
			int startId = q.poll();
			blist[startId].ans += blist[startId].time;
			
			for(int targetId : blist[startId].adjList) {
				blist[targetId].indegree--;
				
				blist[targetId].ans = Math.max(blist[targetId].ans, blist[startId].ans);
				
				//2) Ÿ���� indegree�� 0�̸� enqueue
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
