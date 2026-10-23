package DSA_LoveBabbar.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class simplifyPath {

    //  SIMPLIFY PATH

    /*

    You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:

A single period '.' represents the current directory.
A double period '..' represents the previous/parent directory.
Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
The simplified canonical path should follow these rules:

The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
The path must not end with a slash '/', unless it is the root directory.
The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
Return the simplified canonical path.

Example 1:
Input: path = "/home/"
Output: "/home"
Explanation:
The trailing slash should be removed.

Example 2:
Input: path = "/home//foo/"
Output: "/home/foo"
Explanation:
Multiple consecutive slashes are replaced by a single one.

Example 3:
Input: path = "/home/user/Documents/../Pictures"
Output: "/home/user/Pictures"
Explanation:
A double period ".." refers to the directory up a level (the parent directory).

Example 4:
Input: path = "/../"
Output: "/"
Explanation:
Going one level up from the root directory is not possible.

Example 5:
Input: path = "/.../a/../b/c/../d/./"
Output: "/.../b/d"
Explanation:
"..." is a valid name for a directory in this problem.

Constraints:
1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.

     */

    static String simplifyDirectoryPath(String path){

        Deque<String> st = new ArrayDeque<>();

        String[] parts = path.split("/");

        for( String part : parts ){

            // if path is empty
            if( part.isEmpty() ){
                // ignore
                continue;
            }

            if( part.equals(".") ){
                // ignore
                continue;
            }

            if( part.equals("..") && st.isEmpty() ){
                // ignore
                continue;
            }

            if( part.equals("..") && !st.isEmpty() ){
                // previous directory
                st.pop();
            }
            else{
                // file name
                st.push(part);
            }
        }

        // if stack empty then simply return "/"
        if( st.isEmpty() ){
            return "/";
        }
        else{

            StringBuilder str = new StringBuilder();

            while( !st.isEmpty() ){
                str.append("/");
                str.append(st.removeLast());

            }
            // also if we used .reverse() method then output string also gets reversed due to which (we can handle that issue, but now we decided to, not to use it)
            // here .reverse() is not used because in above while loop we used .removeLast() method
            //The removeLast() method simply takes away and returns the very last item at the back of a line (deque).
            //Think of it like taking the last person out of a moving line:
            // If there are items in the line, it grabs the last one, removes it, and shows it to you.
            // If the line is completely empty, it gets confused because there is nothing to take, and it crashes your program with an error (NoSuchElementException).
            return str.toString();
        }
    }

    static void main() {

        String path = "/.../a/../b/c/../d/./";
        String ans = simplifyDirectoryPath(path);
        System.out.println(
                "Simplified Path: " + ans
        );
    }
}
