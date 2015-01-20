package misc;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();

		if (s != null && !s.equals("")) {
			String[] nums = s.split("[ ]");
			int[] array = new int[nums.length];
			int j = 0;
			for (String each : nums) {
				if (each != null && !each.trim().equals("")) {
					array[j++] = Integer.parseInt(each);
				}
			}
			Arrays.sort(array);
			int newLength = removeDuplicates(array);

			for (int i = 0; i < newLength; i++) {
				System.out.println(array[i]);
			}
		}
	}

	public static int removeDuplicates(int[] array) {

		if (array.length < 2)
			return array.length;
	 
		int j = 0;
		int i = 1;
	 
		while (i < array.length) {
			if (array[i] == array[j]) {
				i++;
			} else {
				j++;
				System.out.println(array[i]);
				array[j] = array[i];
				i++;
			}
		}
	 
		return j + 1;

	}
}
