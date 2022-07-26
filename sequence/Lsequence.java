package sequence;
import java.util.Scanner;

public class Lsequence {

     static int lis(int arr[], int n)
	{
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in
		bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
                   
		
		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++)
		{
			System.out.println(lis[i]);

			if (max < lis[i])
				max = lis[i];
		}

		return max;
	}

	
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		int i=0,q=0;
		System.out.println("Enter the quantity of numbers for the Sequence");
		q= in.nextInt();
		int arr[]=new int[q];
		System.out.println("Enter the numbers for the Sequence");
        for( i=0;i<q;i++)
		arr[i] = in.nextInt();
        
		int n = arr.length;
		System.out.println("Length of longest increasing sequence is " + lis(arr, n)
						+ "\n");
	}
}




