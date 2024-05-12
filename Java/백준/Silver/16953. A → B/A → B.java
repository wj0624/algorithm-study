import java.util.*;
import java.io.*;

public class Main {
    static long a,b;
    static int cnt;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        System.out.println(bfs());
    }
    
    static int bfs(){
        Queue<Long> q = new LinkedList<>();
        q.add(a);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                long tmp = q.poll();
                if(tmp==b)
                    return cnt+1;

                if(tmp*2<=b) q.add(tmp*2);
                if(tmp*10+1<=b) q.add(tmp*10+1);
            }
            cnt++;
        }
        return -1;
    }
}