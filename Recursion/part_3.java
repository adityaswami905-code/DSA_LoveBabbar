package DSA_LoveBabbar.Recursion;

public class part_3 {

    //  RECURSION BASICS

//    NOTE => Sirf ek case ko solve kardo, baki recursion sambhal lega

    // PRINT MY NAME N TIMES

    static void printMyName(int n){

        // Base case
        if(n == 0){
            return;
        }

        // Processing
        System.out.println("Aditya");
        // Recursive relation
        printMyName(n-1);
    }

    //  PRINT 1 TO N

    static void print1ToN(int n, int count){

        // Base case
        if( count > n){
            return;
        }

        // Processing
        System.out.println(count);
        count++;

        // Recursive relation
        print1ToN(n,count);
    }

    //  PRINT N TO 1

    static void printNTo1(int n, int count){

        // Base case
        if(count > n){
            return;
        }

        // Recursive relation
        printNTo1(n, count+1);

        // Processing
        System.out.println(count);

        /*
        Another approach

        static void printNTo1(int n){

            if(n == 0){
                return;
            }

            System.out.println(n);
            printNTo1(n-1);

         */

    }

    //  PRINT ARRAY ELEMENTS

    static void printArrayElements(int[] arr, int i){

        // Base case
        if( i >= arr.length){
            return;
        }

        // processing
        System.out.println(arr[i]);

        // Recursive relation
        printArrayElements(arr, i+1);
    }

    //  FIND MAX ELEMENT

    static void findMax(int[] arr, int i, int maxi){

        // Base case
        if( i >= arr.length){
            System.out.println("Maximum value in an array is: "+maxi);
            return;
        }

        // Processing
        if(arr[i] > maxi){
            maxi = arr[i];
        }

        // Recursive relation
        findMax(arr,i+1,maxi);
    }

    //  FIND MIN ELEMENT

    static void findMin(int[] arr, int i , int mini){

        // Base case
        if( i >= arr.length){
            System.out.println("Minimum value in an array is: "+mini);
            return;
        }

        // Processing
        if(arr[i] < mini){
            mini = arr[i];

        }

        // Recursive relation
        findMin(arr,i+1,mini);
    }

    //  SEARCH ELEMENT IN AN ARRAY

    static  int findTarget(int[] arr, int i, int target){

        // Base case
        if( i >= arr.length){
            return -1;
        }

        // Processing
        if(arr[i] == target){
            return i;
        }

        // Recursive relation
        return findTarget(arr,i+1,target);
    }

    //  FIND COUNT OF A TARGET ELEMENT

    static void targetCount(int[] arr, int i, int target, int count){

        // Base case
        if(i >= arr.length){
            System.out.print("Count "+count);
            return;
        }

        // Processing
        if(arr[i] == target){
            count++;
        }

        // Recursive relation
        targetCount(arr,i+1,target,count);
    }

    //  PRINT DIGITS OF A NUMBER

    static void printDigit(int num){

        // Base case
        if(num == 0){
            return;
        }

        // 1 case khud solve karo
        int digit = num % 10;
        int n = num/10;

        // Baki recursion sambhal lega
        printDigit(n);

        System.out.println(digit);
    }

    static void main() {

//        printMyName(10);

//        print1ToN(5,1);

//        printNTo1(5,1);

//        int[] arr = {10,20,30,40,50};
//        int i = 0;
//        printArrayElements(arr,i);

//        int[] arr = {2,5,8,6,4,7,3};
//        int i = 0;
//        int maxi = Integer.MIN_VALUE;
//        findMax(arr,i,maxi);

//        int[] arr = {9,8,7,6,4,5,3,1,2};
//        int i = 0;
//        int mini = Integer.MAX_VALUE;
//        findMin(arr,i,mini);

//        int[] arr = {10,20,30,40,50};
//        int i = 0;
//        int target = 40;
//        int result = findTarget(arr,i,target);
//        System.out.print("Target found at index: "+result);

//        int[] arr = {10,10,10,40,10};
//        int i = 0;
//        int target = 10;
//        int count = 0;
//        targetCount(arr,i,target,count);

        printDigit(137);
    }

}
