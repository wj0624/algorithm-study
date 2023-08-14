package algorithm;
public class practice3{
	
	//최대 공약수 구하기
	//유클리드호제법 이용해 그대로 코드 구현
	//유클리드호제법 : gcd(a,b) = gcd(b,r) (r=a%b)
	static int getGcd1(int a, int b) {
		int r = a % b;
		if(r == 0) {
			return b;
		}
		return getGcd1(b, r);
	}
	
	//시간 복잡도 줄인 버젼
	static int getGcd2(int a, int b) {
		int r;
			while (b!=0) {
				r = a%b;
				a = b;
				b = r;
			}
			return a;
	}
	
	//에라토스테네스의 체
}