import java.util.Scanner;

public class MinMax {
/* Class Pair is used to return two values from getMinMax() */
    //Like structure in C lang
    static class Pair {
 
        int min;
        int max;
    }
 
    static Pair getMinMax(int arr[], int low, int high) {
        Pair minmax = new Pair();
        Pair minmaxleft = new Pair();
        Pair minmaxright = new Pair();
        int mid;
 
        // If there is only one element 
        if (low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }
 
        /* If there are two elements */
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }
 
        /* If there are more than 2 elements */
        mid = (low + high) / 2;
        minmaxleft = getMinMax(arr, low, mid);
        minmaxright = getMinMax(arr, mid + 1, high);
 
        /* compare minimums of two parts*/
        if (minmaxleft.min < minmaxright.min) {
            minmax.min = minmaxleft.min;
        } else {
            minmax.min = minmaxright.min;
        }
 
        /* compare maximums of two parts*/
        if (minmaxleft.max > minmaxright.max) {
            minmax.max = minmaxleft.max;
        } else {
            minmax.max = minmaxright.max;
        }
 
        return minmax;
    }
 
    /* Driver program to test above function */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int arr_size = sc.nextInt();

        System.out.println("Enter the array Elements: ");

        int[] arr = new int[arr_size] ;

        
        for(int i=0;i<arr_size;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        Pair minmax = getMinMax(arr, 0, arr_size - 1); //we need to pass index not number hence the -1
        
        System.out.printf("\nMinimum element is:  %d", minmax.min);
        System.out.printf("\nMaximum element is:  %d", minmax.max);
 
    }
}
//time complexity : O(n)