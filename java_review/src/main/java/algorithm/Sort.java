package algorithm;

/**
 * @author dongfeng
 * @since 2023-11-26 22:01
 */
public class Sort {

    public static void main(String[] args) {

    }
    public static int quickSort(int[] array, int target){
        int l = 0;
        int r = array.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(array[mid]<target){
                l=mid+1;
            }else if(array[mid]>target){
                r=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
