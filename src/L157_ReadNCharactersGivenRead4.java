/**
 The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function will only be called once for each test case.

 *
 * Created by Mellon on 9/8/16.
 */
public class L157_ReadNCharactersGivenRead4 extends Reader4{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(n == 0)
            return 0;
        int read = 0;
        char[] buffer4 = new char[4];
        while(true){
            int r = read4(buffer4);
            for(int i = 0; (i<r && read<n); i++){
                buf[read++]= buffer4[i];
            }
            if(r != 4)
                break;
        }
        return read;
    }

    public static void main(String[] args){
        // consider the following case
        String doc = "ab";
        int n = 1;
    }
}

class Reader4{
    public int read4(char[] buf){
        return 0;
    }
}


