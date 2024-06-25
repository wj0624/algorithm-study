import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] arr = new int[N + M];

        String line1 = br.readLine();
        String[] split1 = line1.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split1[i]);
        }
        String line2 = br.readLine();
        String[] split2 = line2.split(" ");
        for (int i = N; i < N + M; i++) {
            arr[i] = Integer.parseInt(split2[i - N]);
        }

        Arrays.sort(arr);

        for (int a : arr) {
            bw.write(a + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}