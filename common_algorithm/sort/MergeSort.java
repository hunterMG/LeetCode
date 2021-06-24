/**
 * 归并排序
 * 思想：
 *  将原数组划分为前半部分和后半部分，假设这两个是已排序数组，
 *  将这两个数组的元素从头依次比较，将较小的放进temp数组。
 *  则temp数组最终为已排序。
 *  递归终止条件：序列中只剩一个数。
 */
import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] a) {
        int[] temp = new int[a.length];// temp 数组，避免递归中频繁开辟空间
        sort(a, 0, a.length-1, temp); 
    }    
    public static void sort(int[] a, int left, int right, int[] temp) {
        if(left < right){   // 递归终止条件：序列中只剩一个数
            int mid = (left + right) / 2;
            sort(a, left, mid, temp);   // 左边
            sort(a, mid+1, right, temp);    //右边
            merge(a, left, mid, right, temp);// 合并（排序）
        }
    }
    public static void merge(int[] a, int left, int mid, int right, int[] temp) {
        int i = left,   // 左序列指针
            j = mid+1,  // 右序列指针
            t = 0;      // temp 数组指针
        while (i<=mid && j<=right) {// 归并排序
            if(a[i] <= a[j]){
                temp[t++] = a[i++];
            }else{
                temp[t++] = a[j++];
            }
        }
        while (i<=mid) {    // 左序列中剩余的数
            temp[t++] = a[i++];
        }
        while (j<=right) {  // 右序列中剩余的数
            temp[j++] = a[j++];
        }
        t = 0;
        while (left <=right) {  // 拷贝到原数组 
            a[left++] = temp[t++];
        }
    }
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
