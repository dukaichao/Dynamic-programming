package dkc_0408;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-04-08
 * Time:23:23
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len == 1) return cost[0];
        if(len == 2) return Math.min(cost[0],cost[1]);
        int[] arr = new int[len];
        arr[0] = cost[0];
        arr[1] = cost[1];
        for(int i = 2;i<len;i++){
            arr[i] = Math.min(arr[i-2]+cost[i],arr[i-1]+cost[i]);
        }
        return Math.min(arr[len-1],arr[len-2]);
    }
}
