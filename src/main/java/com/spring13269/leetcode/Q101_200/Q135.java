package com.spring13269.leetcode.Q101_200;

/**
 * Q135
 *
 * @author : zengle.huang@hand-china.com 2020/12/24
 */
public class Q135 {
    /**
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     * 每个孩子至少分配到 1 个糖果。
     * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
     * 那么这样下来，老师至少需要准备多少颗糖果呢？
     *
     * 示例 1:
     * 输入: [1,0,2]
     * 输出: 5
     * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
     * 示例 2:
     * 输入: [1,2,2]
     * 输出: 4
     * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
     */
    public int candy(int[] ratings) {
        int result = 0;
        if (ratings.length < 1) {
            return result;
        }
        // 第一个
        result++;
        int[] rateCandy = new int[ratings.length];
        rateCandy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            int cur = 1;
            if (ratings[i] > ratings[i-1]) {
                cur = rateCandy[i-1] + 1;
            }
            result+=cur;
            rateCandy[i] = cur;
            for (int j = i; j >= 1 ; j--) {
                if (ratings[j] < ratings[j-1] && rateCandy[j-1] <= rateCandy[j]) {
                    result ++;
                    rateCandy[j-1]++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q135 q = new Q135();
        q.candy(new int[]{5,5,4,3,2,1,1,2,3,4,5});
    }
}