package cn.jothew.algorithm.tree;

import java.util.Arrays;
import java.util.stream.Collectors;

class SolutionTree {

    public int countNodes(TreeNode root) {
        int[] nums = {1,2,3,4};
        int target = 1;
        Arrays.stream(nums).filter(e->e==target).boxed().collect(Collectors.toList());
        return root==null ? 0: 1+countNodes(root.left)+countNodes(root.right);
    }

    public static void main(String[] args) {
        int a =-2147483648;
        int b = 1;

        SolutionTree solutionTree = new SolutionTree();
        int res = solutionTree.divide2(a,b);
        System.out.println(res);
    }

    public int divide(int a, int b) {
        if(a==Integer.MIN_VALUE && b==-1) return Integer.MAX_VALUE;

        int sign=(a>0) ^ (b>0) ? 0:1;

        int count=0;
        a = Math.abs(a);
        b = Math.abs(b);

        while(a>=b){
            a-=b;
            count++;
        }

        return sign==1?count:-count;
    }

    public int divide2(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = a==Integer.MIN_VALUE? Integer.MAX_VALUE:Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648
            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
            if ((a >>> i) - b >= 0) { // a >= (b << i)
                a -= (b << i);
                res += (1 << i);
            }
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }
}