import java.io.*;
import java.util.*;
class Solution {
    static Set<Integer> numSet = new HashSet<>();
    public void recursive(String comb, String others){
        // 1. 현재 조합을 set에 추가
        if(!comb.equals(""))
            numSet.add(Integer.valueOf(comb));
        
        // 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만들기
        for(int i=0; i<others.length(); i++){
            recursive(comb + others.charAt(i), others.substring(0,i) + others.substring(i+1));
        }
    }
    public boolean isPrime(int num){
        // 1. 0과 1은 소수가 아니다.
        if(num==0 || num==1) return false;
        
        // 2. 에라토스테네스의 체의 limit을 계산
        int limit = (int) Math.sqrt(num);
        
        // 3. limit까지만 배수 여부 확인
        for(int i=2; i<=limit; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    public int solution(String numbers) {
        int cnt = 0;
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numSet.iterator();
        while(it.hasNext()){
            int num = it.next();
            if(isPrime(num)) cnt++;
        }
        // 3. 소수의 개수를 반환한다.
        return cnt;
    }
}