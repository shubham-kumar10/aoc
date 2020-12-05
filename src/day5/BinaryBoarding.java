package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryBoarding {

	public static String createBinary(String S) {
		String result = "";
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'F' || S.charAt(i) == 'L') {
				result = result + '0';
			} else {
				result = result + '1';
			}
		}
		return result;
	}

	public static int binaryToDecimal(String bin) {
		int result = 0;
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == 'R' || bin.charAt(i) == 'B') {
				result = (int) Math.pow(2, bin.length() - 1 - i) + result;
			}
		}
		return result;
	}
	
	public static int findMySeat(ArrayList<Integer> seatList) {
		Collections.sort(seatList);
		for (Integer seatId : seatList) {
			if (!seatList.contains(seatId - 1) && seatList.contains(seatId - 2)) {
				return(seatId - 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("./src/day5/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		int maxId = 0;
		ArrayList<Integer> seatList = new ArrayList<Integer>();
		while ((st = br.readLine()) != null) {
			String row = st.substring(0, 7);
			String seat = st.substring(7);
			int seatId = binaryToDecimal(row) * 8 + binaryToDecimal(seat);
			if (seatId > maxId) {
				maxId = seatId;
			}
			seatList.add(seatId);
		}
		br.close();
		System.out.println(maxId);
		System.out.println(findMySeat(seatList));
	}
}