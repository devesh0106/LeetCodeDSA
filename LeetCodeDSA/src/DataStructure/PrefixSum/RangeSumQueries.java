package DataStructure.PrefixSum;
/*
* 1 to 3 in arr = [2,4,6,8,10]. => 18
* */
public class RangeSumQueries {
    public int sumRange(int[] arr){
        int  sum=0;
        for(int i=1;i<=3;i++){
            sum+=arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        RangeSumQueries rangeSumQueries = new RangeSumQueries();
        System.out.println( rangeSumQueries.sumRange(new int[]{2,4,6,8,10}));
    }
}
