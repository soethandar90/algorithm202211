package w1d1.question1;

import java.util.Arrays;
import java.util.Random;

public class ComparingAlgo {

	public static void main(String args[]) {
		System.out.println("---Algo1----");
		System.out.println(algo1(new int[] { 1, 2, 3, 4, 5, 6 }, 2, 6));
		System.out.println(algo1(new int[] { 1, 2, 2, 2, 3, 4, 5, 6 }, 2, 6));
		System.out.println(algo1(new int[] { 1, 2, 2, 2, 3, 4, 5, 6 }, 2, 2));
		System.out.println("---Algo2----");
		System.out.println(algo2(new int[] { 1, 2, 3, 4, 5, 6 }, 2, 6));
		System.out.println(algo2(new int[] { 1, 2, 2, 2, 3, 4, 5, 6 }, 2, 6));
		System.out.println(algo2(new int[] { 1, 2, 2, 2, 3, 4, 5, 6 }, 2, 2));
		System.out.println("---Algo3----");
		System.out.println(algo3(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(algo3(new int[] { 1, 2, 2, 2, 3, 4, 5, 6 }));
		System.out.println(algo3(new int[] { 1, 2, 2, 2, 3, 4, 5, 6 }));
	}

	// To test by different problem sizes :
	// 1000, 2000, 3000, 4000, Åc, 10000

	private static int[] genInput(int size) {
		Random rd = new Random(); // creating Random object
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = rd.nextInt(); // storing random integers in an array
			// System.out.println(a[i]); // printing each array element
		}
		return a;
	}

	public static int algo1(int[] a, int num1, int num2) {
		int[] b = new int[a.length];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				b[j] = a[i];
				j++;
			}
		}

		if (b[0] == 0) {
			System.out.println("There is no even number in the input array.");
			return -1;
		}

		int index1 = -1;
		int index2 = -1;
		int i = 0;
		while (b[i] > 0) {
			if (num1 != num2) {
				if (b[i] == num1 && index1 < 0) {
					index1 = i;
				}
				if (b[i] == num2) {
					index2 = i;
				}
			} else {
				if (b[i] == num1) {
					if (index1 < 0) {
						index1 = i;
					} else {
						index2 = i;
					}
				}
			}
			i++;
		}
		return index2 - index1;
	}

	public static int algo2(int[] a, int num1, int num2) {
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				if (num1 != num2) {
					if (a[i] == num1 && index1 < 0) {
						index1 = i;
					}
					if (a[i] == num2) {
						index2 = i;
					}
				} else {
					if (a[i] == num1) {
						if (index1 < 0) {
							index1 = i;
						} else {
							index2 = i;
						}
					}
				}
			}
		}
		return index2 - index1;
	}

	public static int algo3(int[] a) {
		int minOfEven = 0;
		int maxOfEven = 0;
		boolean firstFlg = true;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				if (firstFlg) {
					minOfEven = a[i];
					maxOfEven = a[i];
					firstFlg = false;
				} else {
					if (a[i] < minOfEven) {
						minOfEven = a[i];
					}
					if (a[i] > maxOfEven) {
						maxOfEven = a[i];
					}
				}
			}
		}

		return maxOfEven - minOfEven;
	}

	public static int algo4(int[] a) {
		return Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt();
	}
}
