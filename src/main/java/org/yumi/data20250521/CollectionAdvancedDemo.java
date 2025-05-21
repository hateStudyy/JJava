package org.yumi.data20250521;

import java.util.*;

/**
 * Java集合类进阶知识演示
 * 包含更多集合类型和高级操作
 */
public class CollectionAdvancedDemo {
    public static void main(String[] args) {
        // 1. LinkedList示例 - 链表实现的List
        System.out.println("=== LinkedList示例 ===");
        LinkedList<String> linkedList = new LinkedList<>();

        // 添加元素
        linkedList.add("北京");
        linkedList.add("上海");
        linkedList.add("广州");

        // LinkedList特有的操作
        linkedList.addFirst("深圳");  // 在头部添加元素
        linkedList.addLast("杭州");   // 在尾部添加元素

        System.out.println("LinkedList: " + linkedList);
        System.out.println("第一个元素: " + linkedList.getFirst());
        System.out.println("最后一个元素: " + linkedList.getLast());

        // 2. TreeSet示例 - 有序、不重复的集合
        System.out.println("\n=== TreeSet示例 ===");
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 添加元素（无序添加）
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(10);
        treeSet.add(3);
        treeSet.add(5);  // 重复元素不会被添加

        // TreeSet会自动排序
        System.out.println("TreeSet自动排序后: " + treeSet);

        // TreeSet的导航方法
        System.out.println("第一个元素: " + treeSet.first());
        System.out.println("最后一个元素: " + treeSet.last());
        System.out.println("小于7的最大元素: " + treeSet.lower(7));
        System.out.println("大于4的最小元素: " + treeSet.higher(4));

        // 3. LinkedHashMap示例 - 保持插入顺序的Map
        System.out.println("\n=== LinkedHashMap示例 ===");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        // 添加键值对
        linkedHashMap.put("A01", "Java编程");
        linkedHashMap.put("B02", "Python编程");
        linkedHashMap.put("C03", "C++编程");

        // LinkedHashMap保持插入顺序
        System.out.println("LinkedHashMap (保持插入顺序): ");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 4. 集合排序操作
        System.out.println("\n=== 集合排序操作 ===");
        List<String> fruits = new ArrayList<>();
        fruits.add("香蕉");
        fruits.add("苹果");
        fruits.add("梨子");
        fruits.add("西瓜");

        System.out.println("排序前: " + fruits);

        // 使用Collections工具类进行排序
        Collections.sort(fruits);
        System.out.println("自然排序后: " + fruits);

        // 使用自定义比较器排序（按字符串长度）
        Collections.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println("按长度排序后: " + fruits);

        // 使用Lambda表达式简化
        fruits.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println("按长度降序排序后: " + fruits);

        // 5. 集合转换操作
        System.out.println("\n=== 集合转换操作 ===");

        // List转Array
        String[] fruitArray = fruits.toArray(new String[0]);
        System.out.println("List转Array: " + Arrays.toString(fruitArray));

        // Array转List
        String[] colorArray = {"红", "黄", "蓝"};
        List<String> colorList = Arrays.asList(colorArray);
        System.out.println("Array转List: " + colorList);

        // 注意：Arrays.asList返回的List是固定大小的，不支持add/remove操作
        // 如果需要可修改的List，可以这样做：
        List<String> modifiableList = new ArrayList<>(Arrays.asList(colorArray));
        modifiableList.add("绿");
        System.out.println("可修改的List: " + modifiableList);
    }
}
