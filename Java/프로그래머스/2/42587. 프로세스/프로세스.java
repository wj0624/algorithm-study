import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        boolean[] visited = new boolean[priorities.length];
        int[] order = new int[priorities.length];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
        }
        
        int cnt = 1;
        while(!q.isEmpty()){
            // 1. 프로세스 꺼내기
            int[] cur = q.poll();
            visited[cur[0]] = true; // 실행 처리
            order[cur[0]] = cnt;    // 실행 순서 기록
            //System.out.println("cur: "+cur[0]+"번째, 우선순위: "+cur[1]);
            
            // 우선순위 더 높은 프로세스 있는지 확인
            boolean isMax = true;
            for(int i=0; i<priorities.length; i++){
                if(visited[i]) continue;    // 실행된 프로세스는 건너뛰기
                // 2. 큐에 우선순위 더 높은 프로세스가 있다면, 다시 큐에 넣기
                if(cur[1] < priorities[i]) {
                    q.add(cur);
                    isMax = false;
                    visited[cur[0]] = false; // 실행 처리 취소
                    order[cur[0]] = 0;    // 실행 순서 기록
                    //System.out.println("우선순위 더 높은 프로세스 있음: "+priorities[i]);
                    break;
                }
            }
            // 3. 없다면, 실행 후 그대로 종료
            if(isMax) cnt++;
        }
        return order[location];
    }
}