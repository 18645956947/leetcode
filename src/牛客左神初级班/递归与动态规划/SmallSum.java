package 牛客左神初级班.递归与动态规划;

/**
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和。
 * 例子： [1,3,4,2,5] 1左边比1小的数，没有；
 * 3左边比3小的数，1； 4左边比4小的数，1、3；
 * 2左边比2小的数，1； 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 * @author zhx
 */
public class SmallSum {
    public static int  smallSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return mergeSort(arr, 0, arr.length  -1);
    }
    public static int mergeSort(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
//        int mid = (L + R)/2;
        return mergeSort(arr, L, mid) + mergeSort(arr, mid + 1, R) + merge(arr, L, mid, R);
    }
    public static int merge(int[] arr, int L, int mid, int R){
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int[] help = new int[R - L + 1];
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }

        return res;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(SmallSum.smallSum(arr));
    }
}