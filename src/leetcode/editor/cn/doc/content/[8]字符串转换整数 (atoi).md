<p>请你来实现一个&nbsp;<code>myAtoi(string s)</code>&nbsp;函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 <code>atoi</code> 函数）。</p>

<p>函数&nbsp;<code>myAtoi(string s)</code> 的算法如下：</p>

<ol> 
 <li>读入字符串并丢弃无用的前导空格</li> 
 <li>检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。</li> 
 <li>读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。</li> 
 <li>将前面步骤读入的这些数字转换为整数（即，"123" -&gt; 123， "0032" -&gt; 32）。如果没有读入数字，则整数为 <code>0</code> 。必要时更改符号（从步骤 2 开始）。</li> 
 <li>如果整数数超过 32 位有符号整数范围 <code>[−2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>− 1]</code> ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 <code>−2<sup>31</sup></code> 的整数应该被固定为 <code>−2<sup>31</sup></code> ，大于 <code>2<sup>31&nbsp;</sup>− 1</code> 的整数应该被固定为 <code>2<sup>31&nbsp;</sup>− 1</code> 。</li> 
 <li>返回整数作为最终结果。</li> 
</ol>

<p><strong>注意：</strong></p>

<ul> 
 <li>本题中的空白字符只包括空格字符 <code>' '</code> 。</li> 
 <li>除前导空格或数字后的其余字符串外，<strong>请勿忽略</strong> 任何其他字符。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>s = "42"
<strong>输出：</strong>42
<strong>解释：</strong>加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
第 1 步："42"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："<u>42</u>"（读入 "42"）
           ^
解析得到整数 42 。
由于 "42" 在范围 [-2<sup>31</sup>, 2<sup>31</sup> - 1] 内，最终结果为 42 。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>s = "   -42"
<strong>输出：</strong>-42
<strong>解释：</strong>
第 1 步："<u><strong>   </strong></u>-42"（读入前导空格，但忽视掉）
            ^
第 2 步："   <u><strong>-</strong></u>42"（读入 '-' 字符，所以结果应该是负数）
             ^
第 3 步："   <u><strong>-42</strong></u>"（读入 "42"）
               ^
解析得到整数 -42 。
由于 "-42" 在范围 [-2<sup>31</sup>, 2<sup>31</sup> - 1] 内，最终结果为 -42 。
</pre>

<p><strong>示例&nbsp;3：</strong></p>

<pre>
<strong>输入：</strong>s = "4193 with words"
<strong>输出：</strong>4193
<strong>解释：</strong>
第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："<u>4193</u> with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
             ^
解析得到整数 4193 。
由于 "4193" 在范围 [-2<sup>31</sup>, 2<sup>31</sup> - 1] 内，最终结果为 4193 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 200</code></li> 
 <li><code>s</code> 由英文字母（大写和小写）、数字（<code>0-9</code>）、<code>' '</code>、<code>'+'</code>、<code>'-'</code> 和 <code>'.'</code> 组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串</details><br>

<div>👍 1719, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题说实话没有什么难度，无非就是处理数字、符号、空格和 int 溢出的细节问题，具体看代码吧，把每一步的注释写清楚就不容易在细节上出错了。

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```java
class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        // 记录正负号
        int sign = 1;
        // 用 long 避免 int 溢出
        long res = 0;
        // 跳过前导空格
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }

        // 记录符号位
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        if (i == n) {
            return 0;
        }

        // 统计数字位
        while (i < n && '0' <= str.charAt(i) && str.charAt(i) <= '9') {
            res = res * 10 + str.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }
        // 如果溢出，强转成 int 就会和真实值不同
        if ((int) res != res) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
```

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_string-to-integer-atoi" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_string-to-integer-atoi"></div></div>
</details><hr /><br />

**类似题目**：
  - [面试题67. 把字符串转换成整数 🟠](/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof)

</details>
</div>



