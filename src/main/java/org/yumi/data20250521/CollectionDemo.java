package org.yumi.data20250521;

import java.util.*;

/**
 * Java集合类基础知识演示
 * 包含List、Set、Map等常用集合类的基本操作
 */
public class CollectionDemo {
    public static void main(String[] args) {
        // 1. ArrayList示例 - 有序、可重复的集合
        System.out.println("=== ArrayList示例 ===");
        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("苹果");
        list.add("香蕉");
        list.add("橙子");
        list.add("苹果");  // List允许重复元素

        // 遍历方式1：使用for-each循环
        System.out.println("使用for-each遍历List：");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 获取特定位置的元素
        System.out.println("\n获取索引1的元素：" + list.get(1));

        // 删除元素
        list.remove("香蕉");
        System.out.println("删除'香蕉'后的List：" + list);

        // 2. HashSet示例 - 无序、不重复的集合
        System.out.println("\n=== HashSet示例 ===");
        Set<String> set = new HashSet<>();

        // 添加元素
        set.add("足球");
        set.add("篮球");
        set.add("排球");
        set.add("足球");  // 重复元素不会被添加

        // 遍历Set
        System.out.println("Set中的元素：");
        for (String sport : set) {
            System.out.println(sport);
        }

        // 检查元素是否存在
        System.out.println("Set是否包含'足球'：" + set.contains("足球"));

        // 3. HashMap示例 - 键值对集合
        System.out.println("\n=== HashMap示例 ===");
        Map<String, Integer> map = new HashMap<>();

        // 添加键值对
        map.put("张三", 25);
        map.put("李四", 30);
        map.put("王五", 28);

        // 遍历Map的方式1：使用entrySet
        System.out.println("使用entrySet遍历Map：");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 遍历Map的方式2：分别遍历key和value
        System.out.println("\n所有的key：" + map.keySet());
        System.out.println("所有的value：" + map.values());

        // 获取特定key的value
        System.out.println("\n张三的年龄是：" + map.get("张三"));

        // 检查key是否存在
        System.out.println("是否包含'李四'这个key：" + map.containsKey("李四"));

        // 删除键值对
        map.remove("王五");
        System.out.println("删除'王五'后的Map：" + map);
    }
}
