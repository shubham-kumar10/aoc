import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {
	public static int twoSum(List<Integer> nums, int target) {
		Map<Integer,Integer> diffValues = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.size();i++) {
			diffValues.put(target-nums.get(i), i);
		}
		
		for(int i:nums) {
			if(diffValues.containsKey(i)) {
				System.out.println(i+" "+diffValues.get(i));
				return i*(target-i);
			}
		}
		return -1;
	}
	
	public static int threeSum(List<Integer> nums, int target) {
		Collections.sort(nums);
		int left,right;
		for (int i = 0; i < nums.size() - 2; i++) { 
            left = i + 1;
            right = nums.size() - 1; 
            while (left < right) { 
                if (nums.get(i) + nums.get(left) + nums.get(right) == target) {  
                    return nums.get(i)*nums.get(left)*nums.get(right); 
                } 
                else if (nums.get(i) + nums.get(left) + nums.get(right) < target) 
                    left++; 
  
                else  
                    right--; 
            } 
        }
		return -1;
	}

	public static void main(String[] args) throws IOException {
		List<Integer> nums = new ArrayList<Integer>();
		File file = new File("./src/inputDay1.txt");
		int target = 2020;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
			nums.add(Integer.parseInt(st));
		br.close();
		System.out.println(twoSum(nums,target));
		System.out.println(threeSum(nums, target));
	}
}