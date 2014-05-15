package rubinstein.interview;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// ArrayList<Integer> nums = new ArrayList<Integer>();
		// System.out.println("Enter 10 digits: ");
		// for (int i = 0; i < 10; i++) {
		// int num = input.nextInt();

		// if (!nums.contains(num)) {
		// nums.add(num);
		// }
		// }
		// for (int x : nums) {
		// System.out.print(x + " ");
		// }

		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		System.out.println("Enter 10 digits: ");
		for (int i = 0; i < 10; i++) {
			int num = input.nextInt();

			if (list.containsKey(num)) {
				int value = list.get(num);
				list.put(num, ++value);
			} else {
				list.put(num, 1);
			}
		}

		System.out.print(list);

	}
}
