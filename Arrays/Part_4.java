package DSA_LoveBabbar.Arrays;

import java.util.*;

public class Part_4 {

    //  TWO SUM (Where an array is given and we have to give the pair of element which gives equal number to target number by adding them)

    static int[] twoSum(int[] arr, int target){
        int n = arr.length;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    int[] ans = {arr[i],arr[j]};

                    // Similarly for the index pair
//                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        // Code yaha tak ayega he nahi wo line number 14 se he return ho jayega , ye sirf return type ka hack hai
        int[] ans = {};
        return ans;

    }

    //  THREE SUM ( Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.)

    static List<List<Integer>> threeSum(int[] arr){
        int n = arr.length;

        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){

                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);

                        Collections.sort(temp);
                        result.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    //  REMOVE DUPLICATES FROM SORTED ARRAY

    static int removeDuplicates(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = 1;

        // Assuming that array contains at least two elements

        while ( j < n){

            if(arr[i] == arr[j]){
                j++;
            }else{
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        return i+1;
    }

    //  FIND FIRST REPEATING ELEMENT

    static int findFirstRepeatingElement(int[] arr){

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for(int num : arr){
            frequency.put(num, frequency.getOrDefault(num,0)+1);
        }

        for(int num : arr){
            if(frequency.get(num) > 1)
                return num;
        }
        return -1;
    }

    //  FIND PIVOT INDEX (Where, the index from which left elements sum is equal to the right elements sum)

    static int pivotIndex(int[] arr){
        int n = arr.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = arr[0];
        for(int i = 1; i < n; i++){
            leftSum[i] = leftSum[i-1] + arr[i];
        }

        rightSum[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1] + arr[i];
        }

        for(int i = 0; i < n; i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }
        return -1;
    }

    static void main() {
//
//        int[] arr = {2,7,11,15};
//        int[] ans = twoSum(arr,9);
//        for(int num : ans){
//            System.out.print(num+" ");
//        }

//        int[] arr = {-1,0,1,2,-1,-4};
//        List<List<Integer>> ans = threeSum(arr);
//        System.out.println(ans);

//        int[] arr = {1,2,2,2,2,3,3,4};
//        int ans = removeDuplicates(arr);
//        System.out.print("Length of an array after removing duplicates: "+ans);

//        int[] arr = {2,4,6,8,1,2,7,8};
//        int ans = findFirstRepeatingElement(arr);
//        System.out.print("First repeating element is: "+ans);

        int[] arr = { 1,3,7,6,5,6};
        int ans = pivotIndex(arr);
        System.out.print("Pivot index is: "+ans);

    }
}
