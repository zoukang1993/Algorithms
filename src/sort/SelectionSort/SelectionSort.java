/*
* 选择排序  Selection Sort
*
* 基本思想
	* 比较 + 交换
	* 再未排序列中找出最大(小) 元素，存放在未排序序列的起始位置。
	* 在所有完全依赖交换取移动元素的排序方法中，选择排序属于非常好的一种
*
* 算法描述
* 1. 从待排序的序列中，找到关键字最小的元素；
* 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
* 3. 从余下的N - 1 个元素中，找出关键字最小的元素，重复1， 2步, 直到排序结束；
*
* */

import java.util.*;

public class SelectionSort
{
	int[] arr;

	public SelectionSort(int[] arr)
	{
		this.arr = arr;
	}

	public void selectionSort()
	{
		for(int i = 0; i < arr.length - 1; i++){
			int min = i;

			for(int j = i + 1; j < arr.length; j++) {   // find the minimum number
				if(arr[j] < arr[min]){
					min = j;
				}
			}

			if(min != i){
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;

				System.out.println("Sorting:  " + Arrays.toString(arr));
			}
		}

		System.out.println("RESULT :" + Arrays.toString(arr));
	}

	public static void main(String[] args)
	{
		int[] array = {2, 3, 4, 77, 6, 65, 4, 7, 0, 7};

		SelectionSort ss = new SelectionSort(array);

		ss.selectionSort();

	}
}
