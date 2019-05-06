
import java.util.Arrays;                                                                                               // Mc

public class MergeSort 
{
    public static void main(String[] args) 
    {
        int[] data = {1, 8, 2, 7, 6, 4, 5, 3};
        int[] temp = new int[8];
        
        System.out.println("ORIGINAL ARRAY: " + Arrays.toString(data));
        System.out.println("TEMP ARRAY BEFORE MERGE: " + Arrays.toString(temp));
        mergeSort(data, 2, 5, temp);
        System.out.println("TEMP ARRAY AFTER MERGE: " + Arrays.toString(temp));
        System.out.println("SORTED ARRAY AFTER TEMP IS COPIED INTO ORIG. ARRAY: "
                + Arrays.toString(data));
    }
    public static void mergeSort(int[] data, int from, int to, int[] temp)
    {
        int mid;
        if (from < to )
        {
            mid = (from + to) / 2;
            mergeSort(data,from,mid,temp);
            mergeSort(data,mid+1,to,temp);
            
            merge(data,from,mid,to,temp);
        }
       
    }
    
    public static void merge(int[] data, int from, int mid, int to, int[] temp)
    {
        int left = from;
        int right = mid + 1;
        int tIndex = from;
        
        while(left <= mid && right <= to)
        {
            if(data[left] < data[right])
            {
                temp[tIndex] = data[left];
                left++;
            }
            else
            {
                temp[tIndex] = data[right];
                right++;
            }
         tIndex++;
        }
        
        
        while (left<= mid)
        {
            temp[tIndex] = data[left];
            left++;
            tIndex++;
        }
        
        
        while (right<= to)
        {
            temp[tIndex] = data[right];
            right++;
            tIndex++;
        }
        
        
       //copy temp[from] to [to] into array\\   
       for(int i = temp[from]; i<=temp[to];i++)
       {
           data[i] = temp[i];
       }
    }
}    
