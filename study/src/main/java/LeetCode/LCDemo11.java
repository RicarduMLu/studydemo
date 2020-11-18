package LeetCode;

import org.junit.jupiter.api.Test;

/**
 * 最多水的容器
 *
 * @author lzj10
 * @create 2020-11-13-宪16:55
 */
public class LCDemo11 {
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
        int[] a = new int[]{2, 3, 4, 5, 18, 17, 6};
        int i = maxArea3(a);
        System.out.println(i);
    }

    /**
     * 暴力解法
     * 执行用时：     1169 ms     , 在所有 Java 提交中击败了     5.01%     的用户
     * 内存消耗：     40 MB     , 在所有 Java 提交中击败了     23.58%     的用户
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int out = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                if (height[i] >= height[j]) {
                    out = Math.max(out, (j - i) * height[j]);
                } else {
                    out = Math.max(out, (j - i) * height[i]);
                }
            }
        }
        return out;
    }

    /**
     * 暴力解法简化版
     *
     * @param height
     * @return
     */

    public int maxArea0(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }


    /**
     * 因为是长度乘以距离，所以只要找里面比外面大的就可以
     * 执行用时：     * 295 ms     * , 在所有 Java 提交中击败了     * 25.41%     * 的用户
     * 内存消耗：     * 39.8 MB     * , 在所有 Java 提交中击败了     * 30.90%     * 的用户
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int out = 0;
        int ih = 0;
        for (int i = 0; i < height.length; i++) {
            if (ih >= height[i]) {
                continue;
            }
            ih = height[i];
            int jh = 0;//需要每次重置
            for (int j = height.length - 1; j > i; j--) {
                if (jh >= height[j]) {
                    continue;
                }
                jh = height[j];
                if (height[i] >= height[j]) {
                    out = Math.max(out, (j - i) * height[j]);
                } else {
                    out = Math.max(out, (j - i) * height[i]);
                }
            }
        }
        return out;
    }

    /**
     * 双指针思想
     * 左右指针（双指针夹逼）
     * 夹逼思想的情况下 ，可以省略内部里面的 for 降低复杂度  用while 或for 都可以   使用Min
     * 因为都是长城宽为了做更少的判断，移动时只移动最短的，不像上面每次都移动一遍来算
     * 执行用时：    4 ms     , 在所有 Java 提交中击败了     68.16%     的用户
     * 内存消耗：     39.9 MB     , 在所有 Java 提交中击败了     27.33%     的用户
     *
     * @param height
     * @return
     */
    public int maxArea3(int[] height) {
        int out = 0;
        int i = 0;
        int j = height.length - 1;
        if (height.length > 1) {
            while (j >= i) {
                out = Math.max(out, Math.min(height[i], height[j]) * (j - i));
                //当ih大于时向前进
                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {
            return 0;
        }
        return out;
    }

    /**
     * 进一步的优化代码
     * 执行用时：     3 ms     , 在所有 Java 提交中击败了     93.00%     的用户
     * 内存消耗：     40.1 MB     , 在所有 Java 提交中击败了     18.91%     的用户
     *
     * @param a
     * @return
     */
    public int maxArea4(int[] a) {
        int max = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
}
