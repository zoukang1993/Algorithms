/*
* Bubble sort
*
* 冒泡排序是一种简单的排序算法。
* 它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
* 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
* 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
*
* 基本思路：
* 比较相邻的元素。如果第一个比第二个大，就交换位置。
* 对每一对相邻元素做同样的工作，从开始第一对到结尾最后一对。在这一点，最后的元素应该是最大数。
* 针对所有的元素重复以上的步骤，除了最后一个。
* 持续每次对越来越少的元素重复以上的步骤，知道没有任何一对数字需要比较
*
*
* */

import java.util.*;

public class BubbleSort
{
	public int[] arr;
	int temp;

	public BubbleSort(int[] arr)
	{
		this.arr = arr;
	}

	public void bubbles()
	{
		int size = arr.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args)
	{
		int[] arr = {11, 22, 14, 44, 654, 454, 343, 88, 55, 543, 33, 334, 333};

		BubbleSort bs = new BubbleSort(arr);

		bs.bubbles();
	}
}
