package day02;

import java.util.concurrent.*;

/**
 * 懒汉式：延迟创建这个实例对象
 * (1) 构造器私有化
 * (2) 用一个静态变量保存这个唯一的实例
 * (3) 提供一个静态方法,获取这个实例对象
 *
 * @author: maruimin
 * @date: 2020/7/19 10:35
 */
public class Singleton5 { // 注意:这种写法是线程安全的!!!
    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton5> c = new Callable<Singleton5>() {
            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = es.submit(c);
        Future<Singleton5> f2 = es.submit(c);

        Singleton5 s1 = f1.get();
        Singleton5 s2 = f2.get();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s1);
    }
}
