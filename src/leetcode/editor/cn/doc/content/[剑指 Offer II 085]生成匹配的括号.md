<p>正整数&nbsp;<code>n</code>&nbsp;代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>["()"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 8</code></li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 22&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/generate-parentheses/">https://leetcode-cn.com/problems/generate-parentheses/</a></p>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划 | 回溯</details><br>

<div>👍 65, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 最后一天报名。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=IDBivT" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [22. 括号生成](/problems/generate-parentheses) 相同。

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 306 页。

本题可以改写为：

现在有 `2n` 个位置，每个位置可以放置字符 `(` 或者 `)`，组成的所有括号组合中，有多少个是合法的？

这就是典型的回溯算法提醒，暴力穷举就行了。

不过为了减少不必要的穷举，我们要知道合法括号串有以下性质：

**1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解**。

**2、对于一个「合法」的括号字符串组合 `p`，必然对于任何 ` 0 <= i < len(p)` 都有：子串 `p[0..i]` 中左括号的数量都大于或等于右括号的数量**。

因为从左往右算的话，肯定是左括号多嘛，到最后左右括号数量相等，说明这个括号组合是合法的。

用 `left` 记录还可以使用多少个左括号，用 `right` 记录还可以使用多少个右括号，就可以直接套用 [回溯算法套路框架](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 了。

**详细题解：[回溯算法最佳实践：括号生成](https://labuladong.github.io/article/fname.html?fname=合法括号生成)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

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
    vector<string> generateParenthesis(int n) {
        if (n == 0) return {};
        // 记录所有合法的括号组合
        vector<string> res;
        // 回溯过程中的路径
        string track;
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    void backtrack(int left, int right,
                string& track, vector<string>& res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.push_back(track);
            return;
        }

        // 尝试放一个左括号
        track.push_back('('); // 选择
        backtrack(left - 1, right, track, res);
        track.pop_back(); // 撤消选择

        // 尝试放一个右括号
        track.push_back(')'); // 选择
        backtrack(left, right - 1, track, res);
        track.pop_back(); // 撤消选择
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        # 记录所有合法的括号组合
        res = []
        # 回溯过程中的路径
        track = ""
        # 可用的左括号和右括号数量初始化为 n
        self.backtrack(n, n, track, res)
        return res

    # 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    def backtrack(self, left: int, right: int, track: str, res: List[str]) -> None:
        # 若右括号剩下的多，说明不合法
        if right < left:
            return
        # 数量小于 0 肯定是不合法的
        if left < 0 or right < 0:
            return
        # 当所有括号都恰好用完时，得到一个合法的括号组合
        if left == 0 and right == 0:
            res.append(track)
            return

        # 尝试放一个左括号
        track += '(' # 选择
        self.backtrack(left - 1, right, track, res)
        track = track[:-1] # 撤消选择

        # 尝试放一个右括号
        track += ')' # 选择
        self.backtrack(left, right - 1, track, res)
        track = track[:-1] # 撤消选择
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public:
    vector<string> generateParenthesis(int n) {
        if (n == 0) return {};
        // 记录所有合法的括号组合
        vector<string> res;
        // 回溯过程中的路径
        string track;
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    void backtrack(int left, int right, 
                string& track, vector<string>& res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.push_back(track);
            return;
        }
        
        // 尝试放一个左括号
        track.push_back('('); // 选择
        backtrack(left - 1, right, track, res);
        track.pop_back(); // 撤消选择

        // 尝试放一个右括号
        track.push_back(')'); // 选择
        backtrack(left, right - 1, track, res);
        track.pop_back(); // 撤消选择
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func generateParenthesis(n int) []string {
    if n == 0 {
        return []string{}
    }
    // 记录所有合法的括号组合
    var res []string
    // 回溯过程中的路径
    var track string
    // 可用的左括号和右括号数量初始化为 n
    backtrack(n, n, &track, &res)
    return res
}

// 可用的左括号数量为 left 个，可用的右括号数量为 right 个
func backtrack(left, right int, track *string, res *[]string) {
    // 若左括号剩下的多，说明不合法
    if right < left {
        return
    }
    // 数量小于 0 肯定是不合法的
    if left < 0 || right < 0 {
        return
    }
    // 当所有括号都恰好用完时，得到一个合法的括号组合
    if left == 0 && right == 0 {
        *res = append(*res, *track)
        return
    }

    // 尝试放一个左括号
    *track += "(" // 选择
    backtrack(left-1, right, track, res)
    *track = (*track)[:len(*track)-1] // 撤消选择

    // 尝试放一个右括号
    *track += ")" // 选择
    backtrack(left, right-1, track, res)
    *track = (*track)[:len(*track)-1] // 撤消选择
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var generateParenthesis = function(n) {
    if (n === 0) return [];
    // 记录所有合法的括号组合
    var res = [];
    // 回溯过程中的路径
    var track = "";
    // 可用的左括号和右括号数量初始化为 n
    backtrack(n, n, track, res);
    return res;
};

// 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
var backtrack = function(left, right, track, res) {
    // 若左括号剩下的多，说明不合法
    if (right < left) return;
    // 数量小于 0 肯定是不合法的
    if (left < 0 || right < 0) return;
    // 当所有括号都恰好用完时，得到一个合法的括号组合
    if (left === 0 && right === 0) {
        res.push(track);
        return;
    }

    // 尝试放一个左括号
    track += '('; // 选择
    backtrack(left - 1, right, track, res);
    track = track.substring(0, track.length - 1); // 撤消选择

    // 尝试放一个右括号
    track += ')'; // 选择
    backtrack(left, right - 1, track, res);
    track = track.substring(0, track.length - 1); // 撤消选择
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 085. 生成匹配的括号 🟠](/problems/IDBivT)

</details>
</div>





