package org.yumi.data20250311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println("所有唯一组合：");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 关键剪枝准备：排序
        backtrack(
            candidates,
            target,
            0,
            new ArrayList<>(),
            result
        );
        return result;
    }

    private static void backtrack(
        int[] candidates,
        int remain,
        int start,
        List<Integer> path,
        List<List<Integer>> result
    ) {
        // 终止条件：找到有效组合
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝1：跳过重复元素（需配合排序）
            if (i > start && candidates[i] == candidates[i-1]) continue;
            
            // 剪枝2：提前终止无效分支
            if (candidates[i] > remain) break;

            // 选择当前元素
            path.add(candidates[i]);
            
            // 递归探索（注意i+1避免重复使用同一元素）
            backtrack(candidates, remain - candidates[i], i + 1, path, result);
            
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}