package DSA_LoveBabbar.Arrays;

public class kedanesAlgorithm {

    //  MAXIMUM SUBARRAY

    static int getMaximumSubArraySum(int[] arr){
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
//            Step1 -> sum create karte hai

            sum = sum + arr[i];

//            Step2 -> maxi ki value update karte hai
            maxi = Math.max(sum,maxi);

//            Step3 -> sum check karte hai for negative value, kyon ki wo impact kar sakta hai sum ko
            if(sum < 0){
                sum = 0;
            }


        }
        return maxi;
    }

    static void main() {

//        int[] arr = { 5,4,-1,7,8};
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = getMaximumSubArraySum(arr);
        System.out.println(ans);

    }
}
