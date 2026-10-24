package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class stockSpan {

    //  ONLINE STOCK SPAN (LEET CODE VERSION)

    /*

    Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days are [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal to 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.

Example 1:
Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]
Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6


Constraints:
1 <= price <= 105
At most 104 calls will be made to next.

     */


    static class StockSpanner {

        // Store {price, span} for previous days
        private Deque<int[]> st;

        public StockSpanner() {
            st = new ArrayDeque<>();
        }

        public int next(int price) {

            int span = 1;

            // Removing previous prices <= today's price
            while(!st.isEmpty() && st.peek()[0] <= price) {
                span += st.pop()[1];
            }

            // Store today's price and its calculated span
            st.push(new int[]{price, span});

            return span;
        }
    }

    //  STOCK SPAN PROBLEM (GFG VERSION)

    /*

    The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days.

Given an array arr[] representing daily stock prices, the stock span for the i-th day is the number of consecutive days up to day i (including day i itself) for which the price of the stock is less than or equal to the price on day i. Return the span of stock prices for each day in the given sequence.

Examples:

Input: arr[] = [100, 80, 90, 120]
Output: [1, 1, 2, 4]
Explanation: Consider each day one by one:
Day 1 (100): Span = 1.
Day 2 (80): Span = 1 because the previous price (100) is greater than 80.
Day 3 (90): Span = 2 because 80 ≤ 90, but 100 > 90.
Day 4 (120): Span = 4 because 100, 80, and 90 are all less than or equal to 120.
Hence, the output is [1, 1, 2, 4].

Input: arr[] = [10, 4, 5, 90, 120, 80]
Output: [1, 1, 2, 4, 5, 1]
Explanation: Consider each day one by one:
Day 1 (10): Span = 1.
Day 2 (4): Span = 1 because the previous price (10) is greater than 4.
Day 3 (5): Span = 2 because 4 ≤ 5, but 10 > 5.
Day 4 (90): Span = 4 because 10, 4, and 5 are all less than or equal to 90.
Day 5 (120): Span = 5 because all previous prices are less than or equal to 120.
Day 6 (80): Span = 1 because the previous price (120) is greater than 80.
Hence, the output is [1, 1, 2, 4, 5, 1].

Constraints:
1 ≤ arr.size(), arr[i] ≤ 105

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)

Company Tags
Flipkart    Accolite    Amazon  Microsoft   Samsung Adobe   NPCI

     */

    static ArrayList<Integer> calculateSpan(int[] arr){

        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();

        // processing each day price
        for( int i = 0; i < n; i++ ){

            // removing previous days with price  <= today's price
            while( !st.isEmpty() && arr[st.peek()] <= arr[i] ){
                st.pop();
            }

            // calculating span
            if( st.isEmpty() ){

                span.add(i+1);
            }
            else{

                span.add(i-st.peek());
            }
            // storing current day index
            st.push(i);
        }

        return span;
    }


    static void main() {

        StockSpanner stockSpanner = new StockSpanner();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        for(int price : prices) {
            int span = stockSpanner.next(price);

            System.out.println(
                    "Price: " + price + ", Span: " + span
            );
        }

        int[] arr = {10, 4, 5, 90, 120, 80};
        ArrayList<Integer> ans = calculateSpan(arr);
        System.out.print("Span: ");
        for( int a : ans ){

            System.out.print(a+" ");
        }
        System.out.println("(GFG version)");
    }
}
