import java.util.*;
public class InsertionSort{
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
		for(int i = 1;i<n;i++){
			temp = a[i];
			position = i;
			while(position>0 && a[position-1]>temp){
				a[position] = a[position-1];
				position= position-1;
			}
			a[position] = temp;
		}
		System.out.println("Elements after sorting are: ");
		for(int i =0;i<n;i++){
			System.out.println(a[i]);
		}
	}
}
//Time Complexity Best Case : O(n) Average/Worst Case : O(n^2)