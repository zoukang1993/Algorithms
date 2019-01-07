/*
* 归并排序  Merging Sort
*
* 基本思想
* 归并排序算法是将两个以上有序列表合并成一个新的有序表，
* 即把待排序序列分为若干个子序列，每个子序列是有序的。
* 然后再把有序子序列合并为整体有序序列
*
* 算法描述
* 归并排序可通过两种方式实现：
*
* 自上而下的递归
* 	1. 将序列每相邻两个数字进行归并操作，形成floor(n / 2)个排序，排序后每个序列包含两个元素；
* 	2. 将上述序列再进行归并，形成floor(n / 4)个序列，每个序列包含四个元素；
*   3. 重复步骤二，直到所有元素排序完毕。
*
* 自下而上的迭代
* 	1. 申请空间， 使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
*   2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
*   3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
*   4. 重复步骤三，直到某一之神到达序列尾，
*   5. 将另一序列剩下的所有元素直接复制到合并序列尾。
*
* */

import java.util.*;

public class MergingSort
{
	int[] array;

	public MergingSort(int[] arr)
	{
		array = arr;
	}

	public void playing()
	{
		int[] result = mergeSort(array);

		System.out.println("result: " + Arrays.toString(result));
	}

	public int[] mergeSort(int[] arr)
	{
		if (arr.length <= 1) {
			return arr;
		}

		int num = arr.length >> 1;

		int[] leftArr = Arrays.copyOfRange(arr, 0, num);
		int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);

		return mergeTwoArray(mergeSort(leftArr), mergeSort(rightArr));
	}

	public int[] mergeTwoArray(int[] left, int[] right)
	{
		int i = 0, j = 0, k = 0;
		int[] result = new int[left.length + right.length];

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}

		while (i < left.length) {
			result[k++] = left[i++];
		}

		while (j < right.length) {
			result[k++] = right[j++];
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[] arr = {0, 2, 1, 55, 32, 4645, 656, 234, 564, 65, 76,435 ,32};

		MergingSort ms = new MergingSort(arr);

		ms.playing();
	}
}
