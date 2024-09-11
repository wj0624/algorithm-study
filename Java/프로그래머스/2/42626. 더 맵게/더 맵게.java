import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        
        while(pq.size()>=2) {
            int s = pq.poll();
            if(s >= K) {
                return answer;
            }
            pq.add(s + pq.poll() * 2);
            answer++;
        }
        
        return (pq.poll() >= K) ? answer : -1 ;
    }
}