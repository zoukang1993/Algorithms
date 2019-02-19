/*
* 哈希表  Hash Table
* O(1)
* 也称散列表
* 一种用于存储键值对(key-value pair) 的数据结构
*
* 散列函数
* 在散列表内部，我们使用桶(bucket)来保存键值对，我们假设的数组的索引即为桶号，决定了
* 给定的键存于散列表的哪个桶。散列表所拥有的桶数称为散列表的容量(capacity).
*
* hash 就是找到一种数据内容和数据存放地址之间的映射关系
*
* locationStorage = f(key)
*
* 集中构造Hash函数的方法：
	* 1 直接定址法   取关键字或者关键字的某个线性 函数为Hash地址
	* 2 平方取中发   对关键字进行平方运算，然后取结构的中间几位最为Hash地址
	* 3 折叠发      将关键字拆分成几部分，然后将这几部分组合在一起，以特定的方式进行转化形成Hash地址
	* 4 除留取余法   如果知道Hash表的最大长度为m, 可以取不大于m的最大质数p，然后对关键字进行取余运算，address(key) = key % p
*
*
* 冲突的解决
	* 当关键字集合很大时，关键字值不同的元素可能会映射到哈希表的同一个地址上。
	* k1 != k2, f(k1) = f(k2)
	* 冲突不能解决，记录将无法正确的存储
	* 但是冲突时无法避免的
	*
	* 1 开饭定址法
	*   即当一个关键字和另一个关键字发生冲突时，使用某种探测技术在Hash表中形成一个探测序列，然后沿着这个探测序列依次查找下去
	*   当碰到一个空的单元时，则插入其中。比较常用的一个方法是线性探测法
	* 2 链地址法
	*   采用数组和链表相结合的方法，将Hash地址相同的记录存储在一张线性表中，而每张表的表头的序号即为计算得到的Hash地址
*
*
* */

import java.util.HashMap;

public class HashTable {
	HashMap<String, String> capitalCities;

	public HashTable() {
		capitalCities = new HashMap<String, String>();
	}

	public void hashTable() {
		capitalCities.put("England", "London");
		capitalCities.put("Germany", "Berlin");
		capitalCities.put("Norway", "Oslo");
		capitalCities.put("USA", "Washington DC");
		System.out.println(capitalCities);
	}

	public void getCity(String key) {
		capitalCities.remove("England");

		String city = capitalCities.get(key);
		System.out.println(city);      // null
	}

	public int size() {
		return capitalCities.size();
	}

	public void printKey() {
		for (String i : capitalCities.keySet()) {
			System.out.println(i);
		}
	}

	public void printValues() {
		for (String i : capitalCities.values()) {
			System.out.println(i);
		}
	}

	public void clear() {
		capitalCities.clear();
	}

	public static void main(String[] args) {
		HashTable ht = new HashTable();

		ht.hashTable();
		System.out.println("------------------------");

		ht.getCity("England");
		System.out.println("------------------------");

		ht.printKey();
		System.out.println("------------------------");
		ht.printValues();
	}
}
