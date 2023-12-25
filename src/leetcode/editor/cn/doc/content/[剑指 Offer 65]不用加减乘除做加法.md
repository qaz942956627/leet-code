<p>写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> a = 1, b = 1
<strong>输出:</strong> 2</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>a</code>,&nbsp;<code>b</code>&nbsp;均可能是负数或 0</li> 
 <li>结果不会溢出 32 位整数</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数学</details><br>

<div>👍 439, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这是位运算的经典场景，也是计算机执行加法运算的逻辑。十进制加法中我们先把每一位对齐，然后每一位相加，和大于等于 10 的话给下一位进一。

二进制的加法运算和十进制类似，也是每一位相加，和大于等于 2 的话进一位，只不过二进制数求和及进位的操作是用位运算来实现的。

异或运算 `^` 的结果可以理解为对应位相加，且运算 `&` 的结果左移一位可以理解为进位的结果，看代码中的示例比较好理解。

**标签：[位运算](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        // 设 a = 1001
        // 设 b = 0101
        // 求和 1100
        int sum = a ^ b;
        // 进位 0001 << 1 = 0010
        int carry = (a & b) << 1;
        // add(1100, 0010)
        return add(sum, carry);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def add(self, a: int, b: int) -> int:
        if a == 0 or b == 0:
            return b if a == 0 else a
        # 设 a = 1001
        # 设 b = 0101
        # 求和 1100
        sum = a ^ b
        # 进位 0001 << 1 = 0010
        carry = (a & b) << 1
        # add(1100, 0010)
        return self.add(sum, carry)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int add(int a, int b) {
        if(a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        // 设 a = 1001
        // 设 b = 0101
        // 求和 1100
        int sum = a ^ b;
        // 进位 0001 << 1 = 0010
        int carry = (a & b) << 1;
        // add(1100, 0010)
        return add(sum, carry);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func add(a int, b int) int {
    if a == 0 || b == 0 {
        if a == 0 {
            return b
        } else {
            return a
        }
    }

    // 设 a = 1001
    // 设 b = 0101
    // 求和 1100
    sum := a ^ b

    // 进位 0001 << 1 = 0010
    carry := (a & b) << 1

    // add(1100, 0010)
    return add(sum, carry)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var add = function(a, b) {
    if (a == 0 || b == 0) {
        return a == 0 ? b : a;
    }
    // 设 a = 1001
    // 设 b = 0101
    // 求和 1100
    let sum = a ^ b;
    // 进位 0001 << 1 = 0010
    let carry = (a & b) << 1;
    // add(1100, 0010)
    return add(sum, carry);
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof" data="G4wSERWbewB0JGSnoXc1JHbzVQGFyJ+5N09XLRXd2SfxIhTZaeYJbIvdfDvhw+1Y8Bgb+9scayh9rP/9XhElwwSMJhY6J0bl7d77J4QlwAchlgVS7XdlX2PrVF21blUW8ZyVNIWn4/TVeFvzTo4P/+xFJZxsbrz9DwMPpAmDKocgqa5PwdFhJabIf3B8hrlP481Awv2liJXMoVM80VeFvxJ6T1plEWHN0ZHxdmP3oT/FoHl+5Hi3K8tj/0Hc3CKHD7z9+ZtXzSEYaPPBaW9OOAqY/fw19dN+hp5SEWV0Dmn2KnZUg806qgNFRwUQPXQXn9AHA4P6DVEA7lrNZjDWkA+bwp8EeXd9L2UpSKuey0HQkJ4u/pwg2l5GtDGnvnxW6oEqVvcSNa9/2GtNLhNoRymWYv4cAzMwyuutAGKJuuGDRVIE9VwW0SZI6VWG/y6w/3uCmuRfAoWKeuk7yj/YBOk36fYpX5kOTPO9yAsWU3gNg1YKtSTkVjWOw7xkZ/4F6SW0HV7TuIEjHZHvLO7jbmRIuec1CJlBj4XMP415MHCg1tCEuhYS5KF1JMf9wsCMkmM2IOfUc1c3gtcDj423j/cHU585ZiBWW2NeFSi82+MlHL078g1+U2ATRsHU543CkbhdlJijAFjlM6CzuNwfJClmE7Jkhpqpi8d/iZcNzmSyaIPO7OENqmJCu8xKJ4EldAs8a5y3aWJ61z4b5BBnMGF1ZvB2ZVGjP++8LR05w0mwIvDZ3HgUHp2//2XvJWCrsSEKZeJd8ZgcyG7eA8oM1WHicr8+K5TitbTvT2WLBrYI80pYZsi+tUlv9WeBv2Uvgk+L+CDhbHF1kadF/OAlRUanjx74lPA5qMpIsE92dXvQtZb5B9qG5xNCijRL9MinQjdu4S/8+YfP5ZQTZy/xQoLQ1KxRnlGJx+5TnSs+b1vBwlUENS/2F8B4DEdJUZ2F+Tm2zRgpOImYV/8cft3PDRPjXagqa7YpTSEA4frBc077TjiruViQ8YAUWDEGNca+Y5+SGaydKIGkdF1Uwl/yqmBdg8dDjFlOh17GufUldO1QpGpIa3xewPHpwSwPm0gEmmB0YX0//jWukI8vWAiBKGfMTj8I234MGRK4UuWxHw+x66GKWqAedtcuqQjJni0/V9KSRufZvu2aOYriejn3NjY8wWDfFu2ar5+CWWduC34IE9acOH3eB9d9+PmHz+H9WHBU8mkkIuJspdODXUMjgjlwZN0LDV3GZMzZCjbI0jq9297AcDg5IaeTCMIhr6Udioe3fkF6uBp6XGm2/Ru0qCV2NdKeAWKLGlbjzVuOA60mLltqqzyHdjy6Q3NuW9ui6uOSfZpKRp4ckHz8T29j4uFnNh4fb994pfo0Vcg7FVV0OvXC3yfo/Q2Sv4cDsR+Tq3FshBASJ/IRkidPCJDra2L3QhhS23ubLOLQs+LsQ4KPmrGb7Vvu3yf/53kYQgEoJNF2APrAv8U/JqFFKvxVCRs57JU8IUj+IvYRPv8SkV9OBAAoefyYUIJO6WarJ/eHn0hm+AP5CaabyCn0/iPeRga2wx+XlJoinDnsdSA0/DHT4ZsNpxLyJtjj9IKbSQGmqGlEg+y5qWg9eOBkb/NIDeQcUjc="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof"></div></div>
</details><hr /><br />

</details>
</div>

