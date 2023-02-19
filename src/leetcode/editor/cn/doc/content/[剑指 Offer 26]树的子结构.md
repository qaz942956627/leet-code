<p>输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)</p>

<p>B是A的子结构， 即 A中有出现和B相同的结构和节点值。</p>

<p>例如:<br> 给定的树 A:</br></p>

<p><code>&nbsp; &nbsp; &nbsp;3<br> &nbsp; &nbsp; / \<br> &nbsp; &nbsp;4 &nbsp; 5<br> &nbsp; / \<br> &nbsp;1 &nbsp; 2</br></br></br></br></code><br> 给定的树 B：</br></p>

<p><code>&nbsp; &nbsp;4&nbsp;<br> &nbsp; /<br> &nbsp;1</br></br></code><br> 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。</br></p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>A = [1,2,3], B = [3,1]
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>A = [3,4,5,1,2], B = [4,1]
<strong>输出：</strong>true</pre>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 节点个数 &lt;= 10000</code></p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 695, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，第 17 期刷题打卡 [开始报名](https://aep.xet.tech/s/2jPp5X)。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

前文 [手把手刷二叉树总结篇](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63a84ecde4b030cacaff6731/1) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要同时用到两种思维模式。

想要彻底搞懂这道题，需要你看一下 [东哥手把手带你刷二叉树（纲领篇）](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63a84ecde4b030cacaff6731/1) 和 [东哥手把手带你刷二叉树（思维篇）](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63a84de7e4b030cacaff66fa/1)。

解法中 `isSubStructure` 函数是遍历函数，遍历树 `A` 的所有节点，对 `A` 的所有节点做什么事呢？就是以 `A` 上的每个节点作为根节点，试图匹配树 `B`，也就是 `compareTree` 函数。

**标签：后序遍历**

## 解法代码

```java
class Solution {
    String target;
    boolean found = false;

    // 这个函数用「遍历」的思维模式理解，遍历二叉树 A 的所有节点
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 对于树 A 中的一个节点：
        // 1. 如果 A.val == B.val，则 A 可以作为根节点尝试去匹配树 B
        if (A.val == B.val && compareTree(A, B)) {
            return true;
        }
        // 2. 如果 A.val != B.val，就不要去匹配树 B 了
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 这个函数用「分解问题」的思路理解
    // 定义：输入两个根节点，返回从 rootA 开始是否可以完全匹配 rootB 树上的所有节点
    boolean compareTree(TreeNode rootA, TreeNode rootB) {
        // base case
        if (rootB == null) {
            return true;
        }
        if (rootB != null && rootA == null) {
            return false;
        }
        if (rootA.val != rootB.val) {
            return false;
        }

        // rootA 的值和 rootB 的值匹配完成，去匹配子树的节点
        return compareTree(rootA.left, rootB.left) && compareTree(rootA.right, rootB.right);
    }
}
```

</details>
</div>





