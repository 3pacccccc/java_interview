package day01;

/**
 * day01赋值
 * @author: maruimin
 * @date: 2025/2/7 0:26
 */
public class Test1 {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + i++ * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
    /**
     * 结论：
     * 赋值=，最后计算
     * =右边的从左到右加载值依次压入操作数栈
     * 实际先算哪个，看运算符优先级
     * 自增、自减操作都是直接修改变量的值，不经过操作数栈
     * 最后的赋值前，临时结果也是存储在操作数栈中
     */
}
