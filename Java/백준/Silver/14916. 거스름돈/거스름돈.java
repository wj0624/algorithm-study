import java.io.*;

public class Main {
	static int n, count=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		while(true) {
			if(n%5==0) { //5로 다 나눠지면 출력 후 종료
				count += n/5;
				System.out.println(count);
				System.exit(0);
			}
			else {
				n -= 2; //2원 빼보기
				count++;
			}
			if(n<0) {
				System.out.println(-1);
				System.exit(0);
			}
			
		}
	}

}