import java.util.*;
public class BinarySearch{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();
		int a[]= new int[n];
		System.out.println("Enter the elements in sorted order: ");
		for (int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("Enter the element to search: ");
		int search = sc.nextInt();
		BinarySearch_algo(a,0,n-1,search);
	}
	public static void BinarySearch_algo(int a[],int low,int high,int key){
	int mid,flag=0;
	while(low<=high){
		mid = (high+low)/2;
		if(a[mid] == key){
			System.out.println("Element found at "+(mid+1)+" position");
			flag = 1;
			break;
		}
		else if(key < a[mid])
			high = mid-1;
		else
			low = mid+1;
	}
	if(flag == 0)
		System.out.println("Element not found");
}
}
//Best Case = O(1) Worst case = O(logn)