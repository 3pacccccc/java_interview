package day05;

/**
 * @author: maruimin
 * @date: 2020/7/29 22:38
 */
public class TestStep {
    /**
     * 题目: 有n步台阶，一次只能上1步或者2步，共有多少种走法?
     */
    public static void main(String[] args) {
        CalStep calStep = new CalStep();
        System.out.println(calStep.step2(5));
    }

}

class CalStep {
    public int step1(int n) {
        // 递归的方法，浪费了空间，而且容易造成栈的溢出
        if (n < 1) {
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return step1(n - 2) + step1(n - 1); // 假设有10步梯子，则总共的走法有到8步的走法总数(最后还剩2步，可以一下走完) + 到9步的走法总数(最后还剩1步，可以一下走完)
    }

    public int step2(int n) {
        // 节省了空间。这种方法在效率上要远高于step1递归!!!
        if (n < 1) {
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }

        int one = 2; // 初始化为走到第二级台阶的走法
        int two = 1; // 初始化为走到第一级台阶的走法
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}
//f(3) = f(1) + f(2)
//f(4) = f(1) + 2f(2)
// f(5) = f(3) + f(4)  = f(1) + f(2) + f(2) + f(1) + f(2) = 2f(1) + 3f(2)
// f(6) = f(4) + f(5)  = 3f(1) + 5f(2)
// f(7) = f(5) + f(6)  = 5f(1) + 8f(2)

