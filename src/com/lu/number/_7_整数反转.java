package com.lu.number;

public class _7_整数反转 {
    public int reverse(int x) {
        int left = 0;

        while (x != 0) {
            int right = x % 10;
            x /= 10;
            if (left > Integer.MAX_VALUE / 10 || (left == Integer.MAX_VALUE / 10 && right > 7)) {
                return 0;
            }
            if (left < Integer.MIN_VALUE / 10 || (left == Integer.MIN_VALUE / 10 && right < -8)) {
                return 0;
            }
            left = left * 10 + right;
        }
        return left;
    }
}
