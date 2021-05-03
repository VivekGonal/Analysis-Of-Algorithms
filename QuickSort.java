import java.util.*;
public class QuickSort {
    public static void quicksort(int A[], int low, int high) {
        if(low<high) {
            int pi = partition(A,low,high);
            quicksort(A,low,pi-1);
            quicksort(A,pi+1,high);
        } 
    }
    public static int partition(int A[], int low, int high) {
        int pivot = A[low];
        int i = low;
        int j = high;
        while(i<j){
            while(A[i] <= pivot && i < A.length-1)
                i = i + 1;
            while(A[j] > pivot && j >0)
                j = j - 1;
            if (i < j){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;}
        } 
        int temp = A[low];
        A[low] = A[j];
        A[j] = temp;
        return j;
    }
    public static void display(int A[], int n) {
        for(int i=0;i<n;i++)
            System.out.println(A[i] + " ");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        quicksort(a,0,n-1);
        display(a,n);
    }
}
//Average Case-Best Case = O(nlogn) Worst Case = O(n^2)