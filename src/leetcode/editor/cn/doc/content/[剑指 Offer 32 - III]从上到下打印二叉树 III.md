<p>请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。</p>

<p>&nbsp;</p>

<p>例如:<br> 给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</br></p>

<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>

<p>返回其层次遍历结果：</p>

<pre>[
  [3],
  [20,9],
  [15,7]
]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li><code>节点总数 &lt;= 1000</code></li> 
</ol>

<details><summary><strong>Related Topics</strong></summary>树 | 广度优先搜索 | 二叉树</details><br>

<div>👍 283, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [103. 二叉树的锯齿形层序遍历](/problems/binary-tree-zigzag-level-order-traversal) 相同。

这题和 [102. 二叉树的层序遍历](/problems/binary-tree-level-order-traversal) 几乎是一样的，只要用一个布尔变量 `flag` 控制遍历方向即可。

**标签：[BFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (root == nullptr) {
            return res;
        }

        queue<TreeNode*> q;
        q.push(root);
        // 为 true 时向右，false 时向左
        bool flag = true;

        // while 循环控制从上向下一层层遍历
        while (!q.empty()) {
            int sz = q.size();
            // 记录这一层的节点值
            deque<int> level;
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode* cur = q.front();
                q.pop();
                // 实现 z 字形遍历
                if (flag) {
                    level.push_back(cur->val);
                } else {
                    level.push_front(cur->val);
                }
                if (cur->left != nullptr)
                    q.push(cur->left);
                if (cur->right != nullptr)
                    q.push(cur->right);
            }
            // 切换方向
            flag = !flag;
            res.emplace_back(vector<int>(level.begin(), level.end()));
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root is None:
            return res
        
        q = deque([root])
        # 为 True 时向右，False 时向左
        flag = True
        
        # while 循环控制从上向下一层层遍历
        while q:
            sz = len(q)
            # 记录这一层的节点值
            level = deque()
            # for 循环控制每一层从左向右遍历
            for i in range(sz):
                cur = q.popleft()
                # 实现 z 字形遍历
                if flag:
                    level.append(cur.val)
                else:
                    level.appendleft(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            # 切换方向
            flag = not flag
            res.append(list(level))
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 为 true 时向右，false 时向左
        boolean flag = true;

        // while 循环控制从上向下一层层遍历
        while (!q.isEmpty()) {
            int sz = q.size();
            // 记录这一层的节点值
            LinkedList<Integer> level = new LinkedList<>();
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 实现 z 字形遍历
                if (flag) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            // 切换方向
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func zigzagLevelOrder(root *TreeNode) [][]int {
    res := [][]int{}
    if root == nil {
        return res
    }

    q := []*TreeNode{root}
    // 为 true 时向右，false 时向左
    flag := true

    // while 循环控制从上向下一层层遍历
    for len(q) > 0 {
        sz := len(q)
        // 记录这一层的节点值
        level := []int{}
        // for 循环控制每一层从左向右遍历
        for i := 0; i < sz; i++ {
            cur := q[0]
            q = q[1:]
            // 实现 z 字形遍历
            if flag {
                level = append(level, cur.Val)
            } else {
                level = append([]int{cur.Val}, level...)
            }
            if cur.Left != nil {
                q = append(q, cur.Left)
            }
            if cur.Right != nil {
                q = append(q, cur.Right)
            }
        }
        // 切换方向
        flag = !flag
        res = append(res, level)
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var zigzagLevelOrder = function(root) {
    let res = [];
    if (root === null) {
        return res;
    }

    let q = [];
    q.push(root);
    // 为 true 时向右，false 时向左
    let flag = true;

    // while 循环控制从上向下一层层遍历
    while (q.length !== 0) {
        let sz = q.length;
        // 记录这一层的节点值
        let level = [];
        // for 循环控制每一层从左向右遍历
        for (let i = 0; i < sz; i++) {
            let cur = q.shift();
            // 实现 z 字形遍历
            if (flag) {
                level.push(cur.val);
            } else {
                level.unshift(cur.val);
            }
            if (cur.left !== null)
                q.push(cur.left);
            if (cur.right !== null)
                q.push(cur.right);
        }
        // 切换方向
        flag = !flag;
        res.push(level);
    }
    return res;
};
```

</div></div>
</div></div>

**类似题目**：
  - [1609. 奇偶树 🟠](/problems/even-odd-tree)
  - [剑指 Offer 32 - III. 从上到下打印二叉树 III 🟠](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof)

</details>
</div>



