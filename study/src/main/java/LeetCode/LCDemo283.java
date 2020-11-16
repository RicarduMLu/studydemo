package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 移动零
 *
 * @author lzj10
 * @create 2020-11-14-宪21:14
 */
public class LCDemo283 {
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    //必须在原数组上操作，不能拷贝额外的数组。
    //尽量减少操作次数。

    @Test
    public void demo283() {
        int[] a = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes1(a);
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
    }

    /**
     * 先暴力解码
     * 执行用时：     5 ms     , 在所有 Java 提交中击败了     11.78%     的用户
     * 内存消耗：     38.8 MB     , 在所有 Java 提交中击败了     75.37%     的用户
     *
     * @param nums
     */
    public void moveZeroes0(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int num = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = num;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 使用指针的思想，双指针单个循环去找
     执行用时：     0 ms     , 在所有 Java 提交中击败了     100.00%     的用户
     内存消耗：     38.7 MB     , 在所有 Java 提交中击败了     85.30%     的用户
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int i = 0;
        int j = 1;
        if (nums.length > 1) {
            while (i < nums.length) {
                if (nums[i] == 0) {
                    if (j == nums.length) {
                        break;
                    }
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        i++;
                    }
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
    }

}
