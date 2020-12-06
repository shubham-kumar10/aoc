package day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomCustoms {

	public static int uniqueCharacterCount(String answers) {
		List<Character> alphabets = new ArrayList<Character>();
		for (int i = 0; i < answers.length(); i++) {
			char answer = answers.charAt(i);
			if (!alphabets.contains(answer)) {
				alphabets.add(answer);
			}
		}
		return alphabets.size();
	}

	public static void main(String[] args) throws IOException {
		File file = new File("./src/day6/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st, answers = "";
		int sum = 0;
		while ((st = br.readLine()) != null) {
			if (st.length() != 0) {
				answers = answers + st;
			} else {
				sum = sum + uniqueCharacterCount(answers);
				answers = "";
			}
		}
		// For last group of answers
		sum = sum + uniqueCharacterCount(answers);
		br.close();
		System.out.println("sum" + sum);
	}
}
