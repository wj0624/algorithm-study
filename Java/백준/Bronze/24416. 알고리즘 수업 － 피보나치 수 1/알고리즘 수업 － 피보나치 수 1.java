import java.io.*;
import java.util.*;

public class Main {

    static int cnt1,  cnt2; //코드1, 코드2 실행 횟수

    static int[] f;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());
        f = new int[n];

        cnt1 = 0;
        cnt2 = 0;

        fib(n);
        fibonacci(n);

        System.out.println(cnt1 + " " + cnt2);

    }

    //피보나치 수 재귀 호출 코드
    static int fib(int n){
        if(n == 1 || n == 2){
            cnt1++;
            return 1;
        }
        else return (fib(n-1) + fib(n-2));
    }

    //피보나치 수 동적 프로그래밍 코드
    static int fibonacci(int n){
        f[0] = 1;
        f[1] = 1;

        for(int i = 2; i < n; i++){
            cnt2++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n-1];
    }

}