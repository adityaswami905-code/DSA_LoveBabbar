package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class part_4 {

//        FIND PEAK INDEX IN A MOUNTAIN ARRAY ( Array in which elements initially are in ascending order and at the end in descending order
//                                                i.e. array is divided into two parts left part (Ascending order elements) and right part (Descending order elements)
//    if arr is [1] or [1, 2] in this case this solution won't work. our arr must be min 3 elements containing peak for the solution

    static int peakIndexInMountainArray(int[] arr){

        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;


        while( start <= end){

            int mid = start + (end-start)/2;


            if(arr[mid] < arr[mid+1]){
                // Iska matlab hum array ke left part mein hai (i.e. ascending order elements ke bich)
                // To mujhe answers find karne ke liya i.e. peak index in mountain array ke liya right direction mein move karna hoga

                start = mid+1;
            }else{
//                arr[mid] >= arr[mid+1]
//                Iska matlab mera potential answer is part mein exist karta hai
                ans = mid;
//                Aur agar koi final answer exist karta ho toh mujhe left direction mein jana hoga kyoun ki hum abhi right part mein hoge (i.e. decending order elements ke bich mein), jaha current position ke elements se agar right lete hai toh usse chote element milege
                end = mid-1;
            }
        }
        return ans;
    }

    static void main() {

        int[] arr = {10,20,30,40,50,60,70,65,42,32};
        int ans = peakIndexInMountainArray(arr);
        System.out.print("Peak index in mountain array is: "+ans);


    }
}
