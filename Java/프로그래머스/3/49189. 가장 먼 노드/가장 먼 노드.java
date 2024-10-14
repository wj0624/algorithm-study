import java.io.*;
import java.util.*;
class Solution {
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static PriorityQueue<Integer> dist = new PriorityQueue<>(Collections.reverseOrder());
    static int n;
    public int solution(int n, int[][] edge) {
        this.n = n;
        int answer = 1;
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        
        // 그래프 생성
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0] - 1;
            int b = edge[i][1] - 1;
            ArrayList<Integer> aList = graph.get(a);
            ArrayList<Integer> bList = graph.get(b);
            
            aList.add(b);
            bList.add(a);
            graph.put(a, aList);
            graph.put(b, bList);
        }
        // System.out.println(graph);
        
        // 각 노드까지의 거리 구하기
        bfs();
        
        int max = dist.poll();
        while(!dist.isEmpty()){
            if(max == dist.poll()) answer++;
        }
        
        return answer;
    }
    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[n];
        q.add(0);
        visited[0] = 1;
        
        // bfs
        while(!q.isEmpty()){
            int cur = q.poll();
            ArrayList<Integer> list = graph.get(cur);
            // System.out.println(cur+"번 노드, 연결된 노드들: "+list);
            for(int i=0; i<list.size(); i++){
                int next = list.get(i);
                if(visited[next]==0){
                    visited[next] = visited[cur]+1;
                    q.add(next);
                    dist.add(visited[next]);
                }
            }
        }
    }
}