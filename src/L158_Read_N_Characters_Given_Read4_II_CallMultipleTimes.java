/**
 The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function may be called multiple times.
 *
 * Created by Mellon on 10/11/16.
 */

public class L158_Read_N_Characters_Given_Read4_II_CallMultipleTimes extends Reader4 {
    char[] cache = new char[4] ;
    /*chache pointers*/
    int start =0;
    int end =0; // exclusive

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int idx =0;
        int remain = n;

        /*fill chars one by one*/
        while(remain > 0){
            if(start != end){ // cache has contents, copy one char
                buf[idx++] = cache[start++];
                remain --;
            }
            else{
                // cache is empty, reload.
                start = end =0;
                end  = read4(cache);

                if(end == 0) // nothing to read.
                    break;
            }
        }

        return idx;
    }
}
/*
consider doc = "ab", [read(1), read(2)]
expected: ["a", "b"]
*
* */