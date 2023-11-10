import java.io.*;
import java.util.*;

public class day4 {
	static int N, id, taste, max;;
	static int[] input;	//�Է�
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		taste = max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			input[i] = Integer.parseInt(st.nextToken());
			//���� ū ���� ���� ������ ����
			if(max < input[i]){
				max = input[i];
			}
			//������ ���̻� �̷����� �ʴ´ٸ�, ���� ū �� �������� �����ؾ���
			else {
				if(input[i]>input[i-1]) {
					System.out.println(0);
					return;
				}
			}
			taste += input[i];
		}
	
		System.out.println(taste);
		br.close();
	}
}