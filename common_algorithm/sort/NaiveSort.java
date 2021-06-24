import java.util.Arrays;
// 选择、冒泡、直接插入
public class NaiveSort {
    /**
     * 选择排序
     * 每次选择从i往后最小的数，放在i位置
     * @param a
     */
    public static void selectSort(int[] a) {
        int tmp;
        for(int i=0; i<a.length; i++){
            int min_i = i;
            for(int j = i+1; j<a.length; j++){
                if(a[j] < a[min_i]){
                    min_i = j;
                }
            }
            tmp = a[i];
            a[i] = a[min_i];
            a[min_i] = tmp;
        }
    }
    /**
     * 冒泡排序：
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int tmp;
        for(int i=0; i<a.length-1; i++){
            boolean exchanged = false;
            for(int j = 0; j<a.length-1-i; j++){
                if(a[j] > a[j+1]){
                    exchanged = true;
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
            if(! exchanged){
                break;
            }
        }
    }
    /**
     * 插入排序
     * 思想（升序, inplace, 从后向前扫描）：
     *  a[0:(i-1)] 为已排序序列，当前想要插入的数为 a[i]：
     *  从 a[i-1]开始，从后向前依次检查每个数：
     *  如果 a[i] 小于当前位置的数，说明 a[i] 插入的位置应该在当前数的前面，
     *  所以将当前位置的数后移一个位置。直到找到第一个不大于 a[i] 的数。
     *  因为是已排序序列，当前数不大于 a[i] ,它前面的数肯定都不大于 a[i]， 
     *  所以 a[i] 应该放到当前数的后一个位置。
     */
    public static void insertSort(int[] a) {
        for(int i=1; i<a.length; i++){        // 从 1 开始，假设 a[0] 已排序
            int j=i;
            int target = a[i];    // 保存 a[i], a[j] = a[j-1] 时会覆盖
            while (j>0 && target < a[j-1]) {  // 在已排序序列中，从后向前，找到第一个不大于 
                                              // target的数；
                a[j] = a[j-1];          // 如果 target < 当前位置的数，后移当前数，
                                        // 因为已排序的数都在数列的前边 0～(j-1) 的位置；
                j--;                    // j 指针，target 需要插入的位置；
            }
            a[j] = target;
        }
    }
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
