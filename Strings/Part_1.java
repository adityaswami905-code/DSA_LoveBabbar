package DSA_LoveBabbar.Strings;

public class Part_1 {

    //  REVERSE WORDS IN A STRING

    /*

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


     */

    static String reverseWords(String s){

        StringBuilder ans = new StringBuilder();
        // starts from the endpoint of a given string
        int i = s.length()-1;

        while( i >= 0){

            // helps to remove the space from back side
            while( i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if( i < 0){
                break;
            }

            int j = i;
            // j-- until we get space with valid index
            while( j >= 0 && s.charAt(j) != ' '){
                j--;
            }

            // s.substring(indexInclusive, indexExclusive)
            ans.append(s.substring(j+1, i+1));

            while(j >= 0 && s.charAt(j) == ' '){
                 j--;
            }

            if( j >= 0){
                ans.append(' ');
            }

            i = j;
        }
        return ans.toString();
    }

    //  MOST FREQUENT CHARACTER

    /*

Given a string s of lowercase alphabets. The task is to find the maximum occurring character in the string s. If more than one character occurs the maximum number of times then print the lexicographically smaller character.

Examples:

Input: s = "testsample"
Output: 'e'
Explanation: 'e' is the character which is having the highest frequency.

Input: s = "output"
Output: 't'
Explanation: 't' and 'u' are the characters with the same frequency, but 't' is lexicographically smaller.

Constraints:
1 ≤ |s| ≤ 100



     */

    static char mostFrequentCharacter(String s){

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            freq[currChar - 'a']++;
        }

        int maxFreq = -1;
        char ans = 'a';

        for(int i = 0; i < 26; i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                ans = (char)(i + 'a');
            }
        }
        return ans;
    }

    //  REPLACE ALL OCCURRENCES OF A STRING WITH SPACE

    /*

Given a string and a substring, the task is to replace all occurrences of the substring with space. We also need to remove trailing and leading spaces created due to this.

Examples:

Input: str = "LIELIEILIEAMLIECOOL", sub = "LIE"
Output: I AM COOL By replacing all occurrences of Sub in Str with empty spaces, we extract the secret message as I AM COOL.

Input: str = "XYZAXYZBXYZC", sub = "XYZ"
Output: ABC By replacing all occurrences of Sub in Str with empty spaces, we extract the secret message as ABC.

Approach:

In the given string Str, replace all occurrences of Sub with empty spaces.
Remove unwanted empty spaces in start and end of the string.
Print the modified string.

     */

    static String replaceAllOccOfStrWithSpace(String str, String sub){
        return   str.replaceAll(sub," ");



    }



    static void main() {

//        String s = "the sky is blue";
//        String s = "  hello world  ";
//        String s = "a good   example";
//        String ans = reverseWords(s);
//        System.out.print("String after reversing the words:"+ans);

//        String s = "testsample";
//        String s = "output";
//        char ans = mostFrequentCharacter(s);
//        System.out.print("Most frequent character is: "+ans);

//        String str = "LIELIEILIEAMLIECOOL";
        String str = "XYZAXYZBXYZC";
        String result = replaceAllOccOfStrWithSpace(str,"XYZ");
        System.out.print("String after replacing all occurrence of sub with space: "+result);



    }
}
