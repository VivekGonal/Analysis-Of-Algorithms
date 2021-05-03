import java.util.*;
public class MergeSort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		System.out.println("Enter the elements: ");
		int a[] = new int[n];
		int position,temp;
		for(int i = 0;i<n;i++){
			a[i]=sc.nextInt();
		}
		sort(a,0,n-1);
		System.out.println("Elements after sorting are: ");
		for(int i =0;i<n;i++){
			System.out.println(a[i]);
		}
	}
	public static void sort(int arr[],int beg,int end){
		if(beg<end){
			int mid =(beg+end)/2;
			sort(arr,beg,mid);
			sort(arr,mid+1,end);
			merge(arr,beg,mid,end);
		}
	}
	public static void merge(int arr[],int beg,int mid,int end){
		int l = mid-beg+1;
		int r = end-mid;
		int leftarr[] = new int[l];
		int rightarr[] = new int[r];
		for(int i =0;i<l;i++){
			leftarr[i] = arr[beg+i];
		}
		for(int j =0;j<r;j++){
			rightarr[j] = arr[mid+1+j];
		}
		int i=0,j=0;
		int k =beg;
		while(i<l && j<r){
			if(leftarr[i] <= rightarr[i]){
				arr[k] = leftarr[i];
				i++;
			}
			else{
				arr[k] = rightarr[j];
				j++;
			}
			k++;
		}
		while(i<l){
			arr[k] = leftarr[i];
			i++;
			k++;
		}
		while(j<r){
			arr[k] = rightarr[j];
			j++;
			k++;
		}
	}
}
//Time Complexity Best Case : O(nlogn) Average/Worst Case : O(nlogn)