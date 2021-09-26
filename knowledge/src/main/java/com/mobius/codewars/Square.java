package com.mobius.codewars;

public class Square {
    public static boolean isSquare(int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 1; i <= n/2; i ++) {
            if ((i * i) == n ) {
                return true;
            }
        }
        return false; // fix me!
    }


    public static boolean isSquare1(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public static boolean isSquare2(int n) {
        long s = Math.round(Math.sqrt(n));
        return s * s == n;
    }
}
