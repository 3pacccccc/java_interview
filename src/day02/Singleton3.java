package day02;

import java.io.IOException;
import java.util.Properties;

/**
 * 内部静态代码块的饿汉式
 *
 * @author: maruimin
 * @date: 2020/7/14 21:32
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;

    private String info;

    static {
        try {
            Properties pro = new Properties();
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton3(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Singleton3(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public static void main(String[] args) {
        Singleton3 instance = Singleton3.INSTANCE;
        Singleton3 instance1 = Singleton3.INSTANCE;
        System.out.println(instance); //day02.Singleton3@4554617c
        System.out.println(instance1); //day02.Singleton3@4554617c
    }
}
