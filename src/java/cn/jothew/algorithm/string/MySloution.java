package cn.jothew.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySloution {
    List<String> list = new ArrayList<>();//用于存放结果的数组

    public String[] permutation(String s) {
        char[] arrs = s.toCharArray();//获取字符数组用于排序

        Arrays.sort(arrs);//有重复元素需要排序，便于剪枝

        int[] flagArrs = new int[arrs.length];//定义用于判断是否使用过的flag数组

        StringBuffer sb = new StringBuffer(arrs.length);//用于存放结果的容器

        sloution(arrs,flagArrs,sb);//回溯算法

        String[] res = new String[list.size()];
        //格式化结果
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }

        return res;
    }

    private void sloution(char[] arrs,int[] flagArrs,StringBuffer sb){
        //添加完成，存储结果
        if (sb.length()==arrs.length){
            list.add(sb.toString());
            return;
        }

        for (int i=0;i<arrs.length;i++){

            //已添加元素跳过
            if (flagArrs[i]==1){
                continue;
            }
            char cur = arrs[i];//当前操作字符

            //剪枝
            if (i>0 && flagArrs[i-1]==1 && cur==arrs[i-1]){
                continue;
            }

            sb.append(cur);
            flagArrs[i]=1;//标记已使用
            sloution(arrs,flagArrs,sb);//递归处理子节点

            //重置状态遍历同层下一个节点
            flagArrs[i]=0;
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
