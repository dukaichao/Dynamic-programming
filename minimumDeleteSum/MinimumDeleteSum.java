package minimumDeleteSum;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 *
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 注意:
 *
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 * User:Mr.Du
 * Date:2019-05-22
 * Time:22:46
 */
public class MinimumDeleteSum {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("lee","saasee"));
    }
    public static int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 1;i<=l1;i++){
            for(int j = 1;j<=l2;j++){
                if(i == 1)  dp[0][j] = dp[0][j-1]+s2.charAt(j-1);
                if(j == 1)  dp[i][0] = dp[i-1][0]+s1.charAt(i-1);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //保留时s2
                    int a = dp[i-1][j]+s1.charAt(i-1);
                    //保留时s1
                    int b = dp[i][j-1]+s2.charAt(j-1);
                    dp[i][j] = a<b?a:b;
                }
            }
        }
        return dp[l1][l2];
    }
}
