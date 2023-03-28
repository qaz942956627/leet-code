<p>假如有一排房子，共 <code>n</code> 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。</p>

<p>当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个&nbsp;<code>n x 3</code><em>&nbsp;</em>的正整数矩阵 <code>costs</code> 来表示的。</p>

<p>例如，<code>costs[0][0]</code> 表示第 0 号房子粉刷成红色的成本花费；<code>costs[1][2]</code>&nbsp;表示第 1 号房子粉刷成绿色的花费，以此类推。</p>

<p>请计算出粉刷完所有房子最少的花费成本。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>costs = [[17,2,17],[16,16,5],[14,3,19]]
<strong>输出: </strong>10
<strong>解释: </strong>将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色<strong>。</strong>
&nbsp;    最少花费: 2 + 5 + 3 = 10。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>costs = [[7,6,2]]
<strong>输出: 2</strong>
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>costs.length == n</code></li> 
 <li><code>costs[i].length == 3</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= costs[i][j] &lt;= 20</code></li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 256&nbsp;题相同：<a href="https://leetcode-cn.com/problems/paint-house/">https://leetcode-cn.com/problems/paint-house/</a></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 146, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [256. 粉刷房子](/problems/paint-house) 相同。

关于动态规划的解题步骤和思维方法见前文 [动态规划核心套路](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶) 和 [动态规划答疑篇](https://labuladong.github.io/article/fname.html?fname=最优子结构)，这里就不赘述了，直接给出最关键的状态转移方程。

这道题有些类似 [最长递增子序列](https://labuladong.github.io/article/fname.html?fname=动态规划设计：最长递增子序列) 和 [最大子数组和](https://labuladong.github.io/article/fname.html?fname=最大子数组)，因为它们定义 `dp` 数组的方式都是「以 xx 结尾的最值是 `dp[i]`」。

这道题对 `dp` 数组的定义是：

**当第 `i` 个房子粉刷颜色 `j` 时，粉刷 `[0..i]` 这些房子所需的最少花费为 `dp[i][j]`**。

有了这个定义，题目想求的答案就是 `sum(dp[n-1][..])`。

又因为题目说相同的颜色不能相邻，所以状态转移方程为：

```java
// 颜色 0 只能挨着颜色 1 或颜色 2
dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
// 颜色 1 只能挨着颜色 0 或颜色 2
dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
// 颜色 2 只能挨着颜色 0 或颜色 1
dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
```

然后就可以写出解法了。

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        // 定义：当第 i 个房子粉刷颜色 j 时，粉刷 [0..i] 这些房子所需的最少花费为 dp[i][j]
        // 其中 j = 0, 1, 2 分别代表三种颜色
        vector<vector<int>> dp(n, vector<int>(3));

        // base case
        for (int j = 0; j < 3; j++) {
            // 粉刷第一个房子的花费是确定的
            dp[0][j] = costs[0][j];
        }

        // 状态转移，穷举所有「选择」
        for (int i = 1; i < n; i++) {
            // 颜色 0 只能挨着颜色 1 或颜色 2
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            // 颜色 1 只能挨着颜色 0 或颜色 2
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            // 颜色 2 只能挨着颜色 0 或颜色 1
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        // 计算题目要求的结果，
        int res = INT_MAX;
        for (int j = 0; j < 3; j++) {
            res = min(res, dp[n - 1][j]);
        }

        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        # 定义：当第 i 个房子粉刷颜色 j 时，粉刷 [0..i] 这些房子所需的最少花费为 dp[i][j]
        # 其中 j = 0, 1, 2 分别代表三种颜色
        dp = [[0]*3 for _ in range(n)]

        # base case
        for j in range(3):
            # 粉刷第一个房子的花费是确定的
            dp[0][j] = costs[0][j]

        # 状态转移，穷举所有「选择」
        for i in range(1, n):
            # 颜色 0 只能挨着颜色 1 或颜色 2
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
            # 颜色 1 只能挨着颜色 0 或颜色 2
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]
            # 颜色 2 只能挨着颜色 0 或颜色 1
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]

        # 计算题目要求的结果，
        res = float("inf")
        for j in range(3):
            res = min(res, dp[n - 1][j])

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        // 定义：当第 i 个房子粉刷颜色 j 时，粉刷 [0..i] 这些房子所需的最少花费为 dp[i][j]
        // 其中 j = 0, 1, 2 分别代表三种颜色
        int[][] dp = new int[n][3];

        // base case
        for (int j = 0; j < 3; j++) {
            // 粉刷第一个房子的花费是确定的
            dp[0][j] = costs[0][j];
        }

        // 状态转移，穷举所有「选择」
        for (int i = 1; i < n; i++) {
            // 颜色 0 只能挨着颜色 1 或颜色 2
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            // 颜色 1 只能挨着颜色 0 或颜色 2
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            // 颜色 2 只能挨着颜色 0 或颜色 1
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        // 计算题目要求的结果，
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }

        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minCost(costs [][]int) int {
    n := len(costs)

    // 定义：当第 i 个房子粉刷颜色 j 时，粉刷 [0..i] 这些房子所需的最少花费为 dp[i][j]
    // 其中 j = 0, 1, 2 分别代表三种颜色
    dp := make([][]int, n)
    for i := range dp {
        dp[i] = make([]int, 3)
    }

    // base case
    for j := 0; j < 3; j++ {
        // 粉刷第一个房子的花费是确定的
        dp[0][j] = costs[0][j]
    }

    // 状态转移，穷举所有「选择」
    for i := 1; i < n; i++ {
        // 颜色 0 只能挨着颜色 1 或颜色 2
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]
        // 颜色 1 只能挨着颜色 0 或颜色 2
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1]
        // 颜色 2 只能挨着颜色 0 或颜色 1
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2]
    }

    // 计算题目要求的结果，
    res := math.MaxInt32
    for j := 0; j < 3; j++ {
        res = min(res, dp[n-1][j])
    }

    return res
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minCost = function(costs) {
    const n = costs.length;
    // 定义：当第 i 个房子粉刷颜色 j 时，粉刷 [0..i] 这些房子所需的最少花费为 dp[i][j]
    // 其中 j = 0, 1, 2 分别代表三种颜色
    const dp = new Array(n).fill().map(() => new Array(3).fill(0));

    // base case
    for (let j = 0; j < 3; j++) {
        // 粉刷第一个房子的花费是确定的
        dp[0][j] = costs[0][j];
    }

    // 状态转移，穷举所有「选择」
    for (let i = 1; i < n; i++) {
        // 颜色 0 只能挨着颜色 1 或颜色 2
        dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
        // 颜色 1 只能挨着颜色 0 或颜色 2
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
        // 颜色 2 只能挨着颜色 0 或颜色 1
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
    }

    // 计算题目要求的结果，
    let res = Number.MAX_VALUE;
    for (let j = 0; j < 3; j++) {
        res = Math.min(res, dp[n - 1][j]);
    }

    return res;
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 091. 粉刷房子 🟠](/problems/JEj789)

</details>
</div>



