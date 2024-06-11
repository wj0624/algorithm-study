import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean [] submitted = new boolean[30];
		for(int i=0; i<28; i++) {
			submitted[sc.nextInt()-1] = true; 
		}
		
		List<Integer> ans = new ArrayList<>();
		for(int i=0; i<30; i++) {
			if(!submitted[i]) {
				ans.add(i+1);
			}
		}
		System.out.println(ans.get(0)<ans.get(1)? ans.get(0)+"\n"+ans.get(1):ans.get(1)+"\n"+ans.get(0));	
	}
}
