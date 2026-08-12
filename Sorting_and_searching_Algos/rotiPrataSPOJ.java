package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class rotiPrataSPOJ {

    //  ROTI PRATA SPOJ
    /*

    IEEE is having its AGM next week and the president wants to serve cheese prata after the meeting.
    The subcommittee members are asked to go to food connection and get P (P ≤ 1000) pratas packed for the function.
    The stall has L cooks (L ≤ 50) and each cook has a rank R (1 ≤ R ≤ 8).
    A cook with a rank R can cook 1 prata in the first R minutes 1 more prata in the next 2R minutes, 1 more prata in 3R minutes and so on (he can only cook a complete prata)
    (For example if a cook is ranked 2, he will cook one prata in 2 minutes one more prata in the next 4 mins an one more in the next 6 minutes hence in total 12 minutes he cooks 3 pratas in 13 minutes also he can cook only 3 pratas as he does not have enough time for the 4th prata).
    The webmaster wants to know the minimum time to get the order done. Please write a program to help him out.

     */

//    static boolean isValidSol(int arr[], int parathas, int maxTime) {
//        int parathaCount = 0;
//
//        for(int i = 0 ; i < arr.length; i++) {
//            int timeTaken = 0;
//
//            for(int j=1; timeTaken + arr[i]*j <= maxTime; j++) {
//                timeTaken += arr[i]*j;
//                parathaCount++;
//                if(parathaCount >= parathas) return true;
//            }
//        }
//        return parathaCount >= parathas;
//    }

    static boolean isValidSol(int p, int[] cooks, int minTime){

        int parathaCount = 0;

        for(int i = 0; i < cooks.length; i++){
            int currentCookRank = cooks[i];
            int timeTaken = 0;
            int j = 1;

//            For cook rank 1
//            Time taken -> 1R 2R 3R ...
//            Similarly for cook rank 2
//            Time taken -> 2R 4R 6R ...
//            So above j represent coefficient of R(i.e. no of paratha cooked)

            while (parathaCount <= p) {

                if (timeTaken + j * currentCookRank <= minTime) {
                    timeTaken = timeTaken + j * currentCookRank;
                    parathaCount++;
                    j++;

                } else {
                    break;
                }
            }
        }
        if(parathaCount >= p){
            return true;
        }else{
            return false;
        }
    }

    static int minTimeTakenTOCookPrata(int p, int[] cooks, int n){

//        Where, p -> no. of pratas
//               n -> no. of cook

        int maxRank = -1;
        for(int i = 0; i < cooks.length; i++){

            if(cooks[i] > maxRank){
                maxRank = cooks[i];
            }
        }

        int s = 0;
//        If cook one takes 1R, 2R, 3R, 4R, 5R....up to nR
//        Then it becomes R(1+2+3+4+5...n)
//        i.e. R(n * (n+1)/2);

        int e = maxRank * (p*(p+1)/2);
        int ans = -1;

        while( s <= e){

            int mid = s + (e-s)/2;

            if(isValidSol(p,cooks,mid)){
                ans = mid;
                e = mid-1;

            }else{
                s = mid+1;

            }
        }
        return ans;
    }



    static void main() {

        int[] cooks = {1,2,3,4};
        int ans = minTimeTakenTOCookPrata(10,cooks,4);
        System.out.print("Minimum time taken by the cooks to cook paratha's: "+ans);
    }
}
