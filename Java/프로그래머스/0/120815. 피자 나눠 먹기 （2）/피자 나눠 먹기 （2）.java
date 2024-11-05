import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n) {
        return lcm(6, n) / 6;
    }
    static int gcd(int a, int b){
        int r = 0;
        while(b>0){
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    static int lcm(int a, int b){
        return a*b / gcd(a, b);
    }
}