import java.io.*;
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        return arr[0].equals("0") ? "0" : String.join("", arr);
    }
//     static void combi(int idx, String cur, int cnt){
//         if(cnt == depth){
//             // System.out.println(cur);
//             answer = Math.max(answer, Integer.parseInt(cur));
//         }
        
//         for(int i=0; i<depth; i++){
//             String s = list.get(i);
//             if(!visited[i]){
//                 visited[i] = true;
//                 combi(idx+1, cur+s, cnt+1);
//                 visited[i] = false;
//             } 
//         }
//     }
}