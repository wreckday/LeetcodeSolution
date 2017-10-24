/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * <p>
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * <p>
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * <p>
 * Note:
 * The read function will only be called once for each test case.
 * <p>
 * <p>
 * Created by Mellon on 9/8/16.
 */
public class L157_ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */

    /*
    這一題就是題目給一個 讀4個字的的API, 讓你寫一個可以讀n 個字的API, 而且讀四個字的API 會傳回一個數值, 這個數值代表讀了多少字, 如果檔案裡只剩3個字, API 會傳回3,
    那我們就知道已經全部讀完了, 也就不需要再讀了。有幾種情況需要考慮,
    1.


    重點是 (i < remain && read < n)
    * */
    public int read(char[] buf, int n) {
        if (n == 0) return 0;
        int read = 0;

        char[] buffer4 = new char[4];

        while (true) {
            int remain = read4(buffer4);
            for (int i = 0; (i < remain && read < n); i++) {
                buf[read++] = buffer4[i];
            }
            if (remain != 4)
                break;
        }
        return read;
    }

    public static void main(String[] args) {
        // consider the following case
        String doc = "ab";
        int n = 1;
    }
}

class Reader4 {
    public int read4(char[] buf) {
        return 0;
    }
}


