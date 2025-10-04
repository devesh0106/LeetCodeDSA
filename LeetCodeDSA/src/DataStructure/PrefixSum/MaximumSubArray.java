package DataStructure.PrefixSum;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int winSum=0, maxSum=0;

        for(int winEnd=0;winEnd< nums.length;winEnd++){
            winSum+=nums[winEnd];
            maxSum=Math.max(winSum,maxSum);
            if(winSum<0){
                winSum=0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray= new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
