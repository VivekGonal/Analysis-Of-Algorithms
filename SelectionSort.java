import java.util.*;
public class SelectionSort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		System.out.println("Enter the elements: ");
		int a[] = new int[n];
		int position,temp;
		for(int i =0;i<n;i++){
			a[i]=sc.nextInt();
		}
		for(int i =0;i<n-1;i++){
			position = i;
			for(int j =i+1;j<n;j++){
				if(a[j]<a[position])
				{
					position =j;
				}
				temp = a[i];
				a[i] = a[position];
				a[position] = temp;
			}
		}
		System.out.println("Elements after sorting are: ");
		for(int i =0;i<n;i++){
			System.out.println(a[i]);
		}
	}
}
//Time Complexity Best-Worst-Average Cases are same: O(n^2)