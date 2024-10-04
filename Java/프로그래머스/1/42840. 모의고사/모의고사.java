import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 수포자들의 답안 패턴
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++){
            if (answers[i] == p1[i % p1.length]) {
                score[0]++;
            }
            if (answers[i] == p2[i % p2.length]) {
                score[1]++;
            }
            if (answers[i] == p3[i % p3.length]) {
                score[2]++;
            }
        }
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<4; i++){
            list.add(new int[]{i, score[i-1]});
        }
        list.sort((a,b) -> b[1] - a[1]);
        
        List<Integer> answer = new ArrayList<>();
        int bestScore = list.get(0)[1];
        for(int [] arr : list){
            if(arr[1] == bestScore) answer.add(arr[0]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}