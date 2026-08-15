package DSA_LoveBabbar.Strings;

public class part_3 {

    //  REMOVE ALL ADJACENT DUPLICATES IN STRING

    /*

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

     */

    static String removeAdjacentDuplicates(String s){

        StringBuilder ans = new StringBuilder();
        // here StringBuilder as a stack
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ans.length() > 0 && ans.charAt(ans.length()-1) == ch){
                ans.deleteCharAt(ans.length()-1);

            }else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    //  STRING COMPRESSION

    /*

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

Note: The characters in the array beyond the returned length do not matter and should be ignored.

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: 6
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].
Example 2:

Input: chars = ["a"]
Output: 1
Explanation: The only group is "a", which remains uncompressed since it is a single character.
After modifying the input array in-place, the first character of chars should be ["a"].
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: 4
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
After modifying the input array in-place, the first 4 characters of chars should be ["a","b","1","2"].

Constraints:

1 <= chars.length <= 2000
chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.

     */

    static int StringCompression(char[] chars){


        // As question says we have to make changes into the given array and do not create any new array
//        Therefore readIndex is used to read and writeIndex is used to write the actual content in an given array
        int readIndex = 0;
        int writeIndex = 0;

        while( readIndex < chars.length){

            char currentChar = chars[readIndex];

            int count = 0;

            while( readIndex < chars.length && currentChar == chars[readIndex]) {
                count++;
                readIndex++;

            }

                chars[writeIndex] = currentChar;
                writeIndex++;


                if(count > 1){

                    String countString = String.valueOf(count);

                    for(char ch : countString.toCharArray()){

                        chars[writeIndex] = ch;
                        writeIndex++;
                    }

                }

        }
        return writeIndex;
    }

    //  COMPRESS STRING

    /*

Given a string s, compress it by replacing each group of consecutive identical characters with the lowercase character followed by its frequency.

Uppercase and lowercase versions of the same letter are treated as identical.
If the same character appears again after a different character, it forms a new group.
Examples:

Input: s = "aaABBb"
Output: "a3b3"
Explanation: Treating uppercase and lowercase letters as the same, the string becomes "aaabbb". Thus, 'a' appears 3 times consecutively, followed by 'b' appearing 3 times.

Input: s = "aaacca"
Output: "a3c2a1"
Explanation: The first three 'a' characters form one group, followed by two 'c' characters. The last 'a' forms a separate group since it is not consecutive with the first one.

Constraints:
1 ≤ |s| ≤ 105
s contains only lowercase and uppercase characters.

     */

    static String copmressString(String s){

        StringBuilder ans = new StringBuilder();

        int readIndex = 0;

        while( readIndex < s.length()){
            char currentChar = Character.toLowerCase(s.charAt(readIndex));

            int count = 0;

            while( readIndex < s.length() && Character.toLowerCase(s.charAt(readIndex)) == currentChar){
                count++;
                readIndex++;

            }

            ans.append(currentChar);

            ans.append(count);

        }
        return ans.toString();
    }

    static void main() {

//        String s = "abbaca";
//        String s = "azxxzy";
//        String result = removeAdjacentDuplicates(s);
//        System.out.print("String after removing all adjacent duplicate elements: "+result);

//        char[] chars = {'a','a','b','b','c','c','c'};
//        char[] chars = {'a'};
//        char[] chars = {'a','a','b','b','b','b','b','b','b','b','b','b','b','b'};
//        int ans = StringCompression(chars);
//        System.out.print("Length of the compressed String is: "+ans);

//        String s = "aaABBb";
        String s = "aaacca";
        String result = copmressString(s);
        System.out.print("Compress String is: "+result);

    }
}
