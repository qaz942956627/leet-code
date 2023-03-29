<p>如果序列&nbsp;<code>X_1, X_2, ..., X_n</code>&nbsp;满足下列条件，就说它是&nbsp;<em>斐波那契式&nbsp;</em>的：</p>

<ul> 
 <li><code>n &gt;= 3</code></li> 
 <li>对于所有&nbsp;<code>i + 2 &lt;= n</code>，都有&nbsp;<code>X_i + X_{i+1} = X_{i+2}</code></li> 
</ul>

<p>给定一个<strong>严格递增</strong>的正整数数组形成序列 <code>arr</code>&nbsp;，找到 <code>arr</code> 中最长的斐波那契式的子序列的长度。如果一个不存在，返回&nbsp;&nbsp;0 。</p>

<p><em>（回想一下，子序列是从原序列&nbsp; <code>arr</code> 中派生出来的，它从 <code>arr</code> 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如，&nbsp;<code>[3, 5, 8]</code>&nbsp;是&nbsp;<code>[3, 4, 5, 6, 7, 8]</code>&nbsp;的一个子序列）</em></p>

<p>&nbsp;</p>

<ul> 
</ul>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>arr =<strong> </strong>[1,2,3,4,5,6,7,8]
<strong>输出: </strong>5
<strong>解释: </strong>最长的斐波那契式子序列为 [1,2,3,5,8] 。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入: </strong>arr =<strong> </strong>[1,3,7,11,12,14,18]
<strong>输出: </strong>3
<strong>解释</strong>: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>3 &lt;= arr.length &lt;= 1000</code></li> 
 <li> <p><code>1 &lt;= arr[i] &lt; arr[i + 1] &lt;= 10^9</code></p> </li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 873&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/">https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/</a></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 动态规划</details><br>

<div>👍 67, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

</div>



