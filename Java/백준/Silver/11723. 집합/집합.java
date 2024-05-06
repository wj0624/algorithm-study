import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int set = 0;
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num;
			
			switch(cmd) {
				case "add" :
					num = Integer.parseInt(st.nextToken())-1;
					set |= 1<<num;
					break;
				case "remove" :
					num = Integer.parseInt(st.nextToken())-1;
					set &= ~(1<<num);
					break;
				case "check" :
					num = Integer.parseInt(st.nextToken())-1;
					sb.append((set & (1<<num))!=0 ? "1" : "0");
					sb.append("\n");
					break;
				case "toggle" :
					num = Integer.parseInt(st.nextToken())-1;
					set ^= 1<<num;
					break;
				case "all" :
					set |= ~0;
					break;
				case "empty" :
					set &= 0;
					break;
			}
		}
		System.out.println(sb);
	}

}
