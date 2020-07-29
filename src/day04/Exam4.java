package day04;

import java.util.Arrays;

/**
 * @author: maruimin
 * @date: 2020/7/29 20:53
 */
public class Exam4 {

    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 2;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(i, str, num, arr, my);

        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("my = " + my.a);
//        结果
//        i = 1  因为是基本数据类型，所以不会变
//        str = hello 在change函数里面变成helloworld，再把helloworld在堆里面的地址赋值给str
//        num = 2 跟str同理
//        arr = [2, 2, 3, 4, 5] 内存地址没改变，里面的元素发生改变
//        my = 11 跟arr同理
    }

    public static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}
