import java.util.ArrayList;
import java.util.Scanner;

public class ChangeManageClass {
	
	static ArrayList<Integer> totalSet = new ArrayList<Integer>();

	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		int []coins = {1,5,10,25};
		
		System.out.println("Change Management Algorithim \n\n");
		
		System.out.println("Enter the total of change : ");
		int total = input.nextInt();
		
		System.out.println("Press  1 for Greedy Algorithm and 2 Dynamic Programming \n ");

		int choice = input.nextInt();
		
        if (choice == 1){
                dynamicPogramming(total,coins);
            
        }else if(choice == 2){
				greedyAlgorithm(total,coins);
		}
		
		result();
	}
	
	public static int greedyAlgorithm(int total,int[] coins){
		
		for(int i=coins.length-1; i >= 0 && total > 0;i--){
			int n = (total / coins[i]);
            
				for(int j=0; j<n; j++){
			
                    total -=coins[i];
					totalSet.add(coins[i]);
				
                }
		}
		return totalSet.size();
	}
	
	public static void result(){
		System.out.println("Number of coins = " + totalSet.size());
		for ( int i =0;i<totalSet.size();i++){
			System.out.println(totalSet.get(i));
		}
	}

	public static int dynamicPogramming(int total,int[] coins){
		
		int[] dp = new int[total+1];
		int[] prevCoin = new int[total+1];  
		dp[0]=0;
		for(int j=1;j<=total;j++){
			dp[j]=Integer.MAX_VALUE;
			for(int i=0;i<coins.length;i++){
				if(coins[i]<=j && (1+dp[j-coins[i]] < dp[j]) ){               
					dp[j]=1+dp[j-coins[i]];
					prevCoin[j]=coins[i];
				}                   
			}
		}

		int result = dp[total];
		for(int i=total;i>=1;){
			totalSet.add(prevCoin[i]);
			int j=i;
			i=total-prevCoin[i];
			total = total - prevCoin[j];
		}
		return totalSet.size();
	}


}

