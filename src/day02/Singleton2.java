package day02;

/**
 * 枚举类型: 表示该类型的对象是有限的几个
 * 我们可以限定成一个，就成了单例
 * @author: maruimin
 * @date: 2020/7/14 21:25
 */
public class  Singleton2 {
    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance); // INSTANCE
        System.out.println(instance2); // INSTANCE
    }
}

enum SingletonEnum {
    INSTANCE
}
