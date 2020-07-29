package day02;

import java.io.IOException;
import java.util.Properties;

/**
 * 单例模式总结
 * 自己手写
 *
 * @author: maruimin
 * @date: 2020/7/19 17:12
 */
public class Sumary {
}

class SelfSingleton1 {
    // 第一种方法: 饿汉式，线程安全
    public static SelfSingleton1 INSTANCE = new SelfSingleton1();

    private SelfSingleton1() {

    }
}

class SelfSingleton2 {
    // 第二种写法:枚举类，饿汉式,线程安全
}

enum Singleton2Enum {
    INSTANCE;
}

class SelfSingleton3 {
    // 第三种写法,复杂加载的饿汉式，线程安全
    private String info;

    public static final SelfSingleton3 INSTANCE;

    static {
        try {
            Properties pro = new Properties();
            pro.load(SelfSingleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new SelfSingleton3(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private SelfSingleton3(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class SelfSingleton4 {
    // 第四种写法，懒汉式，线程不安全，适合用于单线程
    private static SelfSingleton4 INSTANCE;

    private SelfSingleton4() {

    }

    public static SelfSingleton4 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SelfSingleton4();
        }
        return INSTANCE;
    }
}

class SelfSingleton5 {
    // 第五种写法,懒汉式，线程安全，可以用于多线程。
    private static SelfSingleton5 INSTANCE;

    private SelfSingleton5() {

    }

    public static SelfSingleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (SelfSingleton5.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SelfSingleton5();
                }
            }
        }
        return INSTANCE;
    }
}

class SelfSingleton6 {
    // 第六种写法,内部类
    private SelfSingleton6() {

    }

    private static class Inner {
        private final static SelfSingleton6 INSTANCE = new SelfSingleton6();
    }

    public static SelfSingleton6 getInstance() {
        return Inner.INSTANCE;
    }

}