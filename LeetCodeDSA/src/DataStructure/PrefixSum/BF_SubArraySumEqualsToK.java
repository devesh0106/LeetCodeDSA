package DataStructure.PrefixSum;

public class BF_SubArraySumEqualsToK {
    public int subarraySum(int[] nums, int k) {
        int count=0;;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BF_SubArraySumEqualsToK subArraySumEqualsToK = new BF_SubArraySumEqualsToK();
        System.out.println( subArraySumEqualsToK.subarraySum(new int[]{1,1,1},2));
    }
}
