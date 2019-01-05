/*
* 快速排序
*
* 基本思想：
* 挖坑填数 + 分治法
* 首先选择一个基准值
* 通过一趟排序将待排序记录分割成独立的两部分，
* 其中一部分记录的关键字均比另一部分关键字小，
* 则分别对这两部分继续进行排序，直到整个序列有序。
*
* 算法描述
* 快速排序使用分治侧率来吧一个序列分成两个子序列。 步骤为：
* 1. 从数列中挑出一个元素，称为pivot;
* 2. 重新排序数列，所有比基准值小的元素放在基准前面，所有比基准值大的放在基准后面，相同的数可以到任一边。
*    在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区操作
* 3. 递归地(recursively) 把小于基准元素的子数列和大雨基准值得子数列排序
*
*
* 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，
* 因为每次的迭代(iteration)中，它至少会把一个元素摆到它最后的位置去。
*
*
* */

import java.util.*;

public class QuickSort
{
	int[] arr;

	public QuickSort(int[] arr)
	{
		this.arr = arr;
	}

	public void quickSort(int low, int high)
	{
		int left = low;
		int right = high;

		if (arr.length <= 0 || left >= right) {
			return;
		}

		int temp = arr[left];

		while(left < right) {
			while(left < right && arr[right] >= temp) {
				right--;
			}

			arr[left] = arr[right];

			while(left < right && arr[left] <= temp) {
				left++;
			}

			arr[right] = arr[left];
		}

		arr[left] = temp;
		System.out.println("Quick Sort: " + Arrays.toString(arr));

		quickSort(low, left - 1);
		quickSort(left + 1, high);
	}

	public static void main(String[] args)
	{
		int[] arr = {6, 5, 7, 5, 43, 233, 32, 324, 34, 4354, 55};

		QuickSort qs = new QuickSort(arr);
		qs.quickSort(0, 10);
	}
}
