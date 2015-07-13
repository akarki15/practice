package leet;

public class MedianTwoSortedArrays {
	public static void main(String[] args) {
		int[] a1 = { 1, 2, 30 };
		int[] a2 = { 10, 20, 30, 40 };
		System.out.println(findMedianSortedArrays(a1, a2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalSize = nums1.length + nums2.length;
		int med = findRank(nums1, 0, nums1.length - 1, nums2, 0,
				nums2.length - 1, totalSize / 2);
		if (totalSize % 2 == 0) {
			int med2 = findRank(nums1, 0, nums1.length - 1, nums2, 0,
					nums2.length - 1, ((int) totalSize / 2) + 1);
			med = (med + med2) / 2;
		}
		return med;
	}

	public static int findRank(int[] nums1, int i, int j, int[] nums2, int a,
			int b, int rank) {
		int index1 = (int) ((j - i) / 2); // center index for nums1
		int index2 = (int) ((b - a) / 2); // center index for nums2
		System.out.println(index1 + "   " + index2);
		if (nums1[index1] < nums2[index2]) {
			if ((index1 + 1) == rank) {
				return nums1[index1];
			} else {
				return findRank(nums1, index1 + 1, j, nums2, a, index2 - 1,
						rank - index1 - 1);
			}
		}
		{
			if ((index2 + 1) == rank) {
				return nums2[index2];

			} else {
				return findRank(nums1, i, index1 - 1, nums2, index2 + 1, b,
						rank - index2 - 1);
			}
		}

	}
}
