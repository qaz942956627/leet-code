<p>找出数组中重复的数字。</p>

<p><br> 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。</br></p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
[2, 3, 1, 0, 2, 5, 3]
<strong>输出：</strong>2 或 3 
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>2 &lt;= n &lt;= 100000</code></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 排序</details><br>

<div>👍 1065, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 开始报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [442. 数组中重复的数据](/problems/find-all-duplicates-in-an-array) 几乎一样，可以先去看看我写的那道题的思路。

这道题唯一的区别就是不需要做索引偏移了，而且需要把 0 拿出来单独处理，直接看解法吧。

**标签：哈希表，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        for (int num : nums) {
            if (nums[abs(num)] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                return abs(num);
            } else {
                // 把索引 num 的元素置为负数
                nums[abs(num)] *= -1;
            }
        }
        // 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        for num in nums:
            if nums[abs(num)] < 0:
                # 之前已经把对应索引的元素变成负数了，
                # 这说明 num 重复出现了两次
                return abs(num)
            else:
                # 把索引 num 的元素置为负数
                nums[abs(num)] *= -1
        # 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int num : nums) {
            if (nums[Math.abs(num)] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                return Math.abs(num);
            } else {
                // 把索引 num 的元素置为负数
                nums[Math.abs(num)] *= -1;
            }
        }
        // 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findRepeatNumber(nums []int) int {
    for _, num := range nums {
        if nums[abs(num)] < 0 {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            return abs(num)
        } else {
            // 把索引 num 的元素置为负数
            nums[abs(num)] *= -1
        }
    }
    // 如果没有在 for 循环中返回，说明重复的那个元素是 0
    return 0
}

func abs(num int) int {
    if num < 0 {
        return -num
    }
    return num
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {number}
 */
var findRepeatNumber = function(nums) {
    for (let num of nums) {
        if (nums[Math.abs(num)] < 0) {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            return Math.abs(num);
        } else {
            // 把索引 num 的元素置为负数
            nums[Math.abs(num)] *= -1;
        }
    }
    // 如果没有在 for 循环中返回，说明重复的那个元素是 0
    return 0;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_shu-zu-zhong-zhong-fu-de-shu-zi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_shu-zu-zhong-zhong-fu-de-shu-zi-lcof"></div></div>
</details><hr /><br />

</details>
</div>





