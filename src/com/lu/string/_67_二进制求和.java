package com.lu.string;

public class _67_二进制求和 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int sum = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int b1 = j >= 0 ? b.charAt(j) - '0' : 0;
            sum = a1 + b1 + carry;
            sb.append(sum % 2);
            carry = sum / 2;

        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
