import java.io.*;
import java.util.*;
class Solution {
    static boolean[] visited;
    static int depth, answer;
    static ArrayList<String> list = new ArrayList<>();
    public String solution(int[] numbers) {
        depth = numbers.length;
        visited = new boolean[depth];
        for(int num : numbers){
            list.add(String.valueOf(num));
        }
        Collections.sort(list, Collections.reverseOrder());
        combi("", String.join("", list), 0);
        return String.valueOf(answer);
    }
    static void combi(String cur, String other, int cnt){
        if(cnt == depth){
            System.out.println(cur);
            answer = Math.max(answer, Integer.parseInt(cur));
        }
        
        for(int i=0; i<depth; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(cur+list.get(i), other.substring(i+1), cnt+1);
                visited[i] = false;
            }
            
        }
    }
}