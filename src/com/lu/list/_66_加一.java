package com.lu.list;

public class _66_加一 {

    public int[] plusOne(int[] digits) {
        int end = digits.length - 1;
        int digit = digits[end];
        digit = digit + 1;
        while (digit > 9 && end > 0) {

            digit = digit % 10;
            digits[end] = digit;
            digit = digits[--end] + 1;
        }
        if (digit == 10) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            newDigits[1] = 0;
            for (int i = 2; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        digits[end] = digit;
        return digits;
    }

    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
