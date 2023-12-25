<p>从<strong>若干副扑克牌</strong>中随机抽 <code>5</code> 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> [1,2,3,4,5]
<strong>输出:</strong> True</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> [0,0,1,2,5]
<strong>输出:</strong> True</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p>数组长度为 5&nbsp;</p>

<p>数组的数取值为 [0, 13] .</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 排序</details><br>

<div>👍 346, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题看起来不难，我想到的最直接的方式是排序，因为排序之后很容易判定顺子（元素递增 1）。

不过我按照这个思路写了下解法，发现大小王的万能匹配稍微有些难处理。所以仔细想了下，这题可以通过计算 5 个元素中的最大值和最小值来判断是否递增。

只要最大值和最小值的差等于 4，就说明是 5 个递增的元素。当然，由于大小王用 0 表示，所以 0 不应该参与最大最小值的选取。另外，顺子中不应该出现重复元素。

如果结合以上思路，就会发现其实不需要排序了，直接遍历一遍 `nums` 数组找最大最小值，然后再用一个 `HashSet` 判断重复元素就行了。具体看代码吧。

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    bool isStraight(vector<int>& nums) {
        unordered_set<int> numSet;
        int maxVal = INT_MIN, minVal = INT_MAX;
        for (int num : nums) {
            if (num == 0) {
                // 小王不用管
                continue;
            }
            if (numSet.count(num)) {
                // 出现重复，不可能是顺子
                return false;
            }
            numSet.insert(num);

            maxVal = max(maxVal, num);
            minVal = min(minVal, num);
        }
        // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
        return maxVal - minVal <= 4;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isStraight(self, nums: List[int]) -> bool:
        numSet = set()
        maximum, minimum = float('-inf'), float('inf')
        for num in nums:
            if num == 0:
                # 小王不用管
                continue
            if num in numSet:
                # 出现重复，不可能是顺子
                return False
            numSet.add(num)
            maximum = max(maximum, num)
            minimum = min(minimum, num)
        # 考虑到大小王，只要差小于 4 就一定可以凑出顺子
        return maximum - minimum <= 4
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                // 小王不用管
                continue;
            }
            if (numSet.contains(num)) {
                // 出现重复，不可能是顺子
                return false;
            }
            numSet.add(num);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
        return max - min <= 4;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func isStraight(nums []int) bool {
    numSet := make(map[int]bool)
    max, min := math.MinInt32, math.MaxInt32
    for _, num := range nums {
        if num == 0 {
            // 小王不用管
            continue
        }
        if numSet[num] {
            // 出现重复，不可能是顺子
            return false
        }
        numSet[num] = true

        max = int(math.Max(float64(max), float64(num)))
        min = int(math.Min(float64(min), float64(num)))
    }
    // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
    return max - min <= 4
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var isStraight = function(nums) {
    let numSet = new Set();
    let max = -Infinity, min = Infinity;
    for (let num of nums) {
        if (num === 0) {
            // 小王不用管
            continue;
        }
        if (numSet.has(num)) {
            // 出现重复，不可能是顺子
            return false;
        }
        numSet.add(num);

        max = Math.max(max, num);
        min = Math.min(min, num);
    }
    // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
    return max - min <= 4;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_bu-ke-pai-zhong-de-shun-zi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_bu-ke-pai-zhong-de-shun-zi-lcof"></div></div>
</details><hr /><br />

</details>
</div>

