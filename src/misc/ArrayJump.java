package misc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayJump {

	public static boolean outOfArray = false;
	public static String FAILURE = "failure";
	public static String OUT = "out";
	public static String COMMA = ", ";

	public static void main(String[] args) {
		Scanner scanner;
		try {
			List<Integer> array = new ArrayList<Integer>();
			scanner = new Scanner(System.in);

			while (scanner.hasNextLine()) {
				String number = scanner.nextLine();
				if (number.length() == 0)
					break;
				int val = Integer.parseInt(number);
				array.add(val);
			}

			int[] inputArray = new int[array.size()];
			for (int i = 0; i < array.size(); i++) {
				inputArray[i] = array.get(i);
			}
			List<Integer> list = getOptimalHops(inputArray);
			if (list.size() < 1 || !outOfArray) {
				System.out.println(FAILURE);
			} else {
				print(list);
			}
		} catch (Exception e) {
			System.out.println(FAILURE);
		}
	}

	public static void print(List<Integer> list) {
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + COMMA);
		}
		System.out.println(OUT);
	}

	public static List<Integer> getOptimalHops(int[] array) {
		List<Integer> result = new ArrayList<Integer>();

		if (array == null || array.length < 1) {
			return result;
		}

		if (array[0] == 0 || (array[0] == 1 && array[1] == 0)) {
			return result;
		}

		int index = 0;
		int fly = 0;
		int possibleHops = 1;
		int maximumHops = 0;

		while (index < array.length) {
			if (array[index] == 0) {
				index++;
				continue;
			}
			if (index + array[index] > maximumHops) {
				maximumHops = index + array[index];
				fly = index;
				if (maximumHops >= array.length) {
					result.add(fly);
					outOfArray = true;
					break;
				}
			}
			possibleHops--;
			if (possibleHops == 0) {
				result.add(fly);
				possibleHops = maximumHops - index;
			}
			index++;
		}
		return result;
	}

}
