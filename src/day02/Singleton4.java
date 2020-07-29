package day02;

/**
 * 懒汉式：延迟创建这个实例对象
 * (1) 构造器私有化
 * (2) 用一个静态变量保存这个唯一的实例
 * (3) 提供一个静态方法,获取这个实例对象
 *
 * @author: maruimin
 * @date: 2020/7/19 10:35
 */
public class Singleton4 { // 注意:这种写法是线程不安全的!!!
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        System.out.println(instance); // day02.Singleton4@1b6d3586
        System.out.println(instance2); // day02.Singleton4@1b6d3586
    }
}
