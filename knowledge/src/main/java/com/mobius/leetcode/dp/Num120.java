package com.mobius.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    public static int minimumTotalBack(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        int[][] back = new int[n][n];
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            back[i][0] = 0;
            for (int j = 1; j < i; ++j) {
                //f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
                if (f[i-1][j-1] <= f[i-1][j]) {
                    f[i][j] = f[i-1][j-1] + triangle.get(i).get(j);
                    back[i][j] = -1;
                } else{
                    f[i][j] = f[i - 1][j] + triangle.get(i).get(j);
                    back[i][j] = 0;
                }
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
            back[i][i] = -1;
        }

        // 根据back数组得到最小和路径
        List<Integer> res = new ArrayList<>();
        int minTotal = f[n - 1][0];
        int index = 0;
        for (int i = 1; i < n; ++i) {
            if (minTotal > f[n-1][i] ) {
                minTotal = f[n-1][i];
                index = i;
            }
        }
        System.out.println(index);
        int i = n-1;
        while (i >= 0 && index >= 0) {
            res.add(triangle.get(i).get(index));
            index = index + back[i][index];
            i--;
        }
        System.out.println(res.toString());
        return minTotal;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotalBack(triangle));
    }
}
