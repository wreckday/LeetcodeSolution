import java.util.HashMap;

/**
  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function
  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

 Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 *
 * Created by Mellon on 8/15/16.
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        // hash table
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<magazine.length();i++){
            if(map.get(magazine.charAt(i))!=null){
                map.put(magazine.charAt(i), map.get(magazine.charAt(i))+1);
            }else{
                map.put(magazine.charAt(i), 1);
            }
        }

        // see if the ransomNote can be contructed from the map which is magazine
        for(int i=0;i<ransomNote.length();i++){
            if(map.get(ransomNote.charAt(i))==null || map.get(ransomNote.charAt(i))==0)
                return false;
            else{
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
            }
        }
        return true;
    }

    public static void main(String[] args){
        String ransomNote = "ab";
        String magazine = "ba";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
