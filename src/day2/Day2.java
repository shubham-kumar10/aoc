package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

	public static boolean checkPasswordOne(int low, int high, char ch, String password) {
		int freq=0;
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)==ch) {
				freq++;
			}
		}
		if(freq>=low && freq<=high)
			return true;
		else 
			return false;
	}
	
	public static boolean checkPasswordTwo(int low, int high, char ch, String password) {
		if((password.charAt(low-1)==ch && password.charAt(high-1)!=ch) || 
				password.charAt(low-1)!=ch && password.charAt(high-1)==ch)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("./src/day2/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		int countOne = 0, countTwo=0;
		while ((st = br.readLine()) != null) {
			int indexOfDash = st.indexOf('-');
			int indexOfSpace = st.indexOf(' ');
			int indexOfColon = st.indexOf(':');
			int low = Integer.parseInt(st.substring(0, indexOfDash));
			int high = Integer.parseInt(st.substring(indexOfDash + 1, indexOfSpace));
			char ch = st.substring(indexOfSpace + 1, indexOfColon).charAt(0);
			String password = st.substring(indexOfColon + 2);
			countOne = checkPasswordOne(low, high, ch, password) ? countOne+1 : countOne;
			countTwo = checkPasswordTwo(low, high, ch, password) ? countTwo+1 : countTwo;
		}
		br.close();
		System.out.println(countOne);
		System.out.println(countTwo);
	}
}
