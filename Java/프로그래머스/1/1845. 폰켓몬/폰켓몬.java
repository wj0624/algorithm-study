import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hash.add(nums[i]);
        }
        
        int answer = Math.min(hash.size(), (int) (nums.length/2));
        return answer;
    }
}