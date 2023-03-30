<p>给定一个非负整数 <code>n</code><b>&nbsp;</b>，请计算 <code>0</code> 到 <code>n</code> 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>n =<strong> </strong>2
<strong>输出: </strong>[0,1,1]
<strong>解释: 
</strong>0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入: </strong>n =<strong> </strong>5
<strong>输出: </strong><span><code>[0,1,1,2,1,2]
</code></span><span style="white-space: pre-wrap;"><strong>解释:</strong>
</span>0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
3 --&gt; 11
4 --&gt; 100
5 --&gt; 101
</pre>

<p>&nbsp;</p>

<p><strong>说明 :</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 10<sup>5</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶:</strong></p>

<ul> 
 <li>给出时间复杂度为&nbsp;<code>O(n*sizeof(integer))</code><strong>&nbsp;</strong>的解答非常容易。但你可以在线性时间&nbsp;<code>O(n)</code><strong>&nbsp;</strong>内用一趟扫描做到吗？</li> 
 <li>要求算法的空间复杂度为&nbsp;<code>O(n)</code>&nbsp;。</li> 
 <li>你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的&nbsp;<code>__builtin_popcount</code><strong>&nbsp;</strong>）来执行此操作。</li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 338&nbsp;题相同：<a href="https://leetcode-cn.com/problems/counting-bits/">https://leetcode-cn.com/problems/counting-bits/</a></p>

<details><summary><strong>Related Topics</strong></summary>位运算 | 动态规划</details><br>

<div>👍 122, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

</div>





