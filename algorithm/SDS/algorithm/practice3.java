package algorithm;
public class practice3{
	
	//�ִ� ����� ���ϱ�
	//��Ŭ����ȣ���� �̿��� �״�� �ڵ� ����
	//��Ŭ����ȣ���� : gcd(a,b) = gcd(b,r) (r=a%b)
	static int getGcd1(int a, int b) {
		int r = a % b;
		if(r == 0) {
			return b;
		}
		return getGcd1(b, r);
	}
	
	//�ð� ���⵵ ���� ����
	static int getGcd2(int a, int b) {
		int r;
			while (b!=0) {
				r = a%b;
				a = b;
				b = r;
			}
			return a;
	}
	
	//�����佺�׳׽��� ü
}