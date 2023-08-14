package algorithm;

import java.io.*;
import java.util.*;


public class D7_11400 {
	static int V, E, order;
	static ArrayList[] adjList;
	static int[] visited;
	static boolean[] isCE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//0.�ʱ�ȭ
		visited = new int[V+1];
		isCE = new boolean[E+1];
		adjList = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int A, B;
		//1. �Է�
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			//����� ����
			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		//2. dfs
		order = 1;
		for(int i=1; i<=E; i++) {
			
		}
		
		
		

	}

}
