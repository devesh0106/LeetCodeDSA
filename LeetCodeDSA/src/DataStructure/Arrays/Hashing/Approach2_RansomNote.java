package DataStructure.Arrays.Hashing;

public class Approach2_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for(char ch : magazine.toCharArray()){
            arr[ch - 'a']++;
        }

        for(char ch : ransomNote.toCharArray()){
            if(arr[ch - 'a'] == 0){
                return false;
            }

            arr[ch - 'a']--;
        }

        return true;
    }
    public static void main(String[] args) {
        Approach2_RansomNote ransomNote = new Approach2_RansomNote();
        boolean res= ransomNote.canConstruct("aa","aab");
        System.out.println(res);
    }
}

