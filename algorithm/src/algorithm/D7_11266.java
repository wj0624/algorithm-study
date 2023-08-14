package algorithm;

import java.io.*;
import java.util.*;

public class D7_11266 {
	static int V, E, order;
	static ArrayList[] adjList;	//�׷���
	static int[] visited;	//�湮 ���� �迭
	static boolean[] isCV;	//���������� Ȯ��

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
		//�׷��� �Է¹ޱ�
		for(int i=1;i<=E;i++) {
			st = new StringTokenizer(br.readLine());
			stt = Integer.parseInt(st.nextToken());
			tgt = Integer.parseInt(st.nextToken());
			
			//����� ����
			adjList[stt].add(tgt);
			adjList[tgt].add(stt);
		}
		
//		for(int i=1;i<=V;i++) {
//			System.out.println(adjList[i]);
//		}
		
		visited = new int[V+1];
		isCV = new boolean[V+1];
		
		order = 1;
		//�湮���� ���� ������ �������� dfs Ž�� ����
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
		//1. �湮 ���� ��� �� �ڽİ� �� �غ�
		visited[id] = order;
		order++;
		
		//ret : �Լ��� return�ϸ鼭 �湮�ߴ� �ּ� order�� ����
		//      ���� ���� �߻��ϴ��� Ȯ��
		int ret = visited[id];
		//root �ڽ� Ȯ�ο�
		int childCnt = 0;
		
		//2. �ڽ� DFS - ���������� ��� Ȯ��
		int len = adjList[id].size();
		for(int i=0; i<len; i++) {
			int next = (int) adjList[id].get(i);
			
			//�Դ��� ���ư��� ����
			if(next == parent) continue;
			
			//2-1. �ڽ� ���� �湮���� ���
			if(visited[next] == 0) {
				childCnt++;
				
				//�ڽ� ���� �� �湮������ ���� ��(�Լ� �� ��)
				int lowOrder = dfs(next, id, false);
				
				//ret > order, cycle�� ���� => ������
				//ret < order, cycle �ִ� => ������ �ƴ�
				//ret == order, cycle�� ����� => ������
				if(!isRoot && lowOrder>=visited[id]) {
					isCV[id] = true;
				}
				//��� �� ��
				ret = Math.min(ret, lowOrder);
			}
			//2-2. �ڽ��� �̹� �湮�� ���
			else {
				ret = Math.min(ret, visited[next]);
			}
		}
		
		//3. ��Ʈ ������ ��� �ڽ� ������ 2�� �̻��̸� ������
		if(isRoot && childCnt >=2) {
			isCV[id] = true;
		}
		return ret;
	}
}
