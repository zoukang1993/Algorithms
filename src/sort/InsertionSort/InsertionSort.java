/*
* 直接插入排序 Insertion Sort
*
* 基本思想
* 将数组中得所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，
* 则交换，知道全部元素都比较过位置。
*
*
* 算法描述
* 1. 从第一个元素开始，该元素可以被认为已经被排序
* 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描，
* 3. 如果该元素大于新元素，则该元素移动到下一位置
* 4. 重复3，知道找到已排序的元素小于或等于新元素
* 5. 将新元素插入到该位置后
* 6. 重复步骤2~5
*
* */

import java.util.*;

public class InsertionSort
{

	public static void insertionSort(int[] arr)
	{
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];

			for (int j = i; j >= 0; j--) {
				if (j > 0 && arr[j - 1] > temp) {
					arr[j] = arr[j - 1];
				} else {
					arr[j] = temp;
					break;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void multiInsertionSort(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j - 1] <= arr[j]) {
					break;
				}

				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args)
	{
		int[] array1 = {2, 3, 1, 5, 66, 5, 44, 3, 9999, 7, 7, 9, 54, 5};

		InsertionSort.insertionSort(array1);
		InsertionSort.multiInsertionSort(array1);
	}
}
