import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();

        for(int i = 0; i < arr.length; i++){
            if(num == arr[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}