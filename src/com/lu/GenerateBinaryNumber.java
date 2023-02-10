package com.lu;

/**
 * 请你实现一个函数，接受一个正整数 n，函数能够打印所有长度为 n 的二进制数。例如输入n = 3，算法打印000 001 010 011 100 101 110 111，共2^3 = 8个结果
 * @author 小卢
 * @version 1.0
 * @date 2023/2/10 22:42
 **/
public class GenerateBinaryNumber {

    StringBuilder number = new StringBuilder();

    void generateBinaryNumber(int n) {

        if (n==0) {
            System.out.println(number);
            return;
        }


//        for (int i = 0; i < n; i++) {
//        }
        for (int j = 0; j < 2; j++) {
            // 前序遍历 选择一个元素
            number.append(j);
            generateBinaryNumber(n - 1);
            // 后续遍历 删除选中的元素
            number.deleteCharAt(number.length() - 1);
        }


    }



    public static void main(String[] args) {
        new GenerateBinaryNumber().generateBinaryNumber(3);
    }
}
