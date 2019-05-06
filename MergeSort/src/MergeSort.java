
import java.util.Arrays;                                                                                               // Mc

public class MergeSort  
{
    static int[] data = {1, 8, 2, 7, 6, 4, 5, 3};
    static int[] temp = data;
    static int[] tempMerge = new int[data.length];
                
    public static void main(String[] args) 
    {
        System.out.println("ORIGINAL ARRAY: " + Arrays.toString(data) + " WITH A LENGTH OF " + data.length);
        mergeSort(0, data.length-1);
        System.out.println("TEMP ARRAY AFTER MERGE: " + Arrays.toString(temp));
        System.out.println("SORTED ARRAY AFTER TEMP IS COPIED INTO ORIG. ARRAY: "
                + Arrays.toString(data));
    }
    public static void mergeSort(int from, int to)
    {
        
        if (from < to )
        {
            int mid = (from + to) / 2;
            mergeSort(from,mid);
            //System.out.println("Going " + from + " to " + mid);
            mergeSort(mid+1,to);
            // System.out.println("Going " + (mid+1) + " to " + to);
            merge(from,mid,to);
        }
       
    }
    
    public static void merge(int from, int mid, int to)
    {
        for(int i = from; i <= to; i++)
        {
            tempMerge[i] = data[i];
        }
        
        int left = from;
        int right = mid + 1;
        int tIndex = from;
        
        while(left <= mid && right <= to)
        {
            if(tempMerge[left] < tempMerge[right])
            {
                //System.out.println(data[left] + " less than " + data[right]);
                temp[tIndex] = tempMerge[left];
                left++;
            }
            else
            {
                //System.out.println(data[left] + " greater than " + data[right]);
                temp[tIndex] = tempMerge[right];
                right++;
            }
         tIndex++;
        }
        
        
        while (left<= mid)
        {
            temp[tIndex] = tempMerge[left];
            left++;
            tIndex++;
        }
    }
}    
