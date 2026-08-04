package DSA_LoveBabbar.Arrays;

import java.util.*;

public class arrayManipulationProblems {

    //  REVERSE AN ARRAY (***MOST IMPORTANT***)

    static void reverseArray(int[] arr){
        int i=0;
        int j=arr.length-1;

        while( i <= j){

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        System.out.print("Reversed array: ");

        for(int k : arr){
            System.out.print(k+" ");
        }

    }

    //  SHIFT ARRAY ELEMENTS BY 1 POSITION

    static void shiftArrayBY1Pos(int[] arr){
        int n = arr.length;
        int temp = arr[n-1];

        for (int i = n-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    //  PRINT AN EXTREME ELEMENT IN AN ALTERNATE MANNER

    static void alternateElement(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while( i <= j){

           if( i == j){
               System.out.print(arr[i]+" ");
               i++;  // or j--;
           }else{
               System.out.print(arr[i]+" ");
               i++;

               System.out.print(arr[j] +" ");
               j--;
           }
        }
    }

    //  FIND THE MODE OF THE ARRAY

    static int getMode(int[] arr){

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : arr){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

//        for(int i : freq.keySet()){
//            System.out.println(i+" -> "+ freq.get(i));
//        }

        int maxFreq = -1;
        int maxFreqWalikey = -1;

        for(int key : freq.keySet()){
            int currentKey = key;
            int currentKeyKiFreq = freq.get(key);

            if(currentKeyKiFreq > maxFreq){
                maxFreq = currentKeyKiFreq;
                maxFreqWalikey = currentKey;
            }
        }
        return maxFreqWalikey;
    }

    //  IDENTIFY ELEMENTS WITH HIGHEST AND LOWEST FREQUENCY

    static int[] identifyHighLowFreqElement(int[] arr){

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : arr){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        // For highest frequency element

        int maxFreq = Integer.MIN_VALUE;
        int maxFreqNum = -1;

        for(int key : freq.keySet()){
            int currentKey = key;
            int currentKeyKiFreq = freq.get(key);

            if(currentKeyKiFreq > maxFreq){
                maxFreq = currentKeyKiFreq;
                maxFreqNum = currentKey;
            }
        }

        // For lowest frequency element

        int lowFreq = Integer.MAX_VALUE;
        int lowFreqNum = -1;

        for(int key : freq.keySet()){
            int currentKey = key;
            int currentKeyKiFreq = freq.get(key);

            if(currentKeyKiFreq < lowFreq){
                lowFreq = currentKeyKiFreq;
                lowFreqNum = currentKey;
            }
        }
        int[] ans = {maxFreqNum,lowFreqNum};
        return ans;
    }

    //  SHIFT ARRAY ELEMENTS BY K POSITION

    static void shiftKPos(int[] arr,int k){
        int n = arr.length;
        int[] temp = new int[k];
        int j = n-1;

        for(int i = 0; i < k; i++){

            temp[i] = arr[j];
            j--;
        }

        for(int i = n-1; i >= k; i--){
            arr[i] = arr[i-k];
        }

        for(int i = 0; i < k; i++){
            arr[i] = temp[i];
        }


    }

    //  PRINT UNION OF ARRAY ELEMENTS

    static void unionArrayEle(int[] arr1,int[] arr2){

         int i = 0;
         int j = 0;

         while (i < arr1.length && j< arr2.length){

             if(arr1[i] > arr2[j]){
                 System.out.print(arr2[j]+" ");
                 j++;
             } else if (arr1[i] < arr2[j]) {
                 System.out.print(arr1[i]+" ");
                 i++;
             }else{
                 System.out.print(arr1[i]+" ");
                 i++;
                 j++;
             }
         }

         while (i < arr1.length){
             System.out.print(arr1[i]+" ");
             i++;
         }

         while (j < arr2.length){
             System.out.print(arr2[j]+" ");
             j++;
         }

        // Using hashset

//        HashSet<Integer> union = new HashSet<>();
//
//        for(int i : arr1){
//            union.add(i);
//        }
//
//        for (int i : arr2){
//            union.add(i);
//        }
//
//        for (int i : union){
//            System.out.print(i+" ");
//        }

    }

    static void main() {

//        int[] arr = {2,4,6,8,10};
//        reverseArray(arr);

//        int[] arr = {10,20,30,40,50};
//        shiftArrayBY1Pos(arr);
//        System.out.print("Array after shifting the elements by one position: ");
//        for(int i : arr){
//            System.out.print(i+" ");
//        }

//        int[] arr = {2,4,6,8,10,12};
//        alternateElement(arr);

//        int[] arr = {1,1,2,2,2,3,3,4,5,5,5,5,5,};
//        int ans = getMode(arr);
//        System.out.println(ans);

//        int[] arr = {1,1,2,1,2,2,4,5,4,5,1,6,5,7,7};
//        int[] ans = identifyHighLowFreqElement(arr);
//        System.out.println("Highest frequency number: "+ans[0]);
//        System.out.println("Lowest frequency number: "+ans[1]);

//        int[] arr = {1,2,3,4,5};
//        shiftKPos(arr,2);
//        for(int i : arr){
//            System.out.print(i+" ");
//        }

        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {2,4,6,8,10,12};
        System.out.print("Union array elements are: ");
        unionArrayEle(arr1,arr2);


    }
}
