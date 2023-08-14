package algorithm;

import java.io.*;
import java.util.*;

//�� �����
public class D6_2252 {
	static int n, m, cnt;
	
	static int[] indegree;			//indegree �迭
	static ArrayList[] edgeList;	//�������� �迭 (queue���� poll�� �� ���� �߶��ִ� �뵵�̹Ƿ� �������
									//edgeList[3] = 3������ ���, �������� ArrayList ����
	static ArrayDeque<Integer> queue;	//�������Ŀ� Queue(Indegree�� 0�� ��� queue�� �߰�)
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//0. �Է����� �ʱ�ȭ
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		indegree = new int[n+1];

		edgeList = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			edgeList[i] = new ArrayList<Integer>();
		}
		queue = new ArrayDeque<Integer>();
		//1.�Է� �����鼭 ���� �༮�� ���� �迭�� �ְ� ū �༮�� indegree �߰���Ŵ
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int startId = Integer.parseInt(st.nextToken());
			int targetId = Integer.parseInt(st.nextToken());
			
			//1)����������� ������ �غ�
			edgeList[startId].add(targetId);
			//2)�������� indegree +1
			indegree[targetId]++;
		}
		
		//2.�ʱ�ȭ - ���� ������ queue�� �ֱ�
		for(int i=1;i<=n;i++) {
			if(indegree[i]==0) queue.add(i);
		}
		
		//3.��������
		while(!queue.isEmpty()) {
			//���� �ܰ� clear
			int startId = queue.poll();
			sb.append(startId+" ");
			
			for(int i=0; i<edgeList[startId].size(); i++) {
				int targetId = (int) edgeList[startId].get(i);
				//1) Ÿ�ٿ� ���� �������� �˸�
				indegree[targetId]--;
				//2) Ÿ���� indegree�� 0�̸� enqueue
				if(indegree[targetId] == 0) {
					queue.add(targetId);
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

}