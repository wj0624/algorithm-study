import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		while(check) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==0&&b==0) {
				check= false;
				break;
			}
			System.out.println(a+b);
		}
	}
}
