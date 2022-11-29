package w1d2.question1;

public class ComparingAlgo {
	public static void main(String[] args) {
		System.out.println(findThirdLargest(new int[] { 7, 20, 18, 4, 20, 19, 20, 3 }));
		//System.out.println(findThirdLargest(new int[] { 7, 18, 4, 20, 19, 20, 3 }));
		//System.out.println(findThirdLargest(new int[] { 7, 18, 4, 19, 20, 3 }));
		//System.out.println(findThirdLargest(new int[] { 7, 7, 7, 7}));
	}

	public static int findThirdLargest(int[] a) {
		int max = a[0];
		int cnt = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				cnt = 1;

			} else if (a[i] == max) {
				cnt++;
			}
		}

		int secondMax = a[0];
		if (cnt >= 2) {
			secondMax = max;
			cnt -= 1;
		} else {
			for (int i = 1; i < a.length; i++) {
				if (a[i] > secondMax && a[i] < max) {
					secondMax = a[i];
					cnt = 1;
				} else if (a[i] == secondMax) {
					cnt++;
				}
			}
		}

		int thirdMax = a[0];
		if (cnt >= 2) {
			thirdMax = secondMax;
			cnt -= 1;
		} else {
			for (int i = 1; i < a.length; i++) {
				if (a[i] > thirdMax && a[i] < secondMax) {
					thirdMax = a[i];
					cnt = 1;
				} else if (a[i] == thirdMax) {
					cnt++;
				}
			}
		}

		return thirdMax;
	}
}