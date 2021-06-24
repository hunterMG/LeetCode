/**
 * 快速排序
 * 
 * 思想（升序, 递归）：
 *  先确定一个基准数 base，如数列的第一个数，然后将剩余的数分成两个数列，
 *  一个数列里的数都 < base，另一个数列中的数都 >= base，
 *  小于的数列放 base 左边, 大于的数列放 base 右边。
 *  再分别对这两个集合中的数重复上述过程，直到每个集合中只有一个数。
 * 
 * 实现：
 *  1. 数列第一个数作为 base,起始位置为 left，末尾位置为 right。
 *  2. 两个指针 i 和 j， j 指针从后往前找第一个小于 base 的数，
 *      找到后停止；然后 i 指针开始从前往后找第一个大于 base 的数，
 *      找到后如果 i<j, 交换 a[i] 和 a[j]。 
 *      j 指针和 i 指针再开始上述查找过程，直到 i=j。
 *      所以有两层循环，外循环控制 i<=j, 内循环两个用于 i 和 j 指针的查找。
 *  3. 外循环结束后，i=j, 将 base 放到中间位置 i, 而 a[i] 放到之前 base 的位置 left。
 *      因为 最后 a[i] 也是 <= base 的。
 *      这样 base 左边的数全 <= base, 右边的数都 >= base;
 *  4. 对 base 左边和右边的序列进行上述过程，直到每个序列只剩一个数。
 * 
 * reference: 
 *  https://www.cnblogs.com/captainad/p/10999697.html
 *  https://blog.csdn.net/elma_tww/article/details/86164674
 */
public class QuickSort {
    public static void sort(int[] array, int left, int right) {
        if(left >= right){
            return;
        }// 只有一个数时直接返回(递归的终止条件)

        int base = array[left];
        int i = left, j = right;
        while (i < j) {
            while ( i < j && array[j]>= base) {
                j--;
            }// 从右边找到小于 base 的数或者 i=j 了结束循环
            while ( i < j && array[i] <= base) {
                i++;
            }// 从左边找到大于 base 的数或者 i=j 了结束循环
            if(i < j){  //当 i<j 时，交换 i 和 j 处的数. 其实不判断也可。
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }//循环结束，i=j. 因为内部的 while 循环条件有 i<j, 所以最后一定是 i=j
        array[left] = array[i]; //将 array[i] 移到 left 位置
        array[i] = base;        //中间 i 处放 base，完成此次排序

        sort(array, left, i-1);
        sort(array, i+1, right);
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 3, 5, 13, 9, 3, 6, 11};
        sort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
            System.out.printf("%d\n%5d\n%11.2f", 1234567890, 12, 3.2);
        }
    }
}
