package day02;

/**
 * 注意: 饿汉式都是线程安全的！！！
 * 饿汉式的第一种写法
 * 在类初始化的时候直接创建实例对象，不管你是否需要这个对象都会创建
 * (1) 构造器私有化
 * (2) 自行创建，并用静态变量保存
 * (3) 向外提供这个实例
 * (4) 强调这是一个单例，可以用final修饰
 *
 * @author: maruimin
 * @date: 2020/7/14 21:13
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }
}

class Test {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.INSTANCE;
        System.out.println(instance); // day02.Singleton1@1b6d3586
        Singleton1 instance1 = Singleton1.INSTANCE;
        System.out.println(instance1); // day02.Singleton1@1b6d3586
        /**
         * 总结：不管你是否需要实例对象INSTANCE(比如你想访问Singleton1的其他方法，INSTANCE还是会被直接创建出来)，
         * 都会被直接创建出来(所以叫饿汉式)
         */
    }
}