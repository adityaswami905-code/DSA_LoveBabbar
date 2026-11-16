package DSA_LoveBabbar;

import java.util.Scanner;

public class LP3_practical {

    static int knapsack(int W, int[] wt, int[] profit, int n) {

        int[][] dp = new int[n + 1][W + 1];

        for( int i = 0; i <= n; i++ ){

            for( int w = 0; w <= W; w++ ){

                if( i == 0 || w == 0 ){
                    dp[i][w] = 0;
                }
                else if( wt[i - 1] <= w ){
                    dp[i][w] = Math.max(
                            profit[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]
                    );
                }
                else{
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

     static void main() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] wt = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter weight and profit: ");

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        System.out.println(
                "Maximum Profit = " + knapsack(W, wt, profit, n)
        );

        sc.close();
    }
}


