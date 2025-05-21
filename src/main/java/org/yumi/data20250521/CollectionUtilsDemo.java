package org.yumi.data20250521;

import java.util.*;

/**
 * Java集合工具类和算法演示
 * 展示Collections工具类的常用方法和集合的高级操作
 */
public class CollectionUtilsDemo {
    public static void main(String[] args) {
        // 1. Collections工具类常用方法
        System.out.println("=== Collections工具类常用方法 ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);
        numbers.add(30);

        System.out.println("原始列表: " + numbers);

        // 查找最大值和最小值
        System.out.println("最大值: " + Collections.max(numbers));
        System.out.println("最小值: " + Collections.min(numbers));

        // 二分查找（要求列表已排序）
        Collections.sort(numbers);
        System.out.println("排序后: " + numbers);
        int index = Collections.binarySearch(numbers, 15);
        System.out.println("15的索引位置: " + index);

        // 打乱列表顺序
        Collections.shuffle(numbers);
        System.out.println("打乱后: " + numbers);

        // 反转列表
        Collections.reverse(numbers);
        System.out.println("反转后: " + numbers);

        // 填充列表
        List<String> colors = new ArrayList<>(Arrays.asList("红", "黄", "蓝"));
        System.out.println("填充前: " + colors);
        Collections.fill(colors, "黑");
        System.out.println("填充后: " + colors);

        // 2. 集合的查找和替换操作
        System.out.println("\n=== 集合的查找和替换操作 ===");

        List<String> fruits = new ArrayList<>(Arrays.asList("苹果", "香蕉", "橙子", "苹果", "梨"));
        System.out.println("水果列表: " + fruits);

        // 查找元素首次出现的位置
        System.out.println("'苹果'首次出现的位置: " + fruits.indexOf("苹果"));

        // 查找元素最后出现的位置
        System.out.println("'苹果'最后出现的位置: " + fruits.lastIndexOf("苹果"));

        // 替换所有元素
        Collections.replaceAll(fruits, "苹果", "红苹果");
        System.out.println("替换后: " + fruits);

        // 3. 不可修改的集合
        System.out.println("\n=== 不可修改的集合 ===");

        List<String> modifiableList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println("可修改列表: " + modifiableList);

        // 创建不可修改的视图
        List<String> unmodifiableList = Collections.unmodifiableList(modifiableList);
        System.out.println("不可修改列表: " + unmodifiableList);

        // 尝试修改原列表
        modifiableList.add("D");
        System.out.println("修改原列表后，不可修改列表也会反映变化: " + unmodifiableList);

        // 尝试直接修改不可修改列表会抛出UnsupportedOperationException
        System.out.println("尝试修改不可修改列表会抛出异常（已注释掉）");
        // unmodifiableList.add("E"); // 这行会抛出异常

        // 4. 同步集合
        System.out.println("\n=== 同步集合 ===");

        // 创建非同步的集合
        List<Integer> nonSyncList = new ArrayList<>();
        nonSyncList.add(1);
        nonSyncList.add(2);

        // 创建同步集合
        List<Integer> syncList = Collections.synchronizedList(nonSyncList);
        System.out.println("同步列表: " + syncList);

        // 5. 集合的批量操作
        System.out.println("\n=== 集合的批量操作 ===");

        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));

        System.out.println("集合1: " + set1);
        System.out.println("集合2: " + set2);

        // 创建集合的副本用于演示
        Set<String> union = new HashSet<>(set1);
        Set<String> intersection = new HashSet<>(set1);
        Set<String> difference = new HashSet<>(set1);

        // 并集：addAll
        union.addAll(set2);
        System.out.println("并集 (set1 ∪ set2): " + union);

        // 交集：retainAll
        intersection.retainAll(set2);
        System.out.println("交集 (set1 ∩ set2): " + intersection);

        // 差集：removeAll
        difference.removeAll(set2);
        System.out.println("差集 (set1 - set2): " + difference);

        // 6. 频率统计
        System.out.println("\n=== 频率统计 ===");

        List<String> wordList = Arrays.asList("苹果", "香蕉", "苹果", "橙子", "香蕉", "苹果");
        System.out.println("单词列表: " + wordList);

        // 统计元素出现的频率
        System.out.println("'苹果'出现的频率: " + Collections.frequency(wordList, "苹果"));
        System.out.println("'香蕉'出现的频率: " + Collections.frequency(wordList, "香蕉"));
        System.out.println("'橙子'出现的频率: " + Collections.frequency(wordList, "橙子"));
    }
}
