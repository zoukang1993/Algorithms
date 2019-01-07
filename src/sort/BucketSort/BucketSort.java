/*
* 桶排序 BucketSort
*
* 基本思想：
	* 把数组arr划分为n个大小相同的子区间，每个子区间各自排序，最后合并
	* 计数排序是其中特殊情况，可把计数排序当成每一个桶里只有一个元素的情况
*
* 算法描述
	* 找出待排序数据中的max, min;
	* 我们使用动态数组ArrayList作为组，桶里放的元素也用ArrayList存储、 桶的数量为（max - min）/ arr.length + 1;
	* 遍历数组arr，计算每个元素arr[i] 放的桶；
	* 每个桶各自排序
	* 遍历桶数组，把排序好的元素放进输出数组
*
* */

/*
* 复杂度
*
* 平均复杂度 ：
* O = (N + C)
* C = N * (logN - logM)
*
* O(N + M)
*
* */

import java.util.ArrayList;
import java.util.*;

public class BucketSort
{
	public int[] arr;
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	int bucketNum;
	int num;
	ArrayList<ArrayList<Integer>> bucketArr;

	public BucketSort(int[] arr)
	{
		this.arr = arr;
	}

	public void getMaxMin()
	{
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
	}

	public void bucketNum()
	{
		bucketNum = (max - min) / arr.length + 1;
		bucketArr = new ArrayList<>(bucketNum);

		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}
	}

	public void putElementIntoBucket()
	{
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / arr.length;
			bucketArr.get(num).add(arr[i]);
		}
	}

	public void sortEveryBucket()
	{
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}
	}

	public void bucketSort()
	{
		getMaxMin();
		bucketNum();
		putElementIntoBucket();
		sortEveryBucket();

		System.out.println(bucketArr.toString());
	}

	public static void main(String[] args)
	{
		int[] arr = {1, 25, 34, 4, 11, 12, 33, 44, 55};
		BucketSort bs = new BucketSort(arr);

		bs.bucketSort();

	}
}
