package Dynamicprogramming.largestdivisiblesubset;

import java.util.*;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-05-05
 * Time:23:31
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj)
 * 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 */
public class largestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length, m = 0, mi = 0;
        int[] array = new int[len];
        int[] num = new int[len];
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && array[j] + 1 > array[i]) {
                    array[i] = array[j] + 1;
                    num[i] = j;
                }
            }
            if (array[i] > m) {
                m = array[i];
                mi = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            res.add(nums[mi]);
            mi = num[mi];
        }

        return res;

    }
}
