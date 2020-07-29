package day03;

/**
 *
 * 子类的初始化<clinit>:
 *      先初始化父类(5)(1)，再初始化子类(10)(6)
 *      (1) j = method();
 *      (2). 子类的静态代码块
 *
 * 子类的实例化方法:
 *      (1). super()(最前)(9)(3)(2)
 *      (2). i = test(); (9)
 *      (3). 子类的非静态代码块(8)
 *      (4). 子类的无参构造(最后)(7)
 *
 *      因为创建了2个Son对象，所以实例化方法<init>方法执行了两次
 *      (9)(3)(2)(9)(8)(7)
 *
 *
 *
 * @author: maruimin
 * @date: 2020/7/19 17:52
 */
public class Son extends Father {
    private int i = test();

    private static int j = method();

    static {
        System.out.println("(6)");
    }

    Son() {
        super(); // 写或者不写都存在，在子类构造器中一定会调用父类的构造器。
        System.out.println("(7)");
    }
    {
        System.out.println("(8)");
    }

    public int test() {
        System.out.println("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();
    }
}
