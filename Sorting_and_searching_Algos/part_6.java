package DSA_LoveBabbar.Sorting_and_searching_Algos;

public class part_6 {

    //  SQUARE ROOT(X) ( SQUARE ROOT USING BINARY SEARCH ) { Only for +ve integers }

    static int sqrt(int x){

        int s = 1; // So to handle the edge case of 0 we start it from 1 index
        int e = x;
        int ans = -1;

        if(x == 0){
            return 0;
        }

        while( s <= e){

            int mid = s + (e-s)/2;

//            Also to handle large value which is generated i.e. mid * mid
//            To handle such large value, we can rewrite formula as mid * mid = x, as mid = x/mid;

            if( mid == x/mid){
                return mid;
            } else if (mid > x/mid) {
                // move to left part
                e = mid-1;
            }else{
//                mid * mid < x
//                Hum jaha par hai waha potential answer exists karta hoga
                ans = mid;
//                Final answer find karne ke liye hame right me move karna hoga
                s = mid+1;
            }
        }
        return ans;
    }

    //  SQUARE ROOT(X) ( Now this time we find the ans with including precision values e.g. sqrt(57) => instead of 7 our answer will be 7.549)

    static double sqrtPrecision(int x){

        int s = 1;
        int e = x;
        double ans = -1;

        if( x == 0){
            return 0;
        }

        while( s <= e){

            int mid = s + (e-s)/2;

            if(mid == x/mid){
                return mid;

            } else if (mid > x/mid) {
                e = mid-1;

            }else{
                ans = mid;
                s = mid+1;
            }
        }

        double factor = 1;
        int precisionValue = 3;


        for(int round = 1; round <= precisionValue; round++){

            factor = factor / 10;

            while ((ans + factor) * (ans + factor) <= x){
                ans += factor;
            }


        }



        return ans;
    }

    static void main() {

//        int ans = sqrt(57);
//        System.out.print("Square root is: "+ans);

        double ans = sqrtPrecision(57);
        System.out.print("Square root with precision value is: "+ans);;

    }
}
