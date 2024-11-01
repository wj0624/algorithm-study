import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int s = -1;
        int e = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2&&s==-1) s = i;
            if(arr[i]==2&&s!=-1) e = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        // 2가 없는 경우
        if(s == -1) return new int[] {-1};
        // 2가 한 번만 나온 경우
        else if(s != -1 && e == -1) return new int[] {2};
        else {
            for(int i=s; i<=e; i++){
                list.add(arr[i]);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}