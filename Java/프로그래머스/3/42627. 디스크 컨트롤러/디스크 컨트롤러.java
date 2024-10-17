import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // 작업 요청 시점 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        // 작업 소요 시간 순으로 정렬되는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        int cnt = 0;    // 수행 완료 개수
        int idx = 0;
        int answer = 0;
        int time = 0;
        
        while(cnt < jobs.length){
            // 현재 시간까지 들어온 요청을 큐에 넣기
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.add(jobs[idx]);
                idx++;
            }
            // 큐가 비어 있다면 현재 시간 이후에 요청이 들어올 것
            if(pq.isEmpty()){
                time = jobs[idx][0];
            }
            else {
                int[] cur = pq.poll();
                answer += cur[1] + time - cur[0];
                time += cur[1];
                cnt++;
            }
        }
        return (int) answer/jobs.length;
    }
    
}