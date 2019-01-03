/*
* 希尔排序
*
* 也称递减增量排序算法，是插入排序的一种告诉而稳定的改进版本
*
* 基本思想
* 先将整个待排序的记录序列分割成若干子序列分别进行直接插入排序，
* 待整个序列中的记录“”基本有序"时，再对全体记录进行依次直接插入排序
*
*
* 算法描述
* 1. 选择一个增量序列t1, t2, ..., tk,其中tk > tj, tk = 1;(一般初次取数组半长，之后每次再减半，知道增量为1)
* 2. 设置增量序列个数k,对序列进行K趟排序；
* 3. 每趟排序，根据相应的增量ti, 将待排序分割成若干长度为m的子序列，分别对各子表进行直接插入排序。 仅
*    增量因子为1时，整个序列作为一个表来处理，表长度即为序列的长度。
*
*
* */

import java.util.*;

public class ShellSort
{
	public int[] arr;

	public ShellSort(int[] arr)
	{
		this.arr = arr;
	}

	public void shellSort()
	{
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int j = 0; j + gap < arr.length; j++) {
				for (int k = 0; k + gap < arr.length; k += gap) {
					if (arr[k] > arr[k + gap]) {
						int temp = arr[k + gap];
						arr[k + gap] = arr[k];
						arr[k] = temp;
					}
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args)
	{
		int[] arr = {0, 33, 44, 3, 6, 7777, 755, 63, 5, 54, 5464545, 645 ,54 ,54, 98};

		ShellSort ss = new ShellSort(arr);

		ss.shellSort();
	}
}
