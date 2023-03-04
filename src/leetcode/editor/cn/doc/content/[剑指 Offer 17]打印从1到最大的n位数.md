<p>输入数字 <code>n</code>，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> n = 1
<strong>输出:</strong> [1,2,3,4,5,6,7,8,9]
</pre>

<p>&nbsp;</p>

<p>说明：</p>

<ul> 
 <li>用返回一个整数列表来代替打印</li> 
 <li>n 为正整数</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 数学</details><br>

<div>👍 275, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 17 期刷题打卡挑战](https://aep.xet.tech/s/2jPp5X) 下周开始，报名从速！。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题很简单，估计就是想考察整数的生成吧，你只要知道这个字符串转数字的技巧就行了：

```cpp
string s = "8264";
int number = 0;
for (int i = 0; i < s.size(); i++) {
    // 将字符转化成数字
    number = 10 * number + (s[i] - '0');
}
```

**标签：字符串**

## 解法代码

```java
class Solution {
    public int[] printNumbers(int n) {
        // 先生成 n 位 9
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = 10 * max + 9;
        }
        // 填入结果数组
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
```

</details>
</div>



