<p>一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong>。</p>

<p>给定一个代表每个房屋存放金额的非负整数数组 <code>nums</code>&nbsp;，请计算<strong>&nbsp;不触动警报装置的情况下 </strong>，一夜之内能够偷窃到的最高金额。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums =<strong> </strong>[1,2,3,1]
<strong>输出：</strong>4
<strong>解释：</strong>偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
&nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums =<strong> </strong>[2,7,9,3,1]
<strong>输出：</strong>12
<strong>解释：</strong>偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
&nbsp;    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 100</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 400</code></li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 198&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/house-robber/">https://leetcode-cn.com/problems/house-robber/</a></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 34, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=Gu0c2T" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [198. 打家劫舍](/problems/house-robber) 相同。

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 201 页。

假想你就是这个强盗，从左到右走过这一排房子，在每间房子前都有两种**选择**：抢或者不抢。

当你走过了最后一间房子后，你就没得抢了，能抢到的钱显然是 0（**base case**）。

以上已经明确了「状态」和「选择」：**你面前房子的索引就是状态，抢和不抢就是选择**。

![](https://labuladong.github.io/pictures/robber/1.jpg)

状态转移方程：

```java
int res = Math.max(
    // 不抢，去下家
    dp(nums, start + 1),
    // 抢，去下下家
    nums[start] + dp(nums, start + 2)
);
```

打家劫舍系列问题还可以进一步优化，见文章详解，这里只给出最通用的框架性解法。

**详细题解：[一个方法团灭 LeetCode 打家劫舍问题](https://labuladong.github.io/article/fname.html?fname=抢房子)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
private:
    // 备忘录
    vector<int> memo;
    // dp 函数
    int dp(vector<int>& nums, int start) {
        if (start >= nums.size()) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = max(dp(nums, start + 1),
                      nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }

public:
    // 主函数
    int rob(vector<int>& nums) {
        // 初始化备忘录
        memo.resize(nums.size(), -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        # 备忘录
        self.memo = None
    
    # 主函数
    def rob(self, nums: List[int]) -> int:
        # 初始化备忘录
        self.memo = [-1] * len(nums)
        # 强盗从第 0 间房子开始抢劫
        return self.dp(nums, 0)
    
    # 返回 dp[start..] 能抢到的最大值
    def dp(self, nums: List[int], start: int) -> int:
        if start >= len(nums):
            return 0
        # 避免重复计算
        if self.memo[start] != -1:
            return self.memo[start]
        res = max(self.dp(nums, start + 1),
                  nums[start] + self.dp(nums, start + 2))
        # 记入备忘录
        self.memo[start] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 备忘录
    private int[] memo;
    // 主函数
    public int rob(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1) return memo[start];

        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import (
    "fmt"
)

func rob(nums []int) int {
    // 初始化备忘录
    memo := make([]int, len(nums))
    for i := 0; i < len(memo); i++ {
        memo[i] = -1
    }
    // 强盗从第 0 间房子开始抢劫
    return dp(nums, 0, memo)
}

// 返回 dp[start..] 能抢到的最大值
func dp(nums []int, start int, memo []int) int {
    if start >= len(nums) {
        return 0
    }
    // 避免重复计算
    if memo[start] != -1 {
        return memo[start]
    }

    res := max(dp(nums, start+1, memo), nums[start]+dp(nums, start+2, memo))
    // 记入备忘录
    memo[start] = res
    return res
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var rob = function(nums) {
    // 备忘录
    const memo = new Array(nums.length).fill(-1);
    
    // 返回 dp[start..] 能抢到的最大值
    const dp = (start) => {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1) return memo[start];

        const res = Math.max(dp(start + 1), nums[start] + dp(start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }

    // 强盗从第 0 间房子开始抢劫
    return dp(0);
};
```

</div></div>
</div></div>

**类似题目**：
  - [213. 打家劫舍 II 🟠](/problems/house-robber-ii)
  - [337. 打家劫舍 III 🟠](/problems/house-robber-iii)
  - [剑指 Offer II 089. 房屋偷盗 🟠](/problems/Gu0c2T)
  - [剑指 Offer II 090. 环形房屋偷盗 🟠](/problems/PzWKhm)

</details>
</div>



