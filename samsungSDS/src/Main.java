import java.io.*;
import java.util.*;

public class Main {
	
	//Ctrl + 1
	static class student implements Comparable<student>{
		int age, score;
		long money;

		public student(int age, int score) {
			super();
			this.age = age;
			this.score = score;
		}

		@Override
		public int compareTo(student arg0) {
			if(this.money > arg0.money) return 1;
			else if(this.money < arg0.money) return -1;
			return 0;
		}
		
		
	}
	
	static int [] array;
	
	
	public static void main(String[] args) {
		//Arrays.sort(array, Comparator.reverseOrder());
		//System.out.println(Integer.MAX_VALUE);
	}
	
	int binarySearch(int start, int end, int value) {

		int mid;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(array[mid]==value) return mid; //1.정답
			else if(array[mid]>value)	end = mid - 1;	//2.up
			else if(array[mid]<value)	start = mid + 1;	//3.down
		}
		return -1;
	}
	
	//재귀로 피보나치 구현해보기(top-down)
	int fibo1(int n) {
		return n<=2 ? 1 : fibo1(n-2) + fibo1(n-1);
	}
	
	//했던 연산 안하게(bottom-up) => Dynamic Programming 동적계획법 "메모기반 완전탐색"
	int fibo2(int n) {
		int [] fibo = new int[101];
		fibo[1] = fibo[2] = 1;
		for(int i=3;i<=n;i++) {
			fibo[i] = fibo[i-2]+fibo[i-1];
		}
		return fibo[n];
	}
	
}