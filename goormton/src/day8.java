import java.io.*;
import java.util.*;
public class day8 {
	static final int bandage = 1;
	static final int medicine = 7;
	static final int painkiller = 14;
	static int N, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		while(N!=0){
			if(N>=painkiller){
				N -= painkiller;
			}
			else if(N>=medicine){
				N -= medicine;
			}
			else if(N>=bandage){
				N -= bandage;
			}
			ans++;
		}
		System.out.println(ans);
	}
}