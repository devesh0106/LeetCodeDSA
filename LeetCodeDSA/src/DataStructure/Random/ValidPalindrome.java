package DataStructure.Random;

public class ValidPalindrome {
    public boolean validPalindromes(String str){
        //Step 1 : to remove white spaces from string
        //Step 2 : calculate mid index
        //Step 3 : reverse string
        //Step 4: compare(equals) left and right string
        String newStr = str.replaceAll("\\s","");
        System.out.println(newStr);

        int length = newStr.length();
        System.out.println(length);
        int midindex= (length/2);
        System.out.println(midindex);

        String left= newStr.substring(0,9).toLowerCase();
        String right = newStr.substring(10);

        char[] rightStr = right.toCharArray();
        String revRight = "";

        for(int i=rightStr.length-1;i>=0;i--){
            revRight+=rightStr[i];
        }

        System.out.println("Left :"+left + ", Right : "+right+ ", Rev Right :"+revRight);
        return left.equals(revRight.toLowerCase());
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean res= validPalindrome.validPalindromes("Was it a car or a cat I saw");
        System.out.println(res);
    }
}
