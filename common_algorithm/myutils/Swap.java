package utils;
// https://blog.csdn.net/weixin_45431341/article/details/97962663
import java.util.Arrays;

public class Swap {
    /**
     * 通过中间变量交换两个数的值
     */
    public static void tmpSwap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /**
     * 通过异或交换变量的值(一个数异或同一个数两次，结果还是那个数),不会超出 int 范围（最佳实现）
     */
    public static void xorSwap(int[] arr, int i, int j) {
        arr[i] = arr[i]^arr[j]; // a = a^b
        arr[j] = arr[i]^arr[j]; // b = a^b
        arr[i] = arr[i]^arr[j]; // a = a^b
    }
    /**
     * 两数求和然后相减交换变量的值。（若数值过大，超出 int 的值会损失精度）
     */
    public static void addSwap(int[] arr, int i, int j) {
        arr[i] = arr[i]+arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i]-arr[j];
    }
    /**
     * 一行代码交换变量的值
     */
    public static void onelineSwap(int[] arr, int i, int j) {
        arr[j] = (arr[i] + arr[j]) - (arr[i] = arr[j]);
    }
    public static void main(String[] args) {
        int a = 0, b = 1;
        System.out.printf("ori: %d %d\n", a, b);
        // tmp value
        int tmp = a;
        a = b;
        b = tmp;
        System.out.printf("tmp: %d %d\n", a, b);
        
        // by adding
        a = a+b;
        b = a+b;
        a = a-b;
        System.out.printf("add: %d %d\n", a, b);
        
        // xor
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.printf("xor: %d %d\n", a, b);

        // one line
        b = (a + b) - (a = b);
        System.out.printf("one: %d %d\n", a, b);

        int[] arr = {1,2};
        System.out.println(Arrays.toString(arr));
        tmpSwap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        xorSwap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        addSwap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
        onelineSwap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }
}
