package DSA_LoveBabbar.Arrays;

public class Part_3 {

    //  SORT AN ARRAY OF O'S AND 1'S

    static int[] sortedArray(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while( i < j){

            if(arr[i] == 1 && arr[j] == 0){
                //Swap
                arr[i] = 0;
                arr[j] = 1;
            }
            if (arr[i] == 0){
                i++;
            }

            if(arr[j] == 1){
                j--;
            }

        }
        return arr;
    }

    //  MISSING NUMBER {if all the elements are distinct i.e. {0,1,2,...n}

    static int missingElement(int[] arr){

        // Step1 -> xor karna hai sabhi array ke element ke saath
        // Step2 -> fir xor karna hai sabhi range ke saare numbers ke saath
        // step3 -> aur aakhri mein ans aagaya

        int xorSum = 0;
        // Step1
        for(int num : arr){
            xorSum = xorSum ^ num;
        }
        // Step2
        for(int i = 0; i <= arr.length; i++){
            xorSum = xorSum ^ i;
        }
        return xorSum;

    }

    //  FIND THE UNIQUE ELEMENT FROM THE ARRAY (where all other elements are occurring twice and any one element is occurring ones)

    static int findUniqueElement(int[] arr){
        int xorSum = 0;

        for(int n : arr){
            xorSum  = xorSum ^ n;
        }

        return xorSum;
    }

    //  SORT 0'S, 1'S AND 2'S

    static int[] sort012(int[] arr){

        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }



    static void main() {

//        int[] arr = {1,0,1,1,0,0,1,1,1};
//        int[] ans = sortedArray(arr);
//        System.out.print("Array after sorting 0's and 1's: ");
//        for(int i : ans){
//            System.out.print(i+" ");
//        }

//        int[] arr = { 1,3,0,5,6,2};
//        int ans = missingElement(arr);
//        System.out.print("Missing elements from the array is: "+ans);

//        int[] arr = {1,2,5,8,2,1,5};
//        int ans = findUniqueElement(arr);
//        System.out.print("Unique element is: "+ans);

        int[] arr = { 1,2,0,1,2,2,0,1,0};
        int[] ans = sort012(arr);
        for(int i : ans){
            System.out.print(i+" ");
        }



    }
}
