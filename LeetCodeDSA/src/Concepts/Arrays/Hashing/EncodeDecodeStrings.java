package Concepts.Arrays.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
        //Step 1 : Take length of each string in list.
        //Step 2 : Append lenghth as String with delimiter
        // Step 3 : Append '#'
        // Step 4 : append strings and return String
* */
public class EncodeDecodeStrings {
    public String encode(List<String> strs){
    StringBuilder res = new StringBuilder();
    for(String s: strs){
        res.append(s.length()).append('#').append(s);
    }
        return  res.toString();
    }
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
    public static void main(String[] args) {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        List<String> strs = Arrays.asList("neet","code","love","you");
        String encoded = encodeDecodeStrings.encode(strs);
        System.out.println("Encoded : "+encoded);
        System.out.println("Decoded : "+encodeDecodeStrings.decode(encoded));
    }
}
