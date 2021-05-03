import java.util.Scanner;

/*
jobs  : 0 name of job
        1 deadline
        2 profit
        3 considered for selection? (0=no, 1=yes)
      
sequence: if the deadline of currently selected job is 3, then it is placed at slot (2-3))if empty
which means at index 2 i.e. (deadline-1).        
*/

public class jobSequencing
{
	int numOfJobs;
	Object[][] jobs;
	int totalProfit;
	String[] sequence;
	int maxTime=0,k;

	void inputItems()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of jobs: ");
		numOfJobs = sc.nextInt();

		jobs = new Object[4][numOfJobs];

		for(int i=0;i<numOfJobs;i++)
		{
			System.out.print("Name of Job " + (i+1) + " : ");
			jobs[0][i] = sc.next();
			System.out.print("Deadline of Job " + (i+1) + " : ");
			jobs[1][i] = sc.nextInt();
			//To decide maximum possible deadline
			if((Integer)jobs[1][i]>maxTime)
			{
				maxTime = (Integer)jobs[1][i];
			}
			System.out.print("Profit associated with Job " + (i+1) + " : ");
			jobs[2][i] = sc.nextInt();
			System.out.println();
			//Setting initial state of selection to 0
			jobs[3][i] = 0;
		}

		//Initializing the sequence array
		int temp = maxTime;
		sequence = new String[temp];
		for(int i=0;i<maxTime;i++)
		{
			sequence[i] = "EMPTY";
		}
	}

	void setSequence()
	{
		k=0; //counter for running while loop till all slots filled or all jobs tried to be assigned
		int selectedIndex=0;
		int maxProfit, selectedDeadline;
		while(k<numOfJobs)
		{
			maxProfit=0;
			//To get job with max profit
			for(int a=0;a<numOfJobs;a++)
			{
				if((Integer)jobs[3][a]==1)
				{
					continue;
				}
				else
				{
					if((Integer)jobs[2][a] > maxProfit)
					{
						maxProfit = (Integer)jobs[2][a];
						selectedIndex = a;
					}
				}
			}
			jobs[3][selectedIndex]=1;
			selectedDeadline = (Integer)jobs[1][selectedIndex];
			for(;selectedDeadline>0;selectedDeadline--)
			{
				if(sequence[selectedDeadline-1] == "EMPTY")
				{
					sequence[selectedDeadline-1] = (String)jobs[0][selectedIndex];
					totalProfit = totalProfit + (Integer)jobs[2][selectedIndex];
					//System.out.println("step: " + jobs[0][selectedIndex]);
					break;
				}
			}

			k++;
		}
	}

	void displayOutput()
	{
		System.out.print("\nScheduled jobs in order: ");
		for(int i=0;i<maxTime;i++)
		{
			if(sequence[i] != "EMPTY")
			{
				System.out.print(sequence[i] + "\t");
			}
		}
		System.out.println("\n");
		for(int j=0;j<maxTime;j++)
		{
			System.out.print(j + " | " + sequence[j] + " | ");
		}
		System.out.print(maxTime);
		System.out.println();
		System.out.println("Total Profit: " + totalProfit);
	}

	public static void main(String atrgs[])
	{
		jobSequencing obj = new jobSequencing();
		obj.inputItems();
		obj.setSequence();
		obj.displayOutput();
	}
}
//Time complexity O(n^2)