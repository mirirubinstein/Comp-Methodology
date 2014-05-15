package rubinstein.maxSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxSum {
	private final int size;
	private final int[][] array;

	// private final int[][] array= { { 0, -2, -7, 0 }, { 9, 2, -6, 2 },
	// { -4, 1, -4, 1 }, { -1, 8, 0, -2 } };

	public MaxSum() throws FileNotFoundException {
		Scanner info = new Scanner(new File("maxsum.txt"));
		size = info.nextInt();
		array = new int[size][size];
		while (info.hasNext()) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					array[i][j] = info.nextInt();
					// //system.out.print(array[i][j] + "\t");
				}
				// //system.out.println();
			}
		}
	}

	public int findMaxRectangleForPoint(int x, int y, int width, int height) {
		int maxSum = -100;
		// int rowSum = -100;

		for (int i = 0; i < size - y - 1; i++) {// KNOCK OFF ROWS FROM BOTTOM
			int rectangleSum = 0; // int

			for (int j = y; j < size - i; j++) {
				int rowSum = 0;
				for (int k = x; k < size; k++) {

					rowSum += array[j][k];
					// system.out.println(array[j][k] + "\t" + rowSum);
				}

				rectangleSum += rowSum;
				// system.out.println(rectangleSum);

			}
			if (rectangleSum > maxSum) {
				maxSum = rectangleSum;
			}
			// system.out.println(maxSum + "\nNEXT PART");
		}
		for (int i = 0; i < size - x - 1; i++) {// KNOCK OFF ROWS FROM RIGHT
			int rectangleSum = 0;

			for (int j = y; j < size; j++) {
				int rowSum = 0;
				for (int k = x; k < size - i; k++) {

					rowSum += array[j][k];
					// system.out.println(array[j][k] + "\t" + rowSum);
				}

				rectangleSum += rowSum;
				// system.out.println(rectangleSum);

			}
			if (rectangleSum > maxSum) {
				maxSum = rectangleSum;
			}
			// system.out.println(maxSum + "\nNEXT PART");
		}

		int greater;
		int lesser;

		if (x > y) {

			for (int i = 0; i < size - x - 1; i++) {// FIND SQUARES
				int rectangleSum = 0;
				for (int j = y; j < size - i - x; j++) {
					int rowSum = 0;
					for (int k = x; k < size - i; k++) {

						rowSum += array[j][k];
						// system.out.println(array[j][k] + "\t" + rowSum);
					}

					rectangleSum += rowSum;
					// system.out.println("current rectangle sum: " +
					// rectangleSum);
					if (rectangleSum > maxSum) {
						maxSum = rectangleSum;
					}
				}

				// system.out.println("Max: " + maxSum);
			}
		} else if (y > x) {
			for (int i = 0; i < size - y - 1; i++) {// FIND SQUARES
				int rectangleSum = 0;
				for (int j = y; j < size - i; j++) {
					int rowSum = 0;
					for (int k = x; k < size - i - y; k++) {

						rowSum += array[j][k];
						// system.out.println(array[j][k] + "\t" + rowSum);
					}

					rectangleSum += rowSum;
					// system.out.println("current rectangle sum: " +
					// rectangleSum);
					if (rectangleSum > maxSum) {
						maxSum = rectangleSum;
					}
				}

				// system.out.println("Max: " + maxSum);
			}
		} else {
			for (int i = 0; i < size - 1 - x; i++) {// FIND SQUARES
				int rectangleSum = 0;
				for (int j = y; j < size - i; j++) {
					int rowSum = 0;
					for (int k = x; k < size - i; k++) {

						rowSum += array[j][k];
						// system.out.println(array[j][k] + "\t" + rowSum);
					}

					rectangleSum += rowSum;
					// system.out.println("current rectangle sum: " +
					// rectangleSum);
					if (rectangleSum > maxSum) {
						maxSum = rectangleSum;
					}
				}

				// system.out.println("Max: " + maxSum);
			}
		}
		return maxSum;
	}

	public int findMaxSumOfArray() {
		int max = -100;
		for (int i = 0; i < getSize() - 1; i++) {
			for (int j = 0; j < getSize() - 1; j++) {
				int num = findMaxRectangleForPoint(i, j, size - i, size - j);
				if (num > max) {
					max = num;
				}
			}
		}
		return max;
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) throws FileNotFoundException {
		MaxSum max = new MaxSum();

		/*
		 * int size = max.getSize() - 1; for (int i = 0; i < max.getSize() - 1;
		 * i++) { for (int j = 0; j < max.getSize() - 1; i++) {
		 * max.findMaxRectangleForPoint(i, j, size - i, size - j); } }
		 */
		// max.findMaxRectangleForPoint(0, 1, 4, 3);
		// max.findMaxRectangleForPoint(2, 2, 2, 4);
		// max.findMaxRectangleForPoint(1, 2, 3, 3);
		System.out.println(max.findMaxSumOfArray());
	}
}
