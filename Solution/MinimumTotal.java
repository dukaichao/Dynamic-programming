package Dynamicprogramming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-04-15
 * Time:22:20
 */
public class MinimumTotal {
    public static void main(String[] args) {
        System.out.println(minimumTotal(new ArrayList<List<Integer>>()));
        System.out.println(minimumTotal1(new ArrayList<List<Integer>>()));

    }

    public static int minimumTotal1(List<List<Integer>> list){
        int len = list.size();
        int[][] arr = new int[len+1][len+1];
        for(int i = len-1;i>=0;i--) {
            List<Integer> l = list.get(i);
            for (int j = 0; j < l.size(); j++) {
                arr[i][j] = Math.min(arr[i+1][j], arr[i][j + 1]) + l.get(j);
            }
        }
        return arr[0][0];
    }

    public static int minimumTotal(List<List<Integer>> list) {
        //if(list.size() == 0 || list == null) return 0;
        int len = list.size();
        int[] dp = new int[len+1];
        for(int i = len-1;i>=0;i--){
            List<Integer> l = list.get(i);
            for(int j = 0;j<l.size();j++){
                //dp[j]表示上一层的，然后在赋给当前层
                dp[j] = Math.min(dp[j],dp[j+1])+l.get(j);
            }
        }
        return dp[0];
    }
}
