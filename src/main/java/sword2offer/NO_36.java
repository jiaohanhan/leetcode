package sword2offer;

/**
 * 数组中的逆序对
 * 题目描述：在数组中的两个数字如果前面一个数字大雨后面的数字，则这两个数字组成一个逆序对
 */
public class NO_36 {
    public int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;
    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low + high) >> 1;
//        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int leftCount = InversePairsCore(array, copy, low, mid);
//        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high);
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
//                if (count >= 1000000007)//数值过大求余
//                {
//                    count %= 1000000007;
//                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
//        return (leftCount + rightCount + count) % 1000000007;
        return (leftCount + rightCount + count);
    }
}
