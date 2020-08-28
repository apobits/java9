package apo.java.practice.codewars;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class ArrayElementParity {

    public static void main(String[] args) {
	assertEquals(2, solve(new int[] { -16, -343, -32, -262, 974, -867, 582, 226, 490, -490, -133, -158, 59, -612,
			-266, 836, -834, 398, -933, 101, 942, -863, -559, 16, 590, -421, 776, -195, -780, -942, -590,
			266, 198, 330, 48, 158, -330, 260, 780, 867, -115, 262, -616, 901, 620, 656, -776, 933, 560,
			430, -901, 397, 133, 959, -71, 834, 115, 510, -540, -101, 71, -974, 559, -198, -582, -72, -586,
			863, 275, 550, -550, -495, -934, -226, -488, -686, -836, 72, 88, 726, 488, 100, 533, 2, -385,
			-888, -88, -48, -59, -726, 612, -100, -430, 343, 586, -560, -397, -656, -260, -275, -533, 421,
			686, -398, 540, 842, 934, 888, 385, 616, -842, -959, 495, 32, 195, -510, -620 }));
    }

    public static int solve(int[] arr) {
	Arrays.sort(arr);
	var leftIndex = 0;
	var rightIndex = arr.length - 1;

	while (leftIndex < rightIndex && arr[leftIndex] + arr[rightIndex] == 0) {
	    leftIndex++;
	    rightIndex--;
	}

	if (leftIndex == rightIndex) {
	    return arr[leftIndex];
	}

	var leftVal = arr[leftIndex];
	var rightVal = arr[rightIndex];
	while (leftIndex < rightIndex) {
	    if (leftVal + arr[--rightIndex] == 0) {
		return rightVal;
	    }
	}
	return leftVal;
    }
}
