package LeetCode;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * leetcode刷题
 *
 * @author lzj10
 * @create 2020-11-13-宪16:55
 */
public class LeetCodeDemo11 {
    @Test
    public void pro11() {
        //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
        // 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
        // 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        //输入：[1,8,6,2,5,4,8,3,7]
        //输出：49
        //解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
        //

        //暴力解法，把能够顺序达到的所有值拿到，扔出最大的
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(a);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int out = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                if( height[i] >=  height[j]){
                    out = Math.max(out, height[j] * height[j]);
                }
            }
        }
        return out;
    }
}
