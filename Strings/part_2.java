package DSA_LoveBabbar.Strings;

import java.util.Arrays;

public class part_2 {

    //  REPLACE ALL OCCURRENCE OF A SUBSTRING

    static String stringAfterRemovingAllSubstring(String s, String part){

        while(s.contains(part)){

            int index = s.indexOf(part);

            s = s.substring(0,index) + s.substring(index + part.length());
        }
        return s;
    }

    //  PERMUTATION IN A STRING

    /*

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

     */

    static boolean permutationInString(String s1, String s2){

        // Check whether the s1 < s2 or not, then only permutation can help
        if(s1.length() > s2.length()){
            return false;
        }

        // Creating the two array i.e. one for s1 freq and second for window freq
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // for s1 element frequency
        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;

        }

        // for window element frequency
        for(int i = 0; i < s1.length();i++){
            windowFreq[s2.charAt(i) - 'a']++;
        }

//        check whether the both array frequency, match or not
        if(Arrays.equals(s1Freq, windowFreq)){
            return true;
        }

//        Sliding window
        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++){

//            Update right part of the window i.e. add next element to the window
            windowFreq[s2.charAt(right) - 'a']++;

            // update left part of the window i.e. remove last element from the window
            windowFreq[s2.charAt(left) - 'a']--;

            left++;

            // compare frequencies
            if(Arrays.equals(s1Freq, windowFreq)){
                return true;
            }
        }
    return false;

    }

    static void main() {


//        String s = "LIECLIEOLIEOLIEL";
//        String s = "XYZAXYZBXYZC";
//        String result = stringAfterRemovingAllSubstring(s,"LIE");
//        System.out.print("String after removing all sub string: "+result);

//        String s1 = "ab";
//        String s2 = "eidbaooo";

        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean s = permutationInString(s1,s2);
        System.out.print("Does the permutation elements from s1 is equal to the permutation element in s2: "+s);
    }
}
