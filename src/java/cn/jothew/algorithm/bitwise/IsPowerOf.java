package cn.jothew.algorithm.bitwise;

import java.util.regex.Pattern;

/**
 * 判断int a 是否为某个数的幂等数
 *
 * 思路：10进制10的幂等表示为10000...  2进制2的幂等表示为1000... 同理a进制的a的幂等为10000
 */
public class IsPowerOf {

    /**
     * 判断a是否是3的幂等
     * @param a
     * @return
     */
    public static boolean isPowerOfThree(int a,int radix){
        Integer val = a;

        //转二进制
        String binary = Integer.toBinaryString(2);
        System.out.println(binary);
        //转八进制
        String octal =Integer.toOctalString(8);
        System.out.println(octal);
        //转16进制
        String hex = Integer.toHexString(16);
        System.out.println(hex);

        //public static String toString(int i, int radix) 将十进制整数i转为 radix进制
        String s = Integer.toString(val,radix);

        //"^10*$":正则表达式,含义为匹配100...结构
        boolean res = Pattern.matches("^10*$",s);

        return res;
    }

    public static void main(String[] args) {
        boolean res = isPowerOfThree(27,3);

        System.out.println(res);
    }
}
