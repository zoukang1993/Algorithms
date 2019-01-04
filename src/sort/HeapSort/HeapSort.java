/*
* Heap Sort  堆排序
*
* 基本思想
	* 以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，
	* 再把沙僧与的元素调整成堆，找出最大的再移走，重复直至有序。
*
* 算法描述
	* 1. 先将初始序列K[1...n]建成一个大堆，那么此时第一个元素K1最大，此堆为初始的无序区；
	* 2. 再将关键字最大的记录K1(即堆顶，第一个元素)和无序区的最后一个记录Kn交换，由此得到的新的无序区K[1...n-1]和有序区K[n],
	*    且满足K[1...n-1].keys <= K[n].key;
	* 3. 交换K1 和Kn 后，堆顶可能违反堆性质，因此需将K[1...N-1] 调整为堆，然后重复2，直到无序区只有一个元素停止。
*
* 代码实现
	* 从算法描述看，堆排序需要两个过程，一是建立堆，二是堆顶与堆得最后一个元素交换位置。
	* 所有堆排序有两个函数组成，一是建堆函数，二是反复调用建堆函数选择出剩余末排元素中最大的数来实现排序的函数
*
* 操作：
* 最大堆调整(Max_Heapify): 将堆得末端子节点做调整，使得子节点永远小于父节点
* 创建最大堆(Build_Max_Heap): 将堆得所有数据重新排序
* 堆排序(HeapSort): 移除位在第一个数据的根节点，并做最大堆调整的递归运算
*
*
* 对于堆节点的访问：
	* 父节点i的左子节点在位置: 2i + 1;
	* 父节点i的右子节点在位置： 2i + 2;
	* 子节点i的父节点在位置： floor((i - 1) / 2)
*
* */

import java.util.*;

public class HeapSort
{
	public int[] arr;

	public HeapSort(int[] arr)
	{
		this.arr = arr;
	}

	public void heapSort()
	{
		for (int i = arr.length; i > 0; i--) {
			max_heapify(i);

			int temp = arr[0];
			arr[0] = arr[i - 1];
			arr[i - 1] = temp;
		}
	}

	public void max_heapify(int limit)
	{
		if (arr.length <= 0 || arr.length < limit) {
			return;
		}

		for (int parentIdx = limit / 2; parentIdx >= 0; parentIdx--) {
			if (parentIdx * 2 >= limit) {
				continue;
			}

			int left = parentIdx * 2;
			int right = left + 1 >= limit ? left : left + 1;
			int maxChild = arr[left] >= arr[right] ? left : right;
			if (arr[maxChild] > arr[parentIdx]) {
				int temp = arr[parentIdx];
				arr[parentIdx] = arr[maxChild];
				arr[maxChild] = temp;
			}
		}

		System.out.println("Max_Heapify: " + Arrays.toString(arr));
	}

	public static void main(String[] args)
	{
		int[] arr = {0,1,4,44,3,3,453,43,34,34,34,545,54,665,56,56,65,56};

		HeapSort hs = new HeapSort(arr);

		hs.heapSort();
	}
}
