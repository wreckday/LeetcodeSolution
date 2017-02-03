import java.util.HashMap;

/**
 Suppose we abstract our file system by a string in the following manner:

 The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

 dir
    subdir1
    subdir2
        file.ext
 The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

 The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

 dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
 The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

 We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

 Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

 Note:
 The name of a file contains at least a . and an extension.
 The name of a directory or sub-directory will not contain a ..
 Time complexity required: O(n) where n is the size of the input string.

 Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 *
 * Created by Mellon on 8/25/16.
 */
public class LongestAbsoluteFilePath {
//    Map to store the level and the length sum from root to current level.
//    level is calculated by how many 't' there.
//    length is preLevelLengthSum + current path length and ( + 1"/" if level bigger than 0)


    public static int lengthLongestPath(String input) {
        String[] strs = input.split("\\n");
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(-1, 0);
        for(int i = 0; i < strs.length; i++){
            int level =  strs[i].lastIndexOf('\t')  + 1;
            int length = map.get(level - 1) + strs[i].length() - level + (level > 0 ? 1 : 0);
            if(strs[i].indexOf('.') == -1){
                map.put(level, length);
            }else{
                max = Math.max(length, max);
            }
        }
        return max;
    }

    public static void main(String[] args){
        String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.print(lengthLongestPath(path));
    }
}
