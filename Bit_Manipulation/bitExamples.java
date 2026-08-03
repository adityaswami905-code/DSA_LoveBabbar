package DSA_LoveBabbar.Bit_Manipulation;

import java.util.Scanner;

public class bitExamples {

    public static void main(String[] args) {


//    Example(1): Check Even or Odd

        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number: ");
//        int n = sc.nextInt();
//        if((n & 1) == 0){
//            System.out.println("Even number");
//        }else{
//            System.out.println("Odd number");
//        }

        /*Instead of using % operator to check whether the number is even or odd , bit operator is used to give the fast solution
        Even Numbers --> last bit ==0
        Odd Numbers --> last bit ==1

        Example(2): Multiply by 2
                    n<<1

        Example(3): Divide by 2
                    n>>1

        Example(4): Power of 2


         */

//        TO COUNT THE NUMBER OF SET BIT (i.e. 1 bit)

//        int n1=2;
//        int count=0;
//        while(n1 != 0){
//            if ((n1&1)!=0){
//            mujhe ek set bit mil gaya (set bit means 1 bit)
//                count++;
//            }
//        Right shift to remove this bit
//            n1=n1>>1;
//        }
//
//
//        System.out.println("Set bit count: "+count);

//        TO CHECK WHETHER THE NUMBER IS THE POWER OF TWO OR NOT

        System.out.print("Enter the number to check, whether it is the power of 2 or not: ");
        int n= sc.nextInt();
        if((n & (n-1))==0){
            System.out.println("Aap 2 ke power ho");
        }else {
            System.out.println("App 2 ke power nhi ho");
        }

        //SWAP TWO NUMBERS USING XOR
        int a=5;
        int b=6;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("i.e. after swap :("+a+","+b+")");

        /*
        So basically if we break the logic of the above problem, then it will be

        step 1 -> a = a^b i.e. 5^6
        step 2 -> b = (a^b)^b that means here a=a^b and b=b i.e. (5^6)^6
        step 3 -> a = (a^b)^(a^b)^b that means here a=a^b and b=(a^b)^b i.e. (5^6)^(5^6)^6

        That's why a becomes 6 and b becomes 5
         */

//        FIND THE UNIQUE ELEMENT (OTHER APPEARS TWICE)

        /*
        So the logic is -> a ^ 0 = a
                        -> a ^ a = 0

        Therefore, let numbers be => 7,17,18,7,17,3,3
        so the unique will be => 7^17^18^7^17^3^3
        after cancelling out => 0^18
                             i.e. 18 (unique number)
         */

//            SO TO REMOVE THE LAST SET BIT FROM THE NUMBER WE USE => n & (n-1)
//                Similarly to get the last set bit we use => n & (-n)






    }


}
