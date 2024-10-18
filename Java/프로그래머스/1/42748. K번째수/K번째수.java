import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int [] ijk : commands){
            int i = ijk[0] - 1;
            int j = ijk[1] - 1;
            int k = ijk[2] - 1;
            
            int[] arr = Arrays.copyOfRange(array, i, j+1);
            Arrays.sort(arr);
            ansList.add(arr[k]);
        }
        
        int[] answer = ansList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}