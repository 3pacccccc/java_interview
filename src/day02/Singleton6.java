package day02;

/**
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的
 * 因为是在内部类加载和初始化时创建的，所以是线程安全的
 *
 * @author: maruimin
 * @date: 2020/7/19 10:51
 */
public class Singleton6 {
    // 第六种写法，内部类。懒汉式，线程安全
    private Singleton6() {
    }

    private static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton6 singleton6 = new Singleton6();
    }
}
