import java.util.*;

public class Test
{
	public Test()
	{

	}

	public static void sorts()
	{
		Integer[] arr1 = {1, 2 ,3, 4};
		Integer[] arr2 = {6, 7, 8, 9};

		int result = arr1[1].compareTo(arr2[2]);
		boolean res = arr1[1] > arr2[1];

		System.out.println(res);
	}

	public static void main(String[] args)
	{
		Test.sorts();
	}
}