import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String sungmin = br.readLine();

		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {				
				str = str.replace(String.valueOf(str.charAt(i)), " ");
			}

		}
			
		str = str.replace(" ", "");
		
		if(str.contains(sungmin))
			System.out.println(1);
		else
			System.out.println(0);
	}
}