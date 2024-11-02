import java.io.*;
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int n = numer1 * denom2 + numer2 * denom1;
        int d = denom1 * denom2;
        int g = gcd(n, d);
        n = n / g;
        d = d / g;
        int[] answer = {n, d};
        return answer;
    }
    static int gcd(int a, int b){
        int r = 0;
        while(b!=0){
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}